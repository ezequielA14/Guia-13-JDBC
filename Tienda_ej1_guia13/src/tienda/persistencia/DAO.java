package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ezequiel
 */
public abstract class DAO {

    protected static Connection conexion = null;
    protected static ResultSet resultado = null;
    protected static Statement sentencia = null;
    
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "tienda";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    protected static void conectarBase() throws Exception {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected static void desconectarBase() throws SQLException {
        try {
            if (resultado != null) {
                resultado.close();
            }
            
            if (sentencia != null) {
                sentencia.close();
            }
            
            if (conexion != null) {
                conexion.close();
            }
            
        } catch (SQLException ex) {
            throw ex;
        }
    }

    protected static void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected static void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
