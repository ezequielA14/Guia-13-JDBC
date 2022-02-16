package tienda.servicios;

import java.util.ArrayList;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Ezequiel
 */
public final class FabricanteService {

    public static void crearFabricante(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            //Creamos el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            FabricanteDAO.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void modificarNombreFabricante(String nombre, Integer codigo) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            //Buscamos
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);

            //Modificamos
            fabricante.setNombre(nombre);

            FabricanteDAO.modificarFabricante(fabricante);
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

            FabricanteDAO.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            Fabricante fabricante = FabricanteDAO.buscarFabricantePorNombre(nombre);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null || codigo <= 0) {
                throw new Exception("Debe indicar el codigo");
            }

            Fabricante fabricante = FabricanteDAO.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Fabricante> listarFabricantes() throws Exception {

        try {

            ArrayList<Fabricante> fabricantes = FabricanteDAO.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los usuarios
            ArrayList<Fabricante> fabricantes = listarFabricantes();

            //Imprimimos los usuarios
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
