/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author mfaun
 */
public class Pedido {
    private int id;
    private String correo;
    private Estado estado;

    public Pedido(){
        
    }
    
    public Pedido(int id, String correo, Estado estado) {
        this.id = id;
        this.correo = correo;
        this.estado = estado;
    }

    public Pedido(String correo, Estado estado){
        this.correo = correo;
        this.estado = estado;
    }
    public Pedido(int id, Estado estado) {
        this.id = id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
