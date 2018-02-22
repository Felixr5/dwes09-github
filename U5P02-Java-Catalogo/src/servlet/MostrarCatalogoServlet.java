package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import objetos.Cancion;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarCatalogoServlet
 */
@WebServlet("/MostrarCatalogo")
public class MostrarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarCatalogoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cancion cancion;
		String order = "nombre"; // Se ordena por nombre de forma predeterminada

		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement sentencia = null;

		// Botones de arriba y abajo deshabilitados si es la opcion elegida

		String naz = "href= MostrarCatalogo?res=NAZ";
		String nza = "href= MostrarCatalogo?res=NZA";
		String aaz = "href= MostrarCatalogo?res=AAZ";
		String aza = "href= MostrarCatalogo?res=AZA";
		String alaz = "href= MostrarCatalogo?res=ALAZ";
		String alza = "href= MostrarCatalogo?res=ALZA";

		if (!request.getParameterMap().containsKey("res") || request.getParameter("res").equals("NAZ")) {
			order = "nombre";
			naz = "";
		}

		if (request.getParameterMap().containsKey("res")) {

			if (request.getParameter("res").equals("NZA")) {
				order = "nombre desc";
				nza = "";
			}
			if (request.getParameter("res").equals("AAZ")) {
				order = "autor desc";
				aaz = "";
			}
			if (request.getParameter("res").equals("AZA")) {
				order = "autor asc";
				aza = "";
			}
			if (request.getParameter("res").equals("ALZA")) {
				order = "album desc";
				alza = "";
			}
			if (request.getParameter("res").equals("ALAZ")) {
				order = "album asc";
				alaz = "";
			}

		}
		//////////////////////////////////////////////////
		// footer
		out.println("<style type='text/css'>");
		out.println("footer {");
		out.println("position: fixed;");
		out.println("right: 0;");
		out.println("bottom: 0;");
		out.println("left: 0;");
		out.println("padding: 1rem;");
		out.println("background-color: #efefef;");
		out.println("text-align: center;");
		out.println("}</style>");
		///////

		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = "alumno";
			String password = "alumno";
			String url = "jdbc:mariadb://localhost/catalogo09";
			conn = DriverManager.getConnection(url, userName, password);
			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			sentencia = conn.createStatement();
			String filtro = "";
			////////////////////////////////// 77
			String busqueda = "";
			// Autor

			if (request.getParameterMap().containsKey("aut")) {
				filtro = "and canciones.ID_AUTOR=" + request.getParameter("aut");
			}

			// La consulta se podria hacer con * en lugar de todos los nombres,
			// pero poniendo los nombres, al usar el rset, se puede poner el nombre que le
			// hemos dado.
			String consulta = "SELECT canciones.ID_CANCION as id,canciones.ID_ALBUM, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor,autores.ID_AUTOR as idAut,canciones.duracion as DURACION"
					+ " FROM canciones,autores,albums"
					+ " where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM " + busqueda
					+ filtro + " order by " + order;
			ResultSet rset = sentencia.executeQuery(consulta);
			String consulta2;

			// Busqueda
			if (request.getParameterMap().containsKey("can")) {
				String[] split;
				split = request.getParameter("can").split(" ");

				for (int i = 0; i < split.length; i++) {
					if (i == (split.length - 1))
						busqueda += " and cancion.nombre like %" + split[i] + "%"; // Si es el ultimo no se pone el or.
					else
						busqueda += " and cancion.nombre like %" + split[i] + "% or";

				}
			}

			// Resultado
			out.println("<html><head><meta charset='UTF-8'/></head><body>");

			// Tabla (Con ordenacion, variables arriba)
			out.println("<table style='border: 0'>");
			out.println("<tr style='background-color: whitesmoke'>");

			out.println("<th>Nombre <a " + naz + ">&#9652</a>"); // Nombre AZ
			out.println("<a " + nza + ">&#9662</a></th>"); // Nombre ZA

			out.println("<th>ALBUM <a " + alaz + ">&#9652</a>"); // Album AZ
			out.println("<a " + alza + ">&#9662</a></th>"); // Album ZA

			out.println("<th>AUTOR <a " + aaz + " >&#9652</a>"); // Autor AZ
			out.println("<a " + aza + " >&#9662</a></th>"); // Autor ZA

			out.println("</tr>");
			/////////////////////////////////

			// Resultados de la query y link de mostrarObra
			if (!rset.isBeforeFirst()) {
				out.println("<p>No hay canciones en la base de datos</p>");
			}
			while (rset.next()) {
				cancion = new Cancion(Integer.parseInt(rset.getString("id")),
						Integer.parseInt(rset.getString("ID_ALBUM")), Integer.parseInt(rset.getString("idAut")),
						rset.getString("nombre"), Float.parseFloat(rset.getString("DURACION")));

				out.print("<tr><td><a href=./MostrarObra?id=" + cancion.getID_CANCION() + ">" + cancion.getNOMBRE()
						+ "</a></td><td>" + rset.getString("album") + "</td><td><a href=./MostrarCatalogo?aut="
						+ cancion.getID_AUTOR() + ">" + rset.getString("autor") + "</a></td></tr>");
			}

			// Autor
			if (request.getParameterMap().containsKey("aut")) {
				consulta2 = "SELECT * FROM autores where ID_AUTOR=" + request.getParameter("aut");
				ResultSet rset2 = sentencia.executeQuery(consulta2);
				if (!rset2.isBeforeFirst()) {
					out.println("<p>No hay autores en la base de datos</p>");
				}
				if (rset2.next())
					out.println("<div><img src=./img/" + rset2.getString("FOTO") + " height=150 /></div>");
			}
			////////////////////////////// 77

			// Quitar filtros.
			if (request.getParameterMap().containsKey("filtro")) {

				response.sendRedirect("./MostrarCatalogo");
			}
			////////////////////

			///////////////
			// Navegacion

			out.println("<footer> <p><form action=./MostrarCatalogo method=post>"
					+ "<label>Introduce el nombre de la cancion a buscar..</label><input type=text name=can >"
					+ "<input type=submit></form></p>"
					+ "<p><a href=./U5P01-Java-BBDD/MostrarCuidadores>Mostrar Cuidadores</a></p>");
			out.println("<a href=./MostrarCatalogo?filtro=0 >Eliminar filtros.</a>");
			out.println("</footer>");
			out.println("</body></html>");

		} catch (Exception e) {
			out.print("Ha habido un error.");

		}
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
