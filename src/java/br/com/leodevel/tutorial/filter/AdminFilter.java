package br.com.leodevel.tutorial.filter;

import br.com.leodevel.tutorial.entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        User user = null;
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (session != null) {
            user = (User) session.getAttribute("userLoggedIn");
        }

        if (user == null) {
            String contextPath = ((HttpServletRequest) request)
                    .getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath
                    + "/faces/index.xhtml");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }

}