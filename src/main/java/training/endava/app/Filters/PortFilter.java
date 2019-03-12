package training.endava.app.Filters;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class PortFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Server port: "+servletRequest.getServerPort());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
