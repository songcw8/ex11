package org.example.ex11.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random random = new Random();
        int luckyNumber = random.nextInt(100);
        HttpSession session = req.getSession();
        if(session.getAttribute("luckyNumber") == null) {
            session.setAttribute("luckyNumber", luckyNumber);
        }
        req.getRequestDispatcher("/WEB-INF/auth.jsp").forward(req, resp);
    }
}
