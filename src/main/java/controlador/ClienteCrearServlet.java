package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;

/**
 * Servlet implementation class CrearCliente
 */
@WebServlet("/ClienteCrear")
public class ClienteCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteCrearServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		Cliente cliente;
				
		String rut, sistemaSalud, nombres, apellidos, afp,
		direccion, comuna, telefono;
		
		LocalDate fechaNacimiento;
	
		rut = request.getParameter("rut") + "-" + request.getParameter("dv");
		nombres = request.getParameter("nombres");
		apellidos = request.getParameter("apellidos");
		fechaNacimiento = LocalDate.parse( request.getParameter("fechaNacimiento"));
		telefono = request.getParameter("telefono");
		sistemaSalud = request.getParameter("sistemaSalud");
		afp = request.getParameter("afp");
		direccion = request.getParameter("direccion");
		comuna = request.getParameter("comuna");
		
		cliente = new Cliente(rut, nombres, apellidos, telefono,
						sistemaSalud, afp, direccion, comuna, fechaNacimiento);
	}

}
