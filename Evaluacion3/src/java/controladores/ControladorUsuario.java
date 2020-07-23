package controladores;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.*;

/**
 *
 * @author Matias Faundez - Cristian Riffo
 */
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": iniciarSesion(request,response);
                break;
            default: response.sendRedirect("admin.jsp?msj=Opcion no valida");
        }
        }else{
            response.sendRedirect("admin.jsp?msj=Opcion no valida");
        }
    }
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        Usuario usuarioIniciando = new Usuario(usuario,password);
        UsuarioDAO ud = new UsuarioDAO();
        Usuario temporal= ud.obtenerUsuario(usuarioIniciando.getUsuario());
        if(temporal!=null){
            if(temporal.getPassword().equals(usuarioIniciando.getPassword())){
            HttpSession sesion = request.getSession();
            sesion.setAttribute("admin", temporal);
            response.sendRedirect("producto.jsp");
            }else{
                response.sendRedirect("admin.jsp?msj=Password incorrecto");
            }
        }else{
            response.sendRedirect("admin.jsp?msj=Usuario inexistente");
        }
        }catch(Exception e){
            response.sendRedirect("admin.jsp?msj="+e.getMessage());
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
