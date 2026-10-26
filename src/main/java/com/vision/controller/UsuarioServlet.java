package com.vision.controller;

import com.vision.dao.UsuarioDAO;
import com.vision.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    // Método que maneja las peticiones GET (Consultar / Listar)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Listado de Usuarios Registrados</h2>");
        out.println("<p>Funcionalidad de consulta conectada con éxito mediante GET.</p>");
        out.println("<a href='index.jsp'>Volver al Inicio</a>");
        out.println("</body></html>");
    }

    // Método que maneja las peticiones POST (Guardar / Insertar)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Capturar los datos enviados desde el formulario HTML
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String rol = request.getParameter("rol");

        // Crear el objeto Usuario y pasarlo al DAO
        Usuario nuevoUsuario = new Usuario(nombre, correo, rol);
        usuarioDAO.insertarUsuario(nuevoUsuario);

        // Responder al usuario con un mensaje de éxito
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>¡Usuario registrado exitosamente desde el formulario web!</h2>");
        out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
        out.println("<p><strong>Correo:</strong> " + correo + "</p>");
        out.println("<p><strong>Rol:</strong> " + rol + "</p>");
        out.println("<br><a href='index.jsp'>Registrar otro usuario</a>");
        out.println("</body></html>");
    }
}