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

/**
 *
 * @author mfaun
 */
public class EstadoDAO extends Conexion{
        public Estado obtenerEstado(int id) throws SQLException{
        String sentencia = "select * from estado where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Estado(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
}
