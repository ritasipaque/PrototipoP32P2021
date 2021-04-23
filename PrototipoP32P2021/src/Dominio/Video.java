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
public class Video {
 int ID;
    String Nombre_video;
    String Tema_video;
    String Idioma_video;
    String Autor_video;
    String Estatus;   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_video() {
        return Nombre_video;
    }

    public void setNombre_video(String Nombre_video) {
        this.Nombre_video = Nombre_video;
    }

    public String getTema_video() {
        return Tema_video;
    }

    public void setTema_video(String Tema_video) {
        this.Tema_video = Tema_video;
    }

    public String getIdioma_video() {
        return Idioma_video;
    }

    public void setIdioma_video(String Idioma_video) {
        this.Idioma_video = Idioma_video;
    }

    public String getAutor_video() {
        return Autor_video;
    }

    public void setAutor_video(String Autor_video) {
        this.Autor_video = Autor_video;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    @Override
    public String toString() {
        return "Video{" + "ID=" + ID + ", Nombre_video=" + Nombre_video + ", Tema_video=" + Tema_video + ", Idioma_video=" + Idioma_video + ", Autor_video=" + Autor_video + ", Estatus=" + Estatus + '}';
    }
    
    
    
    
}
