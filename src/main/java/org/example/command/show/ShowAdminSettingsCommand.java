package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;

import static org.example.Resources.PAGE_ADMIN_SETTINGS;

public class ShowAdminSettingsCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = DataBase.getUsers();
        request.setAttribute("users", users);
        return new ForwardResult(PAGE_ADMIN_SETTINGS);
    }
}
