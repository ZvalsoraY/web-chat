package org.example.command;

import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
