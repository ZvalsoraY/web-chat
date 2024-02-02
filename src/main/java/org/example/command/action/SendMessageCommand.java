package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand  implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        DataBase.addMessage(new Message(user.getName(),  request.getParameter("message")));

        System.out.println(user.getName() + " SEND " + request.getParameter("message"));

        return new ForwardResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
