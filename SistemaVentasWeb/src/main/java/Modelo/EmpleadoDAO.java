package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String ci) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? and Ci=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, ci);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setCi(rs.getString("Ci"));
                em.setNombres(rs.getString("Nombres"));
            }
        } catch (SQLException e) {

        }
        return em;

    }

    // OPERACIONES CRUD
    public List listar() {
        String sql = "SELECT * FROM empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setCi(rs.getString(2));
                em.setNombres(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));

                lista.add(em);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public int agregar(Empleado e) {
        String sql = "INSERT INTO empleado(Ci,Nombres,Telefono,Estado,User) VALUES(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getCi());
            ps.setString(2, e.getNombres());
            ps.setString(3, e.getTelefono());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleado WHERE IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setCi(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    public int actualizar(Empleado e) {
        String sql = "UPDATE empleado SET Ci=?, Nombres=?, Telefono=?, Estado=?, User=? WHERE IdEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getCi());
            ps.setString(2, e.getNombres());
            ps.setString(3, e.getTelefono());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());
            ps.setInt(6, e.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = " DELETE FROM empleado WHERE IdEmpleado= " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
