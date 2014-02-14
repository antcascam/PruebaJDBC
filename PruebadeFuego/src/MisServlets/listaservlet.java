package MisServlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/listaservlet")
public class listaservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String metodo;
	public String nombre;
	public String apellidos;
       
   
    public listaservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conexion = null; //Objeto para la conexión a la BD
    	Statement sentencia1 = null; //Objeto para la ejecutar una sentencia
    	Statement sentencia2 = null; //Objeto para la ejecutar una sentencia
        ResultSet resultados = null;//Objeto para guardar los resultados
        String vinculoIndex="<A HREF="+"http://localhost:8080/PruebadeFuego/index.jsp"+">Home</a>";
        
      //Variables conexión
        String cadenaConexion="jdbc:oracle:thin:@localhost:3306:trabajo";
        String usuariobd="PepLw";
        String passwordbd="1S33-Y0UrM1nd";
	    
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    try {
	    	//Leemos el driver de Oracle
	    	Class.forName("com.mysql.jdbc.Driver");

	    	//Nos conectamos a la BD
	    	conexion = DriverManager.getConnection(cadenaConexion,usuariobd,passwordbd);
	    	
	    	//Creamos las sentencias a partir de la conexión
	    	sentencia1=conexion.createStatement();
	    	sentencia2=conexion.createStatement();
	    	
	    	//Insertamos la tupla
	    	sentencia1.execute("INSERT INTO usuarios VALUES("+nombre+","+apellidos+","+metodo+")");

	    	//Cogemos todos los datos de los usuarios
	    	resultados=sentencia2.executeQuery("SELECT * FROM usuarios");

	        //Imprimimos los usuarios 
	    	out.println("<html>");
	    	out.println("<body>");
	    	out.println("Nombre | Apellidos | Método");
	    	while(resultados.next()) { 
	    		   out.println(resultados.getString("nombre")+
	    			       " | "+resultados.getString("apellidos")+
	    			       " | "+resultados.getString("metodo"));
	    	}
	    	// El siguiente bucle haría lo mismo pero buscando por número de columna:
	    	
	    	//while(resultados.next()) { 
	    	//	   out.println(resultados.getString(1)+
	    	//		       " | "+resultados.getString(2)+
	    	//		       " | "+resultados.getString(3));
	    	//}
	    	
	    	// Me he permitido hacer un hipervínculo a index.jsp:
	    	out.println(vinculoIndex);
	    	out.println("</body>");
	    	out.println("</html>");

		} 
		catch (ClassNotFoundException e1) {
	                //Error si no puedo leer el driver de Oracle 
			out.println("ERROR:No encuentro el driver de la BD: "+
					e1.getMessage());
		}
		catch (SQLException e2) {
	                //Error SQL: login/passwd mal
			out.println("ERROR:Fallo en SQL: "+e2.getMessage());
		}
		finally {
	                //Finalmente desconecto de la BD
			try {
				if (conexion!=null)
					conexion.close();
			} catch (SQLException e3) {
				out.println("ERROR:Fallo al desconectar de la BD: "+
					e3.getMessage());
			}
		
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metodo="GET";
		nombre=request.getParameter("nameget");
		apellidos=request.getParameter("apelget");
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metodo="POST";
		nombre=request.getParameter("namepost");
		apellidos=request.getParameter("apelpost");
		service(request,response);
	}

}
