package main;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // INSERTAR
        dao.insertar(new Usuario("Juan", "juan@gmail.com"));

        // LISTAR
        dao.listar();

        // ACTUALIZAR
        dao.actualizar(1, "Juan Actualizado", "nuevo@gmail.com");

        // ELIMINAR
        dao.eliminar(1);
    }
}