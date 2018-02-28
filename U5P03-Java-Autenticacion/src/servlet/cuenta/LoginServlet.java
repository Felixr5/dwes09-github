package servlet.cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // L1
		ServletContext contexto = getServletContext();
		String mensajeError = "";
		Connection conn = null;
		Statement sentencia = null;
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = contexto.getInitParameter("usuario");
			String password = contexto.getInitParameter("password");
			String url = contexto.getInitParameter("url");
			conn = DriverManager.getConnection(url, userName, password);

			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			sentencia = conn.createStatement();

			if (session != null) {
				if ((session.getAttribute("login") != null)) { // L2
					response.sendRedirect(contexto.getContextPath() + "/"); // L3
				}
			} else { // no hay sesión iniciada
				if (request.getMethod().equals("POST")) { // si venimos de enviar el formulario...
					// Procesar los campos del formulario de login y password
					// Declarar una variable de mensaje de error para mostrar después:
					mensajeError = "";

					// Comprobaciones que debes hacer:

					// a. Error: el campo login no puede estar vacío
					if (request.getParameter("username").equals("")) {
						mensajeError = "Campo login vacio.";
					} else {
						// b. Error: el campo password no puede estar vacío
						if (request.getParameter("password").equals("")) {
							mensajeError = "Campo password vacio.";
						} else {
							if (!request.getParameter("username").equals("")) {

								String consulta = "SELECT * FROM usuario where usuario.login LIKE '"
										+ request.getParameter("username") + "'";
								ResultSet rset = sentencia.executeQuery(consulta);
								// c. Error: no se encuentra el usuario en la base de datos
								if (!rset.isBeforeFirst()) {
									mensajeError = "No existe el usuario.";
									// d. Error: la contraseña no es válida
								} else {
									rset.next();

									if (!rset.getString("password").equals(request.getParameter("password"))) {

										mensajeError = "Password incorrecta.";
									} else {
										String login = rset.getString("login");
										String pass = rset.getString("password");
										String nombre = rset.getString("nombre");
										String descripcion = rset.getString("descripcion");
										int admin = rset.getInt("admin");
										if (admin == 1) {
											session = request.getSession(); // en este caso sin "false" para que se cree

											Usuario user = new Usuario(login, pass, nombre, descripcion, true);
											session.setAttribute("usuario", user);
											contexto.log(" * Creando sesión en " + request.getRequestURI());
											response.sendRedirect(contexto.getContextPath() + "/");

										} else {
											session = request.getSession(); // en este caso sin "false" para que se cree

											Usuario user = new Usuario(login, pass, nombre, descripcion, false);
											session.setAttribute("usuario", user);
											contexto.log(" * Creando sesión en " + request.getRequestURI());
											response.sendRedirect(contexto.getContextPath() + "/");

										}
									}
								}
							}
						}
					}
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		// salida : L4
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		out.println("<body>");
		out.println("<h3>Inicio de sesión</h3>");
		out.println("<form action='" + request.getRequestURI() + "' method='post'>"
				+ "<label>Usuario:</label><input type='text' name='username'><br/>"
				+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
				+ "<input type='submit' value='Iniciar sesión' name='enviar'>" + "</form>" + "<p><a href='"
				+ contexto.getContextPath() + "/Alta'>¿Aún no estás registrado? Haz clic en este enlace</a></p>"
				+ "<h3>" + mensajeError + "</h3>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
