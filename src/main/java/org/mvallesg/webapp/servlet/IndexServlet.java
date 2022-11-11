package org.mvallesg.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\" />");
        out.println("        <title>Tarea 1: Servlet y envío de parámetros</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Tarea 1: Servlet y envío de parámetros</h1>");
        if(nombre!=null && apellido!=null){
            out.println("        <h2>Hola mi nombre es: " + nombre + " " + apellido + "</h2>");
        } else{
            out.println("        <h2>Falta informar el nombre o el apellido</h2>");
        }
        LocalDate fechaActual = LocalDate.now();
        int dia = fechaActual.getDayOfMonth();
        String mes = fechaActual.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        int year = fechaActual.getYear();
        out.println("        <h3>La fecha actual es: " + dia + " de " + mes + ", " + year + "</h3>");

        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}