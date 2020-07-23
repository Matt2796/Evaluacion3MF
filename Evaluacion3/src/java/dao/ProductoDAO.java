/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            ps.setInt(1, producto.getId());
            ps.setString(2, producto.getNombre());
            ps.setInt(3, producto.getPrecio());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
            public ArrayList<Producto> obtenerProductos() throws SQLException{
        try{
            String sentencia = "select * from producto";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Producto> productos = new ArrayList();
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id"),rs.getString("nombre"),rs.getInt("precio")
                ));
            }
            return productos;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
