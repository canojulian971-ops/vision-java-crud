package com.vision.main;

import com.vision.dao.UsuarioDAO;
import com.vision.modelo.Usuario;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("=== 1. PROBANDO INSERCIÓN DE USUARIO ===" );
        Usuario nuevoUsuario = new Usuario("Carlos Pérez", "carlos@mail.com", "Conductor");
        boolean insertado = usuarioDAO.insertarUsuario(nuevoUsuario);
        if (insertado) {
            System.out.println("¡Usuario insertado con éxito!");
        }

        System.out.println("\n=== 2. PROBANDO CONSULTA DE USUARIOS ===" );
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getIdUsuario() + " | Nombre: " + u.getNombre() + " | Correo: " + u.getCorreo() + " | Rol: " + u.getRol());
        }

        System.out.println("\n=== 3. PROBANDO ACTUALIZACIÓN ===");
        if (!usuarios.isEmpty()) {
            Usuario usuarioAEditar = usuarios.get(0); // Tomamos el primero de la lista
            usuarioAEditar.setNombre("Carlos Pérez Actualizado");
            boolean actualizado = usuarioDAO.actualizarUsuario(usuarioAEditar);
            if (actualizado) {
                System.out.println("¡Usuario actualizado con éxito!");
            }
        }

        System.out.println("\n=== 4. PROBANDO ELIMINACIÓN ===");
        if (!usuarios.isEmpty()) {
            int idAEliminar = usuarios.get(usuarios.size() - 1).getIdUsuario(); // Tomamos el último
            boolean eliminado = usuarioDAO.eliminarUsuario(idAEliminar);
            if (eliminado) {
                System.out.println("¡Usuario con ID " + idAEliminar + " eliminado con éxito!");
            }
        }
    }
}