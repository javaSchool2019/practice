package training.endava.app.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import training.endava.app.logger.YellowPagesLogger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

@Component
public class MyFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
        LOGGER.info("" + var1.getServerPort());
        var3.doFilter(var1, var2);
    }

}
