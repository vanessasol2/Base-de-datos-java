package BaseDatos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datos {

    public static void main(String[] args) {
        // 1. establecemos la ubicacion de la base de datos
        // jdbc drver de onectividad para una base de datos
        // JDBC -> java database conector (Necesita driver especifico para sql life)

        String ubicacion = "jdbc:sqlite:C:/Users/vsola/Desktop/NotasProgramas/try_recursos/chinook.db";

        String consulta = "SELECT art.Name AS nombre_artista, alb.Title AS titulo_album " +
                "FROM artists art , albums alb " +
                "WHERE art.ArtistId = alb.ArtistId " +
                "AND art.Name = 'AC/DC'";

        // 2 establecer la coneccion (abrir)
        try (Connection conexion = DriverManager.getConnection(ubicacion);
                // 3. crear un objeto Statement = transaccion de db representa la transaccion
                
                Statement stm = conexion.createStatement();
                // 4. tratamiento dedatos :
                ResultSet resultSet = stm.executeQuery(consulta)

        ) { // solo objetos de tipo recurso

            // 5. Presentacion de datos nex() ->debuelve un booleano
            while (resultSet.next()) {
                // recorrer los registros obtenidos
                String nombre = resultSet.getString("nombre_artista");
                String album = resultSet.getString("titulo_album");
                System.out.println("ARTISTA: " + nombre + " ||  ALBUM: " + album);
            };
            System.out.println("Conexion exitosa");
            conexion.close();

        } catch (SQLException sqlexcep) {
            System.err.println(sqlexcep.getMessage());
        } finally {
            // Cerrar el recurso
        }
    }
}
