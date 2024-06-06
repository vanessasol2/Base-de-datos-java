package BaseDatos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Genero {
    public static void main(String[] args)  {
        String ubicacion = "jdbc:sqlite:C:/Users/vsola/Desktop/NotasProgramas/try_recursos/chinook.db";

        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("Ingrese el nombre del género de la canción : ");
        String genero = in.nextLine();

        String consulta = "SELECT tracks.Name AS nombre_cancion, genres.Name AS genero " +
                          "FROM tracks " +
                          "INNER JOIN genres ON tracks.GenreId = genres.GenreId " +
                          "WHERE genres.Name = '" + genero + "'";

        try (Connection conexion = DriverManager.getConnection(ubicacion);
             Statement stm = conexion.createStatement();
             ResultSet resultSet = stm.executeQuery(consulta)) {

            boolean encontrado = false;

            while (resultSet.next()) {
                encontrado = true;
                String nombreCancion = resultSet.getString("nombre_cancion");
                String nombreGenero = resultSet.getString("genero");
                System.out.println("**************************************");
                System.out.println("Nombre Canción: " + nombreCancion + " ---------> Género: " + nombreGenero);
            }

            if (!encontrado) {
                throw new NoExisteGenero("El género no existe");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }catch(NoExisteGenero n) 
        {
            System.err.println(n.getMessage());
        }finally{
            in.close();
        }
    }
    
}


