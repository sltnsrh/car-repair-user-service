package com.salatin.userservice.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salatin.userservice.exception.ApiExceptionObject;
import com.salatin.userservice.security.BlacklistRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Log4j2
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    private static final String JSON_TYPE = "application/json";
    private static final String USER_UNAUTHORIZED_MESSAGE =
            "The user is unauthorized. Please go to the authorization page and log in.";
    private static final String AUTHORIZATION_HEADER = "Authorization";

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;
    private final BlacklistRepository blacklistRepository;

    @Override
    public void doFilterInternal(
            @NotNull HttpServletRequest servletRequest,
            @NotNull HttpServletResponse servletResponse,
            @NotNull FilterChain filterChain
    ) throws IOException {
        String token = jwtTokenProvider
                .resolveToken(servletRequest.getHeader(AUTHORIZATION_HEADER));
        if (token != null) {
            if (blacklistRepository.isLoggedOut(token) || userFailedAuthentication(token)) {
                log.info("The user is logged out or authentication failed");
                setUnauthorizedResponseException(servletResponse);
                return;
            }
        }
        doFilter(filterChain, servletRequest, servletResponse);
    }

    private boolean userFailedAuthentication(String token) {
        if (jwtTokenProvider.validateToken(token)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return false;
        }
        return true;
    }

    private void setUnauthorizedResponseException(HttpServletResponse servletResponse)
            throws IOException {
        servletResponse.setContentType(JSON_TYPE);
        ApiExceptionObject message = new ApiExceptionObject(
                USER_UNAUTHORIZED_MESSAGE,
                HttpStatus.UNAUTHORIZED,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        servletResponse.getWriter().write(objectMapper.writeValueAsString(message));
        servletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    private void doFilter(
            FilterChain filterChain, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (IllegalArgumentException | ServletException e) {
            setUnauthorizedResponseException(response);
        }
    }
}
