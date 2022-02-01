package com.victortello.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getParam")
public class getParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        String saludo = req.getParameter("saludo");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");

        out.print("<html>");
        out.print("<head>");

        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>Home</title>");

        out.print("</head>");

        out.print("<body>");
        out.print("<h2>hola " + saludo + "</h2>");
        out.print("</body>");
        out.print("</html>");
    }

}
