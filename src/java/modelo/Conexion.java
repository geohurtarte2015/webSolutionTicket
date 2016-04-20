/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Giovanni
 */
public class Conexion {
    
    private final String bd="db_informacion";
    private final String classfor="com.mysql.jdbc.Driver";
    private final String url="jdbc:mysql://localhost/"+bd;
    private final String usuario="root";
    private final String clave="hurtarte";
    
    private final Connection con=null;
    private final PreparedStatement pr=null;
    
}
