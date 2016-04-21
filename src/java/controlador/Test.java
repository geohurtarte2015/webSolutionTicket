/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoAnalista;
import pojo.Analista;

/**
 *
 * @author Giovanni
 */
public class Test {
    
    
    public static void main(String[] args){
        DaoAnalista daoAnalista = new DaoAnalista();
        
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");
        daoAnalista.SaveAnalista(analista);  
        
    }
    
}
