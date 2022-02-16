package tienda;

import java.util.Scanner;
import tienda.servicios.*;

/**
 *
 * @author Ezequiel
 */
public class MainTienda {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String respuesta = null;
        String nombre = null;
        Double precio = null;
        Integer codigoFabricante = null;
        Integer codigo = null;

        try {
            do {
                System.out.println("MENU DB TIENDA"
                        + "\nIngrese el número de la opcion que desea realizar:"
                        + "\n1. Listar el nombre de todos los productos."
                        + "\n2. Listar el nombre y el precio de todos los productos."
                        + "\n3. Listar aquellos productos que su precio esté entre un rango especifico."
                        + "\n4. Listar todos los Portátiles."
                        + "\n5. Listar el nombre y el precio del producto más barato."
                        + "\n6. Ingresar un producto a la base de datos."
                        + "\n7. Ingresar un fabricante a la base de datos."
                        + "\n8. Editar un producto."
                        + "\n9. Finalizar Programa.");
                System.out.print("\nElección: ");
                respuesta = leer.next();
                
                switch (respuesta) {
                    case "1":
                        ProductoService.imprimirNombreProductos();
                        break;
                    case "2":
                        ProductoService.imprimirNombrePrecioProductos();
                        break;
                    case "3":
                        ProductoService.imprimirProductosPorRangoPrecio();
                        break;
                    case "4":
                        ProductoService.imprimirProductosQueContienenNombre();
                        break;
                    case "5":
                        ProductoService.imprimirNombrePrecioProductoBarato();
                        break;
                    case "6":
                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = leer.next();
                        System.out.print("Ingrese el precio del producto: ");
                        precio = leer.nextDouble();
                        System.out.print("Ingrese el codigo de fabricante del producto: ");
                        codigoFabricante = leer.nextInt();
                        ProductoService.crearProducto(nombre, precio, codigoFabricante);
                        break;
                    case "7":
                        System.out.print("Ingrese el nombre del fabricante: ");
                        nombre = leer.next();
                        FabricanteService.crearFabricante(nombre);
                        break;
                    case "8":
                        System.out.print("Ingrese el nombre nuevo del producto: ");
                        nombre = leer.next();
                        System.out.print("Ingrese el precio nuevo del producto: ");
                        precio = leer.nextDouble();
                        System.out.print("Ingrese el codigo del producto que desea modificar: ");
                        codigo = leer.nextInt();
                        ProductoService.modificarNombrePrecioProducto(nombre, precio, codigo);
                        break;
                    case "9":
                        System.out.println("Hasta Pronto!");
                        break;
                    default:
                        System.out.println("El valor ingresado no es válido...");
                        break;
                }
                System.out.println("");
                
            } while (!respuesta.equals("9"));

        } catch (Exception e) {
        }

    }
}
