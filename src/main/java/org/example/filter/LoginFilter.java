package org.example.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;
import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        // Ваша релизация фильтра входа пользователя на сайт
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("user") == null) {
            if (!request.getParameter("command").equals("login")) {
                httpServletRequest.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
