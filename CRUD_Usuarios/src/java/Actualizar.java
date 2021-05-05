/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
//esta se encarga de poder realizar las sentencias sql como son:
//insert, delete, update, create, alter, drop
import java.sql.Statement;
//esta se encarga de generar un objeto para poder realizar las consultas sql
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author Emiliano
 */
public class Actualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor 
    public void init(ServletConfig cfg) throws ServletException{
    
        //como se va a conectar a la bd
        String url = "jdbc:mysql:3306//localhost/crud_u";
                    //tipodriver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "Arm%2312%3927";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            A veces el tipo de driver ya tiene incluido el puerto de comunicacion, 
            es por ello que nos arroja un error de conexion, para resolver este error
            simplemente hacemos lo siguiente:
            url = "jdbc:mysql://localhost/registro4iv9";
            */
            url = "jdbc:mysql://localhost/crud_u";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    

    
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom, appat, apmat, correo, ip, ipr;
            int edad, puerto, puertor, id;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            apmat = request.getParameter("apmat");
            edad = Integer.parseInt(request.getParameter("edad"));
            correo = request.getParameter("correo");
            id = Integer.parseInt(request.getParameter("idact"));
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            ipr = request.getRemoteAddr();
            puertor = request.getRemotePort();
            
            //vamos a intentar registrar en la bd
            try{
            
                /*
                Para poder registrar un usuario es necesario la sentencia insert
                bajo el siguiente esquema:
                
                insert into nombretabla (atributo1, atributo2, ....) values ("valor1", 'valor2', valor3)
                
                "" son para valores de tipo cadena
                '' numerico
                nada numerico   
                */
                
                String q = "update usuarios set nom_usu = '"+nom+"', "
                                    + "appat_usu = '"+appat+"', apmat_usu = '"+apmat+"', edad_usu = "+edad+", email_usu = '"+correo+"'"
                                    + "where id_usu = "+id;
                
                set.executeUpdate(q);
                System.out.println("Actualizacion exitosa en la tabla");
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='./Web Pages/CSS/response.css'>");
            out.println("<title>Servlet Registro</title>");
            out.println("</head>");
            out.println("<body>"
                    + "<br>"
                    + "Tu nombre es: "+nom
                    + "<br>"
                    + "Tu apellido paterno es: "+appat
                    + "<br>"
                    + "Tu apellido materno es: "+apmat
                    + "<br>"
                    + "Tu edad es: "+edad
                    + "<br>"
                    + "Tu email es: "+correo
                    + "<br>"
                    + "IP Local: "+ip
                    + "<br>"
                    + "Puerto Local: "+puerto
                    + "<br>"
                    + "IP Remota: "+ipr
                    + "<br>"
                    + "Puerto Remoto: "+puertor
                    + "<br>");
            out.println("<h1>Actualizacion Exitosa</h1>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Consulta' >Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
            
            
            }catch(Exception e){
                System.out.println("Error al registrar en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>"
            + "<br>");
            out.println("<h1>Registro No Exitoso, ocurrio un error</h1>"
                    + "<h1>"+e.getMessage()+"</h1>"
                    + "<h1>"+e.getStackTrace()+"</h1>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Consulta' >Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
                    
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
