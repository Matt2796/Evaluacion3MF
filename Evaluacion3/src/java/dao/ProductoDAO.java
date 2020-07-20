/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Producto;

/**
 *
 * @author mfaun
 */
public class ProductoDAO extends Conexion {
        public int registrarProducto(Producto producto) throws SQLException{
        try{
            String sentencia ="Insert into producto values (?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getPrecio());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
        
}
