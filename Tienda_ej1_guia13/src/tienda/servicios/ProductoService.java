package tienda.servicios;

import java.util.ArrayList;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;
import java.util.Scanner;

/**
 *
 * @author Ezequiel
 */
public final class ProductoService {

    public static void crearProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == null) {
                throw new Exception("Debe indicar el precio");
            }
            if (codigoFabricante == null || codigoFabricante <= 0) {
                throw new Exception("Debe indicar el codigo de fabricante");
            }

            //Creamos el producto
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            ProductoDAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void modificarNombrePrecioProducto(String nombre, Double precio, Integer codigo) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio == null || precio <= 0) {
                throw new Exception("Debe indicar el precio");
            }

            //Buscamos
            Producto producto = buscarProductoPorCodigo(codigo);

            //Modificamos
            producto.setNombre(nombre);
            producto.setPrecio(precio);

            ProductoDAO.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void eliminarFabricante(Integer codigo) throws Exception {

        try {

            //Validamos 
            if (codigo == null || codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            ProductoDAO.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    private static Producto buscarProductoPorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            Producto producto = ProductoDAO.buscarProductoPorNombre(nombre);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    private static Producto buscarProductoPorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null || codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            Producto producto = ProductoDAO.buscarProductoPorCodigo(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    private static Producto buscarProductoBarato() throws Exception {

        try {
            Producto producto = ProductoDAO.buscarProductoBarato();

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    private static ArrayList<Producto> listarProductos() throws Exception {

        try {

            ArrayList<Producto> productos = ProductoDAO.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    private static ArrayList<Producto> listarProductosPorRangoPrecio() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.print("Ingresar precio minimo: ");
            int rangoMin = leer.nextInt();
            System.out.print("Ingresar precio maximo: ");
            int rangoMax = leer.nextInt();

            ArrayList<Producto> productos = ProductoDAO.listarPrecioRangoProductos(rangoMin, rangoMax);

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    private static ArrayList<Producto> listarProductosQueContienenNombre() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.print("Ingresar la palabra clave para traer productos segun el nombre: ");
            String nombre = leer.next();

            ArrayList<Producto> productos = ProductoDAO.listarProductosQueContienenNombre(nombre);

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
/////

    public static void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            ArrayList<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirNombreProductos() throws Exception {

        try {

            //Listamos los productos
            ArrayList<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println("nombre: " + p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirNombrePrecioProductos() throws Exception {

        try {

            //Listamos los productos
            ArrayList<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println("nombre: " + p.getNombre() + " | precio: " + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirProductosPorRangoPrecio() throws Exception {
        try {

            //Listamos los productos
            ArrayList<Producto> productos = listarProductosPorRangoPrecio();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirProductosQueContienenNombre() throws Exception {
        try {

            //Listamos los productos
            ArrayList<Producto> productos = listarProductosQueContienenNombre();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void imprimirNombrePrecioProductoBarato() throws Exception {
        try {

            //Listamos los productos
            Producto producto = buscarProductoBarato();

            //Imprimimos los productos
            if (producto == null) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println(producto);
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
