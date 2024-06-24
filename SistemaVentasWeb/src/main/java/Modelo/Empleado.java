package Modelo;

public class Empleado {
    
    int id;
    String ci;
    String nombres;
    String telefono;
    String estado;
    String user;

    public Empleado() {
    }

    public Empleado(int id, String ci, String nombres, String telefono, String estado, String user) {
        this.id = id;
        this.ci = ci;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", ci=" + ci + ", nombres=" + nombres + ", telefono=" + telefono + ", estado=" + estado + ", user=" + user + '}';
    }
    
}
