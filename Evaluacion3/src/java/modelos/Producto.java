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
public class Producto {
    private int id;
    private String nombre;
    private int precio;
    
    public Producto(){
        
    }

   public Producto(int id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
