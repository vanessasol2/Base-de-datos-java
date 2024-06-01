package com.excepciones.java.tryrecurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class PruebaSQLite {
    public static void main(String[] args) {
        // 1. Establecer la ubicacion de la base de datos:
        // jdbc: java database connector
        // necesitamos el driver epecifico par sqlite
        String ubicacion = "jdbc:sqlite:C:/Users/APRENDIZ/Desktop/excepciones/chinook.db";
        String consulta = "SELECT art.Name AS nombre_artista, " + //
                        "alb.Title  as titulo_album " + //
                        "FROM artists art,albums alb " + //
                        "WHERE art.ArtistId = alb.ArtistId " + //
                        "AND art.Name = 'AC/DC' ";
        


        try(Connection conn = DriverManager.getConnection(ubicacion);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(consulta);
        ){
            //2. Establecer conexion
            //conn = DriverManager.getConnection(ubicacion);//
            /*3 crear un objeto statemente=transaccion de base de datos */
            //4.tratamiento de datos ResultSet
            //ResultSet resultSet = statement.executeQuery(consulta);
            //5. presentacion de datos:
            while(resultSet.next()){
                //recorer los registros obtenidos
                String nombre = resultSet.getString("nombre_artista");
                String titulo = resultSet.getString("titulo_album");
                System.out.println("Artista: "+ nombre + ", Titulo " + titulo);
            }
            System.out.println("Conexion exitosa");
            conn.close();
        }catch(SQLException sqlex){
            System.out.println(sqlex.getMessage());
        } finally{


        }
     
    }


}
