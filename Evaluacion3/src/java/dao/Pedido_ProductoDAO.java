/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Pedido;
import modelos.Pedido_Producto;

/**
 *
 * @author mfaun
 */
public class Pedido_ProductoDAO extends Conexion {
    public int registrarPedido(Pedido_Producto pedido_producto) throws SQLException{
        try{
            String sentencia ="Insert into pedido_producto values (?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, pedido_producto.getPedido().getId());
            ps.setInt(2, pedido_producto.getProducto().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
}
