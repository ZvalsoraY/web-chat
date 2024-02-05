package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


import static org.example.Resources.COMMAND_SHOW_ADMIN_SETTINGS_PAGE;
import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class BanCommand  implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("userName");
        String loginL = request.getParameter("userLLogin");
        System.out.println(loginL);
        Optional<User> user = DataBase.findByLogin(loginL);

        if (user.isPresent()){
            if (user.get().isReadOnly()){
                user.get().setReadOnly(false);
            } else {
                user.get().setReadOnly(true);
            }
        }
//        user.get().setReadOnly(true);
//        request.setAttribute("user", user.get());
//        System.out.println(user.get().getName() + " BAN " + user.get().isReadOnly());
        return new RedirectResult(COMMAND_SHOW_ADMIN_SETTINGS_PAGE);

        //System.out.println(user.get().getName() + " BAN " + user.get().isReadOnly());
        //return new RedirectResult(COMMAND_SHOW_ADMIN_SETTINGS_PAGE);

    }
}
