package entidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
    private String dia, mês, ano;
    
    public Data(String dia, String mês, String ano){
        this.dia = dia;
        this.mês = mês;
        this.ano = ano;
    }
    
    public String getDia(){
        return dia;
    }
    
    public String getMês(){
        return mês;
    }
    
    public String getAno(){
        return ano;
    }
    
    public static String getDataSistema(){
        DateFormat data = new SimpleDateFormat("ddMMyyyy");
        Date data1 = new Date();
        return data.format(data1);    
    }
    
    public void setDia(String dia){
        this.dia = dia;
    }
    
    public void setMês(String mês){
        this.mês = mês;
    }
    
    public void setAno(String ano){
        this.ano = ano;
    }
    
    public static Data toData(String data){
        String dia, mês, ano;
        ano = data.substring(0,4);
        mês = data.substring(5,7);
        dia = data.substring(8,10);
        return new Data(dia,mês,ano);
    }
    
    public static boolean validarData(String data){
        try {
            DateFormat data1 = new SimpleDateFormat("dd/MM/yyyy");
            data1.setLenient(false);
            data1.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return ano+"-"+mês+"-"+dia;
    }
}
