package training.endava.app.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CustomFilter extends GenericFilterBean {
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println(servletRequest.getRemotePort());
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
