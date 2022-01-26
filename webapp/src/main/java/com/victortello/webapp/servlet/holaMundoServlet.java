package com.victortello.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/holaMundo")
public class holaMundoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws IOException, ServletException {

        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

        out.print("<!DOCTYPE html>");

        out.print("<html>");
        out.print("<head>");
        
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>Perro</title>");

        out.print("</head>");

        out.print("<body>");
        out.print("<h2>Let me pass</h2>");
        out.print("</body>");
        out.print("</html>");

    }

}
