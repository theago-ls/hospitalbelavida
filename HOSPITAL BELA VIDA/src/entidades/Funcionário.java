package entidades;

import entidades.Data;
import entidades.Endereço;
import entidades.Paciente.Sexo;

public class Funcionário {    
    public enum Área{Dermatologia,Ginecologia,Neurologia,Ortopedia,Pediatria,Traumatologia,Urologia};
    public static Área[] ÁREA = {Área.Dermatologia,Área.Ginecologia,Área.Neurologia,Área.Ortopedia,Área.Pediatria,Área.Traumatologia,Área.Urologia};
    
    protected final String CPF;
    protected String telefone;
    protected String nome;
    protected Data data_nascimento, data_admissão;
    protected Endereço endereço;
    protected Área área;
    protected Sexo sexo;
    
    public Funcionário(String CPF, String nome, Sexo sexo, String telefone, Data data_nascimento, Data data_admissão, Endereço endereço, Área área){
        this.CPF = CPF;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.data_admissão = data_admissão;
        this.endereço = endereço;
        this.área = área;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public Sexo getSexo(){
        return sexo;
    }
    
    public String getDataNascimento(){
        return data_nascimento.toString();
    }
    
    public Data getDataNascimentoData(){
        return data_nascimento;
    }
    
    public String getDataAdmissão(){
        return data_admissão.toString();
    }
    
    public Data getDataAdmissãoData(){
        return data_admissão;
    }
    
    public Endereço getEndereço(){
        return endereço;
    }
    
        public Médico.Área getÁrea(){
        return área;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setEndereço(Endereço endereço){
        this.endereço = endereço;
    }
    
    public void setÁrea(Médico.Área área){
        this.área = área;
    }   
}
