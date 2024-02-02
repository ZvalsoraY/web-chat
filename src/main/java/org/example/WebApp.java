package org.example;

import org.example.command.Command;
import org.example.command.CommandType;
import org.example.command.EmptyCommand;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WebApp extends HttpServlet {
    //private String login;
    //private User user;
    private DataBase dataBase;

    @Override
    public void init() {
        DataBase.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("user", this.login);
        //request.setAttribute("user", user.getName());
        handleRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this.login = request.getParameter("loginInput");
        //request.setAttribute("user", user);
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Command command = defineCommand(request);
        Result result = command.execute(request, response);

        //request.setAttribute("user", this.login);
        /*request.getRequestDispatcher(resourceName).forward(request,response);*/

        String resourceName = result.getResource();
        switch (result.getResponseType()) {
            case FORWARD:
                request.getRequestDispatcher(resourceName).forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(resourceName);
                break;
            default:
                break;
        }
    }

    private Command defineCommand(HttpServletRequest request) {
        String commandString = request.getParameter("command");
        if (commandString == null || commandString.isEmpty()) {
            return new EmptyCommand();
        }

        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandString.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.EMPTY;
        }
        return commandType.getCommand();
    }

    @Override
    public void destroy() {
        DataBase.close();
    }
}
