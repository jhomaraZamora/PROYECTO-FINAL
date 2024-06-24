package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.PrincipalDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO  edao = new EmpleadoDAO();
    
    Cliente c = new Cliente();
    ClienteDAO  cdao = new ClienteDAO();
    
    Producto pr = new Producto();
    ProductoDAO  pdao = new ProductoDAO();
    
    int ide;
    int idc;
    int idp;
    
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie;
    VentaDAO vdao = new VentaDAO();
    
    PrincipalDAO prdao = new PrincipalDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String menu = request.getParameter("menu");
    String accion = request.getParameter("accion");

    if (menu.equals("Principal")) {
        String cantidadProductos = prdao.cantidadProductos();
        String cantidadEmpleados = prdao.cantidadEmpleados();
        String cantidadClientes = prdao.cantidadClientes();
        String cantidadVentas = prdao.cantidadVentas();

        request.setAttribute("cantidadProductos", cantidadProductos);
        request.setAttribute("cantidadEmpleados", cantidadEmpleados);
        request.setAttribute("cantidadClientes", cantidadClientes);
        request.setAttribute("cantidadVentas", cantidadVentas);
        request.getRequestDispatcher("Principal.jsp").forward(request, response);
        return;
    }

    if (menu.equals("Empleado")) {
        switch (accion) {
            case "Listar":
                List lista = edao.listar();
                request.setAttribute("empleados", lista);
                break;
            case "Agregar":
                String ci = request.getParameter("txtCi");
                String nombres = request.getParameter("txtNombres");
                String telefono = request.getParameter("txtTelefono");
                String estado = request.getParameter("txtEstado");
                String usuario = request.getParameter("txtUsuario");

                em.setCi(ci);
                em.setNombres(nombres);
                em.setTelefono(telefono);
                em.setEstado(estado);
                em.setUser(usuario);

                edao.agregar(em);
                response.sendRedirect("Controlador?menu=Empleado&accion=Listar");
                return;
            case "Editar":
                ide = Integer.parseInt(request.getParameter("id"));
                Empleado e = edao.listarId(ide);
                request.setAttribute("empleado", e);
                break;
            case "Actualizar":
                String ci1 = request.getParameter("txtCi");
                String nombres1 = request.getParameter("txtNombres");
                String telefono1 = request.getParameter("txtTelefono");
                String estado1 = request.getParameter("txtEstado");
                String usuario1 = request.getParameter("txtUsuario");

                em.setCi(ci1);
                em.setNombres(nombres1);
                em.setTelefono(telefono1);
                em.setEstado(estado1);
                em.setUser(usuario1);
                em.setId(ide);

                edao.actualizar(em);
                response.sendRedirect("Controlador?menu=Empleado&accion=Listar");
                return;
            case "Eliminar":
                ide = Integer.parseInt(request.getParameter("id"));
                edao.delete(ide);
                response.sendRedirect("Controlador?menu=Empleado&accion=Listar");
                return;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        return;
    }

    if (menu.equals("Cliente")) {
        switch (accion) {
            case "Listar":
                List<Cliente> lista3 = cdao.listar();
                request.setAttribute("clientes", lista3);
                break;
            case "Agregar":
                String ci = request.getParameter("txtCi");
                String nombres = request.getParameter("txtNombres");
                String direccion = request.getParameter("txtDireccion");
                String estado = request.getParameter("txtEstado");

                c.setCi(ci);
                c.setNombres(nombres);
                c.setDireccion(direccion);
                c.setEstado(estado);

                cdao.agregar(c);
                response.sendRedirect("Controlador?menu=Cliente&accion=Listar");
                return;
            case "Editar":
                idc = Integer.parseInt(request.getParameter("id"));
                Cliente c1 = cdao.listarId(idc);
                request.setAttribute("cliente", c1);
                break;
            case "Actualizar":
                //idc = Integer.parseInt(request.getParameter("id")); // Asegurarse de obtener el ID del cliente
                //System.out.println(idc);
                String ci1 = request.getParameter("txtCi");
                String nombres1 = request.getParameter("txtNombres");
                String direccion1 = request.getParameter("txtDireccion");
                String estado1 = request.getParameter("txtEstado");

                c.setId(40); // Asegurarse de establecer el ID del cliente
                c.setCi(ci1);
                c.setNombres(nombres1);
                c.setDireccion(direccion1);
                c.setEstado(estado1);
                System.out.println(c.toString());
                cdao.actualizar(c);
                response.sendRedirect("Controlador?menu=Cliente&accion=Listar");
                return;
            case "Eliminar":
                idc = Integer.parseInt(request.getParameter("id"));
                cdao.delete(idc);
                response.sendRedirect("Controlador?menu=Cliente&accion=Listar");
                return;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        return;
    }

    if (menu.equals("Producto")) {
        switch (accion) {
            case "Listar":
                List lista1 = pdao.listar();
                request.setAttribute("productos", lista1);
                break;
            case "Agregar":
                String nombres = request.getParameter("txtNombres");
                int precio1 = Integer.parseInt(request.getParameter("txtPrecio"));
                int stock = Integer.parseInt(request.getParameter("txtStock"));
                String estado = request.getParameter("txtEstado");

                pr.setNombres(nombres);
                pr.setPrecio(precio1);
                pr.setStock(stock);
                pr.setEstado(estado);

                pdao.agregar(pr);
                response.sendRedirect("Controlador?menu=Producto&accion=Listar");
                return;
            case "Editar":
                idp = Integer.parseInt(request.getParameter("id"));
                Producto p = pdao.listarId(idp);
                request.setAttribute("producto", p);
                break;
            case "Actualizar":
                String nombres2 = request.getParameter("txtNombres");
                int precio2 = Integer.parseInt(request.getParameter("txtPrecio"));
                int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                String estado2 = request.getParameter("txtEstado");

                pr.setNombres(nombres2);
                pr.setPrecio(precio2);
                pr.setStock(stock1);
                pr.setEstado(estado2);
                pr.setId(idp);

                pdao.actualizar(pr);
                response.sendRedirect("Controlador?menu=Producto&accion=Listar");
                return;
            case "Eliminar":
                idp = Integer.parseInt(request.getParameter("id"));
                pdao.delete(idp);
                response.sendRedirect("Controlador?menu=Producto&accion=Listar");
                return;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Producto.jsp").forward(request, response);
        return;
    }

    if (menu.equals("NuevaVenta")) {
        switch (accion) {
            case "BuscarCliente":
                String ci = request.getParameter("codigocliente");
                c.setCi(ci);
                c = cdao.buscar(ci);
                request.setAttribute("c", c);
                request.setAttribute("nserie", numeroserie);
                break;
            case "BuscarProducto":
                request.setAttribute("c", c);
                int id = Integer.parseInt(request.getParameter("codigoproducto"));
                pr = pdao.listarId(id);
                request.setAttribute("producto", pr);
                request.setAttribute("lista", lista);
                request.setAttribute("nserie", numeroserie);
                break;
            case "Agregar":
                request.setAttribute("c", c);
                totalPagar = 0.0;
                item = item + 1;
                cod = pr.getId();
                descripcion = request.getParameter("nomproducto");
                precio = Double.parseDouble(request.getParameter("precio"));
                cant = Integer.parseInt(request.getParameter("cant"));
                subtotal = precio * cant;

                v = new Venta();
                v.setItem(item);
                v.setIdproducto(cod);
                v.setDescripcionP(descripcion);
                v.setPrecio(precio);
                v.setCantidad(cant);
                v.setSubtotal(subtotal);

                lista.add(v);
                for (int i = 0; i < lista.size(); i++) {
                    totalPagar = totalPagar + lista.get(i).getSubtotal();
                }
                request.setAttribute("lista", lista);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("nserie", numeroserie);
                break;
            case "Eliminar":
                int itemEliminar = Integer.parseInt(request.getParameter("id"));
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getItem() == itemEliminar) {
                    lista.remove(i);
                    break;
                }
            }
            item = item -1;
            // Recalcular el número de ítems
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).setItem(i + 1);
            }
            totalPagar = 0.0;
            for (int i = 0; i < lista.size(); i++) {
                totalPagar = totalPagar + lista.get(i).getSubtotal();
            }
            request.setAttribute("lista", lista);
            request.setAttribute("totalPagar", totalPagar);
            request.setAttribute("nserie", numeroserie);
            request.setAttribute("c", c);
                break;
            case "GenerarVenta":
                for (int i = 0; i < lista.size(); i++) {
                    Producto pro = new Producto();
                    int cantidad = lista.get(i).getCantidad();
                    int idproducto = lista.get(i).getIdproducto();

                    ProductoDAO ao = new ProductoDAO();
                    pro = ao.buscar(idproducto);
                    int sac = pro.getStock() - cantidad;
                    ao.actualizarStock(idproducto, sac);
                }

                // guardar venta
                v.setIdcliente(c.getId());
                v.setIdempleado(1);
                v.setNumserie(numeroserie);
                v.setFecha("2024-06-20");
                v.setMonto(totalPagar);
                v.setEstado("1");

                vdao.guardarVenta(v);
                // guardar detalle venta
                int idv = Integer.parseInt(vdao.IdVentas());

                for (int i = 0; i < lista.size(); i++) {
                    v = new Venta();
                    v.setId(idv);
                    v.setIdproducto(lista.get(i).getIdproducto());
                    v.setCantidad(lista.get(i).getCantidad());
                    v.setPrecio(lista.get(i).getPrecio());

                    vdao.guardarDetalleVentas(v);
                }
                lista.clear();
                break;
            default:
                numeroserie = vdao.generarSerie();
                if (numeroserie == null) {
                    numeroserie = "00000001";
                } else {
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs = new GenerarSerie();
                    numeroserie = gs.NumeroSerie(incrementar);
                }
                request.setAttribute("nserie", numeroserie);
        }
        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        return;
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
