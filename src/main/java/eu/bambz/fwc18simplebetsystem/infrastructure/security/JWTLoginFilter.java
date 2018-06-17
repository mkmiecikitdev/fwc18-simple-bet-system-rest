package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static eu.bambz.fwc18simplebetsystem.infrastructure.security.TokenAuthenticationService.addAuthToToken;
import static java.util.Collections.emptyList;

/**
 * Created by bambo on 02.06.2017.
 */
class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        LoginFormDto loginFormDto = new ObjectMapper()
                .readValue(req.getInputStream(), LoginFormDto.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginFormDto.getLogin(),
                        loginFormDto.getPassword(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        User user = (User) auth.getPrincipal();
        addAuthToToken(res, user.getPlayerType());
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(user.getPlayerType(), null, emptyList()));
        chain.doFilter(req, res);
    }
}

