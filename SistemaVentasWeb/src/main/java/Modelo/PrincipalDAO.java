package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrincipalDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public String cantidadProductos(){
        String cantidadProducto ="";
        String sql = "SELECT COUNT(*) FROM producto";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
                cantidadProducto= rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cantidadProducto;
    }
    
    public String cantidadEmpleados(){
        String ce ="";
        String sql = "SELECT COUNT(*) FROM empleado";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
                ce= rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ce;
    }
    
    public String cantidadClientes(){
        String cl ="";
        String sql = "SELECT COUNT(*) FROM cliente";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
                cl= rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cl;
    }
    
    public String cantidadVentas(){
        String cv ="";
        String sql = "SELECT COUNT(*) FROM ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
                cv= rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cv;
    }
    
}
