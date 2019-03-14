package training.endava.app.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import training.endava.app.logging.LOGGER;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@Component
public class PortLoggingFilter extends GenericFilterBean {
    private Logger logger = LOGGER.getInstanceWithFileHandler(this.getClass().getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("New client at port: " + servletRequest.getRemotePort());
    }
}