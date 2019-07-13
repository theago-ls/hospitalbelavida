package entidades;

public class Hora {
    private String horas, minutos;
    
    public Hora(String horas, String minutos){
        this.horas = horas;
        this.minutos = minutos;
    }
    
    public String getHoras(){
        return horas;
    }
    
    public String getMinutos(){
        return minutos;
    }
    
    public void setHoras(String horas){
        this.horas = horas;
    }
    
    public void setMinutos(String minutos){
        this.minutos = minutos;
    }
    
    public static Hora toHora(String hora){
        return new Hora(hora.substring(0,2),hora.substring(3));
    }
    
    public static Hora validarHora(String hora){
        if((Integer.parseInt(hora.substring(0,2)) < 24) && (Integer.parseInt(hora.substring(3)) < 59))
            return new Hora(hora.substring(0,2),hora.substring(3));
        else
            return null;
    }
    
    @Override
    public String toString(){
        return horas+":"+minutos;
    }
}
