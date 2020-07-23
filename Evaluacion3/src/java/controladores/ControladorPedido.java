/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EstadoDAO;
import dao.PedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Estado;
import modelos.Pedido;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorPedido", urlPatterns = {"/ControladorPedido"})
public class ControladorPedido extends HttpServlet {

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
            case "1": registrarPedido(request,response);
            break;
            case "Pendiente": Pendiente(request,response);
            break;
            case "Rechazado": Rechazado(request,response);
            break;
            case "Aceptado": Aceptado(request,response);
            break;
            default:
        }
         }else{
             response.sendRedirect("modpedido.jsp?msj=opcion no valida");
         }
    }
    
    private void registrarPedido(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
    }
    private void Pendiente(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id = Integer.parseInt(request.getParameter("id"));
            int estado = 0;
                EstadoDAO ed = new EstadoDAO();
                Pedido nuevoPedido = new Pedido (id, ed.obtenerEstado(estado));
                PedidoDAO pd = new PedidoDAO();
                   int respuesta = pd.modificarEstado(nuevoPedido);
                   if(respuesta>0){
                       response.sendRedirect("modpedido.jsp?msj=Pedido ha vuelto a pendiente");
                   }else{
                       response.sendRedirect("modpedido.jsp?msj=Pedido no se pudo modificar");
                   }
         }catch(Exception e){ 
         }
    }
    
    private void Rechazado(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id = Integer.parseInt(request.getParameter("id"));
            int estado = 1;
                EstadoDAO ed = new EstadoDAO();
                Pedido nuevoPedido = new Pedido (id, ed.obtenerEstado(estado));
                PedidoDAO pd = new PedidoDAO();
                   int respuesta = pd.modificarEstado(nuevoPedido);
                   if(respuesta>0){
                       response.sendRedirect("modpedido.jsp?msj=Pedido ha sido rechazado");
                   }else{
                       response.sendRedirect("modpedido.jsp?msj=Pedido no se pudo modificar");
                   }
         }catch(Exception e){
             
         }
    }
    private void Aceptado(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id = Integer.parseInt(request.getParameter("id"));
            int estado = 2;
                EstadoDAO ed = new EstadoDAO();
                Pedido nuevoPedido = new Pedido (id, ed.obtenerEstado(estado));
                PedidoDAO pd = new PedidoDAO();
                   int respuesta = pd.modificarEstado(nuevoPedido);
                   if(respuesta>0){
                       response.sendRedirect("modpedido.jsp?msj=Pedido ha sido aceptado");
                   }else{
                       response.sendRedirect("modpedido.jsp?msj=Pedido no se pudo modificar");
                   }
                
            
         }catch(Exception e){
             
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
