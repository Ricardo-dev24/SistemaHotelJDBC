/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ricar
 */
public class CreateConnection {
static Properties config = new Properties();

String hostname = null;
String port = null;
String database = null;
String username = null;
String password = null;
String jndi = null;

public CreateConnection(){
    String path = "C:\\Users\\ricar\\Documents\\NetBeansProjects\\ProyectoFinal\\src\\Conexion\\db_config.properties";
    InputStream in = null;
    try{
        in = Files.newInputStream(Paths.get(path));
        config.load(in);
        in.close();
    }catch (IOException ex){
        ex.printStackTrace();
    }finally{
        try{
            in.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    loadProperties();
}

public void loadProperties(){
    hostname = config.getProperty("hostname");
    port = config.getProperty("port");
    database = config.getProperty("database");
    username = config.getProperty("username");
    password = config.getProperty("password");
}

public Connection getConnection() throws SQLException{
    Connection con = null;
    
    String jdbcUrl = "jdbc:postgresql://"+this.hostname+":"+this.port+"/"+this.database;
    
    con = DriverManager.getConnection(jdbcUrl, username, password);
    System.out.println("Conexión establecida");
    
    return con;
}
}
