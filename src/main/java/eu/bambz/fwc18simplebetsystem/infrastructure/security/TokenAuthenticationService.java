package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.bambz.fwc18simplebetsystem.domain.players.api.PlayerType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.util.Collections.emptyList;

/**
 * Created by bambo on 02.06.2017.
 */
public class TokenAuthenticationService {

    private static final long EXPIRATIONTIME = 864_000_000; // 10 days
    private static final String SECRET = "ThisIsASecret";
    private static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static void addAuthToToken(HttpServletResponse res, PlayerType playerType) throws JsonProcessingException {
        String s = generateJWT(playerType);
        res.addHeader(HEADER_STRING, s);
    }

    static Authentication getAuthFromToken(HttpServletRequest request) throws IOException {
        PlayerType playerType = getUser(request.getHeader(HEADER_STRING));
        return playerType != null ?
                new UsernamePasswordAuthenticationToken(playerType, null, emptyList()) :
                null;
    }

    private static String generateJWT(PlayerType playerType) throws JsonProcessingException {
        return TOKEN_PREFIX + " " + Jwts.builder()
                .setSubject(objectMapper.writeValueAsString(playerType))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    private static PlayerType getUser(String token) throws IOException {
        if (token == null) return null;

        String subject = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return objectMapper.readValue(subject, PlayerType.class);
    }
}

