package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Profesional;

public class ProfesionalDAO {
    private static ProfesionalDAO instancia;
    private Connection conexion;
 // URL segmentada
 	private String API = "jdbc";
 	private String database = "mysql";
 	private String serverName = "localhost";
 	private String IP = "";
 	private String puerto = "3306"; 
 	private String schema = "mod5";
 // datos para acceder a la BD
 	private String usuario = "explorador";
 	private String contrasena = "arenaGato";
 // datos tabla
 	private String tabla = "profesional";
 	private String columnas = "rut, nombres, fechaNacimiento, titulo, fechaIngreso";

//Constructor
 	private ProfesionalDAO() {
 		conexion = obtenerConexion();
 	}

 	public static ProfesionalDAO getInstancia() {
 		if (instancia == null) {
 			instancia = new ProfesionalDAO();
 		}
 		return instancia;
 	}

 	public Connection obtenerConexion() {
 		Connection conexion = null;

        try {
// Cargar driver MySQL
        	Class.forName("com.mysql.jdbc.Driver");

            String url = API + ":" + database + "://" + serverName + IP + ":" + puerto + "/" + schema  ;
// Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
 	}
 	//_________________Métodos CRUD___________________



    public void delete(int id) {
        String query = "DELETE FROM " + tabla + " WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}















