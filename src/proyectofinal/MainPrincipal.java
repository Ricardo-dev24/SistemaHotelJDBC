/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;
import Conexion.CreateConnection;
import java.sql.SQLException;
/**
 *
 * @author ricar
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class MainPrincipal {
    
    public static void main(String[] args) throws SQLException{
        CreateConnection conexionPostgres = new CreateConnection();
        Connection conn= conexionPostgres.getConnection();
            try{
                Statement smt = conn.createStatement();
                String qry = "insert into public.empelado(nombre,apellido,salario)"
                        + "values('Ricardo','López',8000)";
                int filasInsertadas = smt.executeUpdate(qry);
                System.out.println("Total de Registros insertados"+filasInsertadas);
                smt.close();
            } catch (SQLException e){
                e.getMessage();
            }
    }
    /**
     * @param args the command line arguments
     */
   
}
