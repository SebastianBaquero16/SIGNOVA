package dao;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {

    // INSERTAR
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, correo) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.executeUpdate();

            System.out.println("Usuario insertado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // LISTAR
    public void listar() {
        String sql = "SELECT * FROM usuario";

        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("nombre") + " - " +
                    rs.getString("correo")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(int id, String nombre, String correo) {
        String sql = "UPDATE usuario SET nombre=?, correo=? WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, id);
            ps.executeUpdate();

            System.out.println("Usuario actualizado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Usuario eliminado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}