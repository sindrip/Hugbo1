package is.hi.hirslan.security;


        import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

        import static is.hi.hirslan.security.SecurityConstants.HEADER_STRING;
        import static is.hi.hirslan.security.SecurityConstants.SECRET;
        import static is.hi.hirslan.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            System.out.println("cookieshere=========");
            Arrays.stream(cookies)
                    .forEach(c -> System.out.println(c.getName() + "=" + c.getValue()));
        }

        String token;
        try {
            token = Arrays.stream(req.getCookies())
                    .filter(c -> c.getName().equals(HEADER_STRING))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
         } catch (Exception e) {
            chain.doFilter(req, res);
            return;
        }

        if (token == null || !token.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        System.out.println("getauth");
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
        String token = Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals(HEADER_STRING))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (token != null) {
            // parse the token.
            String user;
            try {
                user = Jwts.parser()
                        .setSigningKey(SECRET.getBytes())
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
            } catch (Exception e) {
                return null;
            }

            if (user != null) {
//                System.out.println(user);
//                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
//                grantedAuths.add(new SimpleGrantedAuthority("USER"));
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}