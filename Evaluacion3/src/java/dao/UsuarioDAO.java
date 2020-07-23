/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author mfaun
 */
public class UsuarioDAO extends Conexion {
            public int registrarUsuario(Usuario u) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into usuario values (?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, u.getUsuario());
        ps.setString(2, u.getPassword());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
        public Usuario obtenerUsuario(String usuario) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuario where usuario = ?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if(rs.next()){
           u = new Usuario(rs.getString("usuario"),rs.getString("password"));
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
}
