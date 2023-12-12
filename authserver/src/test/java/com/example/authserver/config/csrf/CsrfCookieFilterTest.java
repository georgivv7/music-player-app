package com.example.authserver.config.csrf;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.HandlerExceptionResolver;

import static org.mockito.Mockito.*;

class CsrfCookieFilterTest {

    @Test
    void shouldSuccessfullySetCsrfToken() throws Exception {

        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HandlerExceptionResolver exceptionResolver = mock(HandlerExceptionResolver.class);

        CsrfToken csrfToken = mock(CsrfToken.class);
        when(request.getAttribute("_csrf")).thenReturn(csrfToken);

        CsrfCookieFilter csrfFilter = new CsrfCookieFilter(exceptionResolver);

        // Act
        csrfFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(request, response);
        verify(request).getAttribute("_csrf");
        verify(csrfToken).getToken();

    }

    @Test
    public void testCsrfFilterWithException() throws Exception {
        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        HandlerExceptionResolver exceptionResolver = mock(HandlerExceptionResolver.class);

        CsrfToken csrfToken = mock(CsrfToken.class);
        when(request.getAttribute(anyString())).thenReturn(csrfToken);

        CsrfCookieFilter csrfFilter = new CsrfCookieFilter(exceptionResolver);

        // Simulate an exception when the filter chain is invoked
        doThrow(new ServletException()).when(filterChain).doFilter(any(HttpServletRequest.class), any(HttpServletResponse.class));

        // Act
        csrfFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(exceptionResolver).resolveException(any(HttpServletRequest.class), any(HttpServletResponse.class), eq(null), any(ServletException.class));
    }

}