package training.endava.app.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter extends GenericFilterBean {

    private static final Logger LOGGER = Logger.getLogger(CustomFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LOGGER.info("Request made by client with ip " + getClientIpAddress(request) + " -> " + request.getMethod() + " " + request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private static String getClientIpAddress(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
        }
    }
}
