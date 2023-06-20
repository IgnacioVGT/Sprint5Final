package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Administrativo;

public class AdministrativoDAO {
	private static AdministrativoDAO instancia;
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
 	private String tabla = "administrativo";
 	private String columnas = "rut, nombres, fechaNacimiento, area, experienciaPrevia";

//Constructor
 	private AdministrativoDAO() {
 		conexion = obtenerConexion();
 	}
// Instancia 	
 	public static AdministrativoDAO getInstancia() {
 		if (instancia == null) {
 			instancia = new AdministrativoDAO();
 		}
 		return instancia;
 	}
/// Conexion
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

 	public void create(Administrativo admin) {
 		String query =
				"INSERT INTO " + tabla + " (" + columnas + ") VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement statement = conexion.prepareStatement(query)){
			statement.setString(1, admin.getRut());
        	statement.setString(2, admin.getNombres());
            statement.setString(3, admin.getFechaNacimiento().toString());
			statement.setString(4,admin.getArea());
			statement.setString(5,admin.getExperienciaPrevia());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	}

 	public List<Administrativo> read(){
 		List<Administrativo> administrativos = new ArrayList<>();
 		String query =
 				"SELECT id, " + columnas + " FROM " + tabla;
 		try(PreparedStatement statement = conexion.prepareStatement(query);
 				ResultSet resultados = statement.executeQuery()){
 				
			while(resultados.next()) {
				Administrativo admin = new Administrativo();
				
				admin.setId(resultados.getInt("id"));
				admin.setRut(resultados.getString("rut"));
                admin.setNombres(resultados.getString("nombres"));
                admin.setFechaNacimiento(LocalDate.parse(resultados.getString("fechaNacimiento")));
				admin.setArea(resultados.getString("area"));
				admin.setExperienciaPrevia(resultados.getString("experienciaPrevia"));
				
				administrativos.add(null);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return administrativos;
 	}
 	
 	public void update(Administrativo admin) {
 		String query = "UPDATE " + tabla + "SET " + columnas + " WHERE id = ?";
 		try (PreparedStatement statement = conexion.prepareStatement(query)) {
 			statement.setString(1, admin.getRut());
        	statement.setString(2, admin.getNombres());
            statement.setString(3, admin.getFechaNacimiento().toString());
            statement.setString(4, admin.getArea());
            statement.setString(5, admin.getExperienciaPrevia());
// Especificar ID
            statement.setInt(6, admin.getId());
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 		
 	}

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