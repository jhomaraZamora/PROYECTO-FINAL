package Modelo;

public class Cliente {
    
    int id;
    String ci;
    String nombres;
    String direccion;
    String estado;

    public Cliente() {
    }

    public Cliente(int id, String ci, String nombres, String direccion, String estado) {
        this.id = id;
        this.ci = ci;
        this.nombres = nombres;
        this.direccion = direccion;
        this.estado = estado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", ci=" + ci + ", nombres=" + nombres + ", direccion=" + direccion + ", estado=" + estado + '}';
    }
    
}
