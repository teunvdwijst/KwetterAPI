package rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Teun
 */
@Provider
@JWToken
@Priority(Priorities.AUTHENTICATION)
public class JWTokenFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        String header = crc.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (header.isEmpty()) {
            crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }

        String token = header.substring("Bearer ".length()).trim();

        try {
            Algorithm a = Algorithm.HMAC512("Auth_0_JWT_secret");
            JWTVerifier v = JWT.require(a).withIssuer("KwetterBV").build();
            DecodedJWT decoded = v.verify(token);
            String username = decoded.getSubject();
            SecurityContext sc = crc.getSecurityContext();

            crc.setSecurityContext(new SecurityContext() {
                @Override
                public Principal getUserPrincipal() {
                    return () -> username;
                }

                @Override
                public boolean isUserInRole(String string) {
                    return true;
                }

                @Override
                public boolean isSecure() {
                    return sc.isSecure();
                }

                @Override
                public String getAuthenticationScheme() {
                    return "Bearer ";
                }
            });
        } catch (JWTVerificationException | UnsupportedEncodingException | IllegalArgumentException ex) {
            crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
