/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Producto;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

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
            case "1": registrarProducto(request,response);
                break;
            default: response.sendRedirect("index.jsp?msj=Opcion no valida");
        }
        }else{
            response.sendRedirect("index.jsp?msj=Opcion no valida");
        }
    }
        private void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException{
           try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int precio = Integer.parseInt(request.getParameter("precio").trim());
            if(id<1||nombre.equals("")||precio<1){
                response.sendRedirect("producto.jsp?msj=Campos incompletos");
            }else{
                Producto productoNuevo = new Producto(id,nombre,precio);
                ProductoDAO pd = new ProductoDAO();
                int respuesta = pd.registrarProducto(productoNuevo);
                    if(respuesta==1){
                    response.sendRedirect("producto.jsp?msj=Producto registrado");
                    }else{
                    response.sendRedirect("producto.jsp?msj=Producto no se pudo registrar");
                    }

            }
           }catch(Exception e){
               response.sendRedirect("producto.jsp?msj="+e.getMessage());
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
