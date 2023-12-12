package com.example.authserver.config.csrf;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SpaCsrfTokenRequestHandlerTest {
    @Test
    void testHandle() {
        // Arrange
        SpaCsrfTokenRequestHandler spaCsrfTokenRequestHandler = new SpaCsrfTokenRequestHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Supplier<CsrfToken> csrfTokenSupplier = () -> new DefaultCsrfToken("Header Name", "Parameter Name", "ABC123");

        // Act
        spaCsrfTokenRequestHandler.handle(request, response, csrfTokenSupplier);

        // Assert
        CsrfToken csrfToken = csrfTokenSupplier.get();
        assertNotNull(csrfToken);
        assertEquals("Header Name", csrfToken.getHeaderName());
        assertEquals("Parameter Name", csrfToken.getParameterName());
        assertEquals("ABC123", csrfToken.getToken());
    }

    @Test
    void testResolveCsrfTokenValue_withoutHeader() {
        SpaCsrfTokenRequestHandler spaCsrfTokenRequestHandler = new SpaCsrfTokenRequestHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertNull(spaCsrfTokenRequestHandler.resolveCsrfTokenValue(request,
                new DefaultCsrfToken("Header Name", "Parameter Name", "ABC123")));
    }

    @Test
    void testResolveCsrfTokenValue_withHeader() {
        // Arrange
        SpaCsrfTokenRequestHandler spaCsrfTokenRequestHandler = new SpaCsrfTokenRequestHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        String headerName = "Header Name";
        String headerValue = "ABC123";
        request.addHeader(headerName, headerValue);

        // Act
        String result = spaCsrfTokenRequestHandler.resolveCsrfTokenValue(request,
                new DefaultCsrfToken(headerName, "Parameter Name", headerValue));

        // Assert
        assertNotNull(result);
        assertEquals(headerValue, result);
    }

}
