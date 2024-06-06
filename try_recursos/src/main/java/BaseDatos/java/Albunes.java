package BaseDatos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Albunes {

    public static void main(String[] args) {
        String ubicacion = "jdbc:sqlite:C:/Users/vsola/Desktop/NotasProgramas/try_recursos/chinook.db";

        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("Ingrese el nombre del artista del cual desea ver los álbumes: ");
        String nombreArtista = in.nextLine();

        String consulta = "SELECT albums.Title " +
                          "FROM albums " +
                          "INNER JOIN artists ON albums.ArtistId = artists.ArtistId " +
                          "WHERE artists.Name = '" + nombreArtista + "'";

        try (Connection conexion = DriverManager.getConnection(ubicacion);
             Statement stm = conexion.createStatement();
             ResultSet resultSet = stm.executeQuery(consulta)) {

            boolean found = false;

            while (resultSet.next()) {
                found = true;
                String nombreAlbum = resultSet.getString("Title");
                System.out.println("Álbum: " + nombreAlbum);
            }

            if (!found) {
                throw new ArtistaNoExiste("Artista no existe");
            }
        } catch (ArtistaNoExiste a) {
            System.err.println(a.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            in.close();
        }
    }
    
}
