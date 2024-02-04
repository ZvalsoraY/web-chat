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
import java.util.Optional;


import static org.example.Resources.COMMAND_SHOW_ADMIN_SETTINGS_PAGE;

public class BanCommand  implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return new RedirectResult(COMMAND_SHOW_ADMIN_SETTINGS_PAGE);

    }
}
