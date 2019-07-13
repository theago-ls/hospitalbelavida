
package entidades;

public class Endereço {    
    public enum Estado{AC,AL,AP,AM,BA,CE,DF,ES,GO,MA,MG,MS,MT,PA,PB,PE,PI,PR,RJ,RN,RO,RR,RS,SC,SE,SP,TO};
    public static Estado[] ESTADOS = {Estado.AC,Estado.AL,Estado.AM,Estado.AP,Estado.BA,Estado.CE,Estado.DF,Estado.ES,Estado.GO,
    Estado.MA,Estado.MG,Estado.MS,Estado.MT,Estado.PA,Estado.PB,Estado.PE,Estado.PI,Estado.PR,Estado.RJ,Estado.RN,
    Estado.RO,Estado.RR,Estado.RS,Estado.SC,Estado.SE,Estado.SP};    
    
    private String complemento, bairro, cidade, logradouro, número, cep;    
    private Estado estado;
    
    
    public Endereço(String logradouro, String número, String bairro, String complemento, String cep, String cidade, Estado estado){
        this.logradouro = logradouro;
        this.número = número;
        this.complemento = complemento;  
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
       
    public String getNúmero(){
        return número;
    }
    
    public String getComplemento(){
        return complemento;
    }
    
    public String getLogradouro(){
        return logradouro;
    }
    
    public String getBairro(){
        return bairro;
    }
    
    public String getCEP(){
        return cep;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public Estado getEstado(){
        return estado;
    }
        
    public void setNúmero(String número){
        this.número = número;
    }
    
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }
    
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    
    public void setCEP(String cep){
        this.cep = cep;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return logradouro+", "+número+", "+bairro+", "+cidade+" - "+estado;
    }
}
