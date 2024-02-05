package org.example.filter;

import org.example.data.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.data.UserType.ADMIN;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        if (request.getParameter("command").equals("SHOW_ADMIN_SETTINGS_PAGE")){
            User user = (User) session.getAttribute("user");
            if (user.getUserType() != ADMIN) {
                httpServletResponse.sendRedirect(COMMAND_SHOW_CHAT_PAGE);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
