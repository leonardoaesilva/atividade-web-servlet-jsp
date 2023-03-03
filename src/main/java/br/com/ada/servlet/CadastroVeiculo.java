package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dados")
public class CadastroVeiculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fabricante = req.getParameter("fabricante");
        String modelo = req.getParameter("modelo");
        String pinturaCor = req.getParameter("pinturaCor");
        String placa = req.getParameter("placa");

        if (fabricante.isBlank() || modelo.isBlank() || pinturaCor.isBlank() || placa.isBlank()) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>O preenchimento de TODOS os campos é obrigatório.</h3>");
        } else {
            req.setAttribute("fabricante", fabricante);
            req.setAttribute("modelo", modelo);
            req.setAttribute("pinturaCor", pinturaCor);
            req.setAttribute("placa", placa);

            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");
            rd.forward(req, resp);
        }
    }
}
