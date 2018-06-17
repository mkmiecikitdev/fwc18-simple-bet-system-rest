package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static eu.bambz.fwc18simplebetsystem.infrastructure.security.TokenAuthenticationService.getAuthFromToken;

class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        Authentication authentication =
                getAuthFromToken((HttpServletRequest)request);

        if(hasResponseNoToken((HttpServletResponse) response)) {
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }

    private boolean hasResponseNoToken(HttpServletResponse response) {
        return !response.containsHeader(TokenAuthenticationService.HEADER_STRING);
    }
}
