package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Ваша реализация выполнения входа в Чат
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        System.out.println("login = " + login + " password = " + password);
        Optional<User> user = DataBase.findByLogin(login);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            user.get().setOnline(true);
            request.getSession(true).setAttribute("user", user.get());
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        } else {
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }
    }
}
