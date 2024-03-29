package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        // Ваша реализация наполнения данными главной страницы чата
        List<User> users = DataBase.getUsers();
        List<Message> messages = DataBase.getMessages();
        request.setAttribute("users", users);
        request.setAttribute("messages", messages);
        System.out.println(request.getSession(false).getAttribute("user"));

        response.setIntHeader("Refresh", 10);
        return new ForwardResult(PAGE_CHAT);
    }
}
