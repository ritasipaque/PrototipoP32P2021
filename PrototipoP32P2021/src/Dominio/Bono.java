/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author SIPAQUE.RITA
 */
public class Bono {
    int ID;
    String Nombre_cliente;
    String Nit_cliente;
    String Telefono_cliente;
    String Dpi_cliente;
    String Aplica_bono;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_cliente() {
        return Nombre_cliente;
    }

    public void setNombre_cliente(String Nombre_cliente) {
        this.Nombre_cliente = Nombre_cliente;
    }

    public String getNit_cliente() {
        return Nit_cliente;
    }

    public void setNit_cliente(String Nit_cliente) {
        this.Nit_cliente = Nit_cliente;
    }

    public String getTelefono_cliente() {
        return Telefono_cliente;
    }

    public void setTelefono_cliente(String Telefono_cliente) {
        this.Telefono_cliente = Telefono_cliente;
    }

    public String getDpi_cliente() {
        return Dpi_cliente;
    }

    public void setDpi_cliente(String Dpi_cliente) {
        this.Dpi_cliente = Dpi_cliente;
    }

    public String getAplica_bono() {
        return Aplica_bono;
    }

    public void setAplica_bono(String Aplica_bono) {
        this.Aplica_bono = Aplica_bono;
    }

    @Override
    public String toString() {
        return "Bono{" + "ID=" + ID + ", Nombre_cliente=" + Nombre_cliente + ", Nit_cliente=" + Nit_cliente + ", Telefono_cliente=" + Telefono_cliente + ", Dpi_cliente=" + Dpi_cliente + ", Aplica_bono=" + Aplica_bono + '}';
    }
    
    
    
    
}

