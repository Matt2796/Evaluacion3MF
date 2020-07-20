/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Estado;
import modelos.Pedido;

/**
 *
 * @author mfaun
 */
public class PedidoDAO extends Conexion {
        public int registrarPedido(Pedido pedido) throws SQLException{
        try{
            String sentencia ="Insert into pedido values (?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, pedido.getId());
            ps.setString(2, pedido.getCorreo());
            ps.setInt(3, pedido.getEstado().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
           public int modificarEstado(Pedido pedido) throws SQLException{
        try{
            String sentencia ="update pedido id_estado=? where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, pedido.getEstado().getId());
            ps.setLong(2, pedido.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
               public Pedido obtenerPedido(String correo) throws SQLException{
        try{
            String sentencia = "select * from v_pedido where correo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            Pedido p = null;
            if(rs.next()){
                Estado e = new Estado(rs.getInt("e_id"),rs.getString("e_nombre"));
                p = new Pedido(rs.getInt("id"),rs.getString("correo"),e);
            }
            return p;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
}
