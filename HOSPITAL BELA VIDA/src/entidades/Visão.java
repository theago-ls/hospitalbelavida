package entidades;

public class Visão<T> {
    
    String chave;
    String info;
    
    public Visão(String chave, String info){
        this.chave = chave;
        this.info = info;
    }
    
    public String getChave(){
        return chave;
    }
    
    public void setChave(String chave){
        this.chave = chave;
    }
    
    public String getInfo(){
        return info;
    }
    
    public void setInfo(String info){
        this.info = info;
    }
    
    @Override
    public String toString(){
        return info;
    }
}