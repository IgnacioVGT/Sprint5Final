package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDAO {
	private static ClienteDAO instancia;
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
 	private String tabla = "usuario";
 	private String columnas = "rut, nombre, fechaNacimiento, apellidos, telefono, sistemaSalud, afp, direccion, comuna";
 	private String insertar = "rut, nombre, fechaNacimiento, tipoUsuario, apellidos, telefono, sistemaSalud, afp, direccion, comuna";
 	private String update = "nombre, fechaNacimiento, apellidos, telefono, sistemaSalud, afp, direccion, comuna";

//Constructor
 	private ClienteDAO() {
 		conexion = obtenerConexion();
 	}
// Instancia 	
 	public static ClienteDAO getInstancia() {
 		if (instancia == null) {
 			instancia = new ClienteDAO();
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

 	public void create(Cliente clie) {
 		String query =
				"INSERT INTO " + tabla + " (" + insertar + ") VALUES (?, ?, ?, 'Administrativo', ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement statement = conexion.prepareStatement(query)){
			statement.setString(1, clie.getRut());
        	statement.setString(2, clie.getNombres());
            statement.setString(3, clie.getFechaNacimiento().toString());
			statement.setString(5, clie.getApellidos());
			statement.setString(6, clie.getTelefono());
			statement.setString(7, clie.getSistemaSalud());
			statement.setString(8, clie.getAfp());
			statement.setString(9, clie.getDireccion());
			statement.setString(10, clie.getComuna());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	}

 	public List<Cliente> read(){
 		List<Cliente> clientes = new ArrayList<>();
 		String query =
 				"SELECT id, " + columnas + " FROM " + tabla;
 		try(PreparedStatement statement = conexion.prepareStatement(query);
 				ResultSet resultados = statement.executeQuery()){
 				
			while(resultados.next()) {
				Cliente clie = new Cliente();
				
				clie.setRut(resultados.getString("rut"));
                clie.setNombres(resultados.getString("nombres"));
                clie.setFechaNacimiento(LocalDate.parse(resultados.getString("fechaNacimiento")));
                clie.setApellidos(resultados.getString("apellidos"));
                clie.setTelefono(resultados.getString("telefono"));
                clie.setAfp(resultados.getString("afp"));
                clie.setDireccion(resultados.getString("direccion"));
                clie.setComuna(resultados.getString("comuna"));
				
				clientes.add(null);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clientes;
 	}
 	
 	public void update(Cliente clie) {
 		String query = "UPDATE " + tabla + "SET " + update + " WHERE rut = ?";
 		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, clie.getRut());
        	statement.setString(2, clie.getNombres());
            statement.setString(3, clie.getFechaNacimiento().toString());
			statement.setString(5, clie.getApellidos());
			statement.setString(6, clie.getTelefono());
			statement.setString(7, clie.getSistemaSalud());
			statement.setString(8, clie.getAfp());
			statement.setString(9, clie.getDireccion());
			statement.setString(10, clie.getComuna());
// Especificar RUT
 			statement.setString(1, clie.getRut());
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 		
 	}

    public void delete(String rut) {
        String query = "DELETE FROM " + tabla + " WHERE rut = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, rut);
// Ejecutar
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    

}