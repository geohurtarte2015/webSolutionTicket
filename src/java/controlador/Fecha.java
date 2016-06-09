
package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Fecha {
    
    //Obtiene fecha actual
    public String fechaHoy(){
            String fecha;
            Calendar calendario = Calendar.getInstance();            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy kk:mm:ss");
            fecha = formatoFecha.format(calendario.getTime());
            return fecha;
    }
}
