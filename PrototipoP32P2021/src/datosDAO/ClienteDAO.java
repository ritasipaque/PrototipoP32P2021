/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosDAO;
import Dominio.Cliente;
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
public class ClienteDAO {
    
  private static final String SQL_SELECT = "SELECT Id, Nombre_cliente, Nit_cliente, Telefono_cliente, Dpi_cliente, Estatus FROM tbl_cliente";
    private static final String SQL_INSERT = "INSERT INTO tbl_cliente(Id, Nombre_cliente, Nit_cliente, Telefono_cliente, Dpi_cliente, Estatus) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cliente SET Nombre_cliente=?, Nit_cliente=?, Telefono_cliente=?, Dpi_cliente=?, Estatus=? WHERE Id = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE Id =?";
    private static final String SQL_QUERY = "SELECT  Id, Nombre_cliente, Nit_cliente, Telefono_cliente, Dpi_cliente, Estatus FROM tbl_cliente WHERE Id = ?";
      
    public List<Cliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente vendedor = null;
        List<Cliente> vendedores = new ArrayList<Cliente>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String cliente = rs.getString("Nombre_cliente");
                String nit = rs.getString("Nit_cliente");
                String telefono = rs.getString("Telefono_cliente");
                String dpi = rs.getString("Dpi_cliente");
                String estatus = rs.getString("Estatus");
                
                vendedor = new Cliente();
                vendedor.setID(id);
                vendedor.setNombre_cliente(cliente);
                vendedor.setNit_cliente(nit);
                vendedor.setTelefono_cliente(telefono);
                vendedor.setDpi_cliente(dpi);
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
    public int insert(Cliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacion.getID());
            stmt.setString(2, aplicacion.getNombre_cliente());
            stmt.setString(3, aplicacion.getNit_cliente());
            stmt.setString(4, aplicacion.getTelefono_cliente());
            stmt.setString(5, aplicacion.getDpi_cliente());
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
     
   
    
    public int update(Cliente aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, aplicacion.getNombre_cliente());
            stmt.setString(2, aplicacion.getNit_cliente());
            stmt.setString(3, aplicacion.getTelefono_cliente());
            stmt.setString(4, aplicacion.getDpi_cliente());
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
    public Cliente query(Cliente producto) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> productos = new ArrayList<Cliente>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getID());
            rs = stmt.executeQuery();
            while (rs.next()) {
               int ID = rs.getInt("Id");
                String Cliente = rs.getString("Nombre_cliente");
                String Nit = rs.getString("Nit_cliente");
                String Telefono = rs.getString("Telefono_cliente");
                String Edad = rs.getString("Dpi_cliente");
                String Estatus = rs.getString("Estatus");
                
                 
                
                producto = new Cliente();
                producto.setID(ID);
                producto.setNombre_cliente(Cliente);
                producto.setNit_cliente(Nit);
                producto.setTelefono_cliente(Telefono);
                producto.setDpi_cliente(Edad);
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
    
    public int delete(Cliente aplicacion) {

       

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
