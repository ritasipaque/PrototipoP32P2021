/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosDAO;
import Dominio.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SIPAQUE.RITA
 */
public class VideoDAO {
    private static final String SQL_SELECT = "SELECT Id, Nombre_video, Tema_video, Idioma_video, Autor_video, Estatus FROM tbl_video";
    private static final String SQL_INSERT = "INSERT INTO tbl_video(Id, Nombre_video, Tema_video, Idioma_video, Autor_video, Estatus) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_video SET Nombre_video=?, Tema_video=?, Idioma_video=?, Autor_video=?, Estatus=? WHERE Id = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_video WHERE Id =?";
    private static final String SQL_QUERY = "SELECT  Id, Nombre_video, Tema_video, Idioma_video, Autor_video, Estatus FROM tbl_video WHERE Id = ?";
    
    
    public List<Video> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       Video vendedor = null;
        List<Video> vendedores = new ArrayList<Video>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nombre = rs.getString("Nombre_video");
                String tema = rs.getString("Tema_video");
                String idioma = rs.getString("Idioma_video");
                String auotor = rs.getString("Autor_video");
                String estatus = rs.getString("Estatus");
                
                vendedor = new Video();
                vendedor.setID(id);
                vendedor.setNombre_video(nombre);
                vendedor.setTema_video(tema);
                vendedor.setIdioma_video(idioma);
                vendedor.setAutor_video(auotor);
                vendedor.setEstatus(estatus);
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores;
    }
    public int insert(Video aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacion.getID());
            stmt.setString(2, aplicacion.getNombre_video());
            stmt.setString(3, aplicacion.getTema_video());
            stmt.setString(4, aplicacion.getIdioma_video());
            stmt.setString(5, aplicacion.getAutor_video());
            stmt.setString(6, aplicacion.getEstatus());
           
            
             
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);            stmt.setString(2, aplicacion.getCliente());

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
     
   
    
    public int update(Video aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, aplicacion.getNombre_video());
            stmt.setString(2, aplicacion.getTema_video());
            stmt.setString(3, aplicacion.getIdioma_video());
            stmt.setString(4, aplicacion.getAutor_video());
            stmt.setString(5, aplicacion.getEstatus());
            stmt.setInt(6, aplicacion.getID());
            
            
            
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    public Video query(Video producto) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Video> productos = new ArrayList<Video>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getID());
            rs = stmt.executeQuery();
            while (rs.next()) {
               int ID = rs.getInt("Id");
                String Cliente = rs.getString("Nombre_video");
                String Nit = rs.getString("Tema_video");
                String Telefono = rs.getString("Idioma_video");
                String Edad = rs.getString("Autor_video");
                String Estatus = rs.getString("Estatus");
                
                 
                
                producto = new Video();
                producto.setID(ID);
                producto.setNombre_video(Cliente);
                producto.setTema_video(Nit);
                producto.setIdioma_video(Telefono);
                producto.setAutor_video(Edad);
                producto.setEstatus(Estatus);
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return producto;
    }
    
    public int delete(Video aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getID());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
}
