/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Angelica
 */
public class Calendario {
     public String Fecha_Registro()  {
        java.util.Date utilDate = new java.util.Date();
        long lnmilisegundos = utilDate.getTime();
        Calendar cal = Calendar.getInstance();
        String sqlDate = fechaString(cal);
        
        java.sql.Time sqlTime = new java.sql.Time(lnmilisegundos);
        String f = sqlDate;
        return f;
    }

    private String fechaString(Calendar date) {
        String aux = null;
       // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm a");
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (date != null) {
            aux = sdf.format(date.getTime());
        }
        return aux;
    }
}
