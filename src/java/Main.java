
import dao.DaoGeneric;
import pojo.Agencia;
import pojo.Estado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Giovanni
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Agencia agencia = new Agencia("Agencia1");
        Estado estado = new Estado();
        estado.setDescripcion("descripcion");
        
        new DaoGeneric().save(agencia);
        
    }
    
}
