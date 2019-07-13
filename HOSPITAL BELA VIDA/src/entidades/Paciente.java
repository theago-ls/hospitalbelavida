package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import persistência.BD;

public class Paciente {
    public static enum Sexo{Feminino,Masculino};
    public static Sexo[] SEXOS = {Sexo.Feminino,Sexo.Masculino};
    
    private final String CPF; 
    private String telefone;
    private String nome;
    private Sexo sexo;
    private final Data DATA_NASCIMENTO, DATA_CADASTRO;
    private Endereço endereço;
    private boolean diagnóstico; 
    
    public static String inserirPaciente(Paciente paciente){
        String sql = "INSERT INTO Pacientes(CPF,Nome,Sexo,Data_nascimento,Data_cadastro,Telefone,Diagnóstico) VALUES (?,?,?,?,?,?,?)";
        String sqlend = "INSERT INTO Endereços(Chave,Logradouro,Número,Bairro,Complemento,CEP,Cidade,Estado) VALUES (?,?,?,?,?,?,?,?)";
        try{
            Endereço endereço = paciente.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            PreparedStatement comando2 = BD.conexão.prepareStatement(sqlend);
            comando.setString(1,paciente.getCPF());
            comando.setString(2,paciente.getNome());
            comando.setInt(3,paciente.getSexo().ordinal());
            comando.setString(4,paciente.getDataNascimento());
            comando.setString(5,paciente.getDataCadastro());
            comando.setString(6,paciente.getTelefone());
            comando.setBoolean(7,paciente.getDiagnóstico());
            comando2.setString(1,paciente.getCPF());
            comando2.setString(2,endereço.getLogradouro());
            comando2.setString(3,endereço.getNúmero());
            comando2.setString(4,endereço.getBairro());
            comando2.setString(5,endereço.getComplemento());
            comando2.setString(6,endereço.getCEP());
            comando2.setString(7,endereço.getCidade());
            comando2.setInt(8,endereço.getEstado().ordinal());
            comando.executeUpdate();
            comando2.executeUpdate();            
            comando.close();
            comando2.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao inserir paciente no banco de dados!";            
        }
    } 
    
    public static String removerPaciente(String cpf){
        String sql = "DELETE FROM Pacientes WHERE CPF = ?";
        String sqlend = "DELETE FROM Endereços WHERE Chave = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            PreparedStatement comando2 = BD.conexão.prepareStatement(sqlend);
            comando.setString(1,cpf);  
            comando2.setString(1,cpf);
            comando.executeUpdate();
            comando2.executeUpdate();
            comando.close();         
            comando2.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao deletar paciente no banco de dados!";
        }
    }
    
    public static String alterarPaciente(Paciente paciente){
        String sql = "UPDATE Pacientes, Endereços SET Nome = ?, Telefone = ?, Logradouro = ?,Número = ?,Bairro = ?,Complemento = ?,CEP = ?, Cidade = ?,Estado = ? WHERE CPF = ? AND Chave = ?";
        try{
            Endereço endereço = paciente.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,paciente.getNome());
            comando.setString(2,paciente.getTelefone());
            comando.setString(3,endereço.getLogradouro());
            comando.setString(4,endereço.getNúmero());
            comando.setString(5,endereço.getBairro());
            comando.setString(6,endereço.getComplemento());
            comando.setString(7,endereço.getCEP());
            comando.setString(8,endereço.getCidade());
            comando.setInt(9,endereço.getEstado().ordinal());
            comando.setString(10,paciente.getCPF());
            comando.setString(11,paciente.getCPF());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar paciente no banco de dados!";
        }
    }
    
    public static Paciente buscarPaciente(String cpf){
        String sql = "SELECT CPF, Nome, Sexo, Data_nascimento, Data_cadastro, Telefone, Diagnóstico, Logradouro, Número, Bairro, Complemento, CEP, Cidade, Estado FROM Pacientes, Endereços WHERE CPF = ? AND Chave = ?";
        ResultSet lista_resultados; 
        Paciente paciente = null;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);            
            comando.setString(1, cpf);
            comando.setString(2,cpf);
            lista_resultados = comando.executeQuery();           
            while(lista_resultados.next()){    
                Endereço endereço = new Endereço(lista_resultados.getString("Logradouro"),lista_resultados.getString("Número"),lista_resultados.getString("Bairro"),lista_resultados.getString("Complemento"),lista_resultados.getString("CEP"),lista_resultados.getString("Cidade"),Endereço.ESTADOS[lista_resultados.getInt("Estado")]);
                paciente = new Paciente(cpf,lista_resultados.getString("Nome"),Paciente.SEXOS[lista_resultados.getInt("Sexo")],Data.toData(lista_resultados.getString("Data_nascimento")),Data.toData(lista_resultados.getString("Data_cadastro")),lista_resultados.getString("Telefone"),endereço,lista_resultados.getBoolean("Diagnóstico"));
            }
            comando.close();
            lista_resultados.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return paciente;
    }
    
    public static Vector<Visão<String>> getVisões(){
        String sql = "SELECT CPF, Nome FROM Pacientes";
        ResultSet lista_resultados;
        Vector<Visão<String>> visões = new Vector<Visão<String>>();
        String cpf;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                cpf = lista_resultados.getString("CPF");
                visões.addElement(new Visão<String>(cpf,lista_resultados.getString("Nome")+" - "+cpf));
            }
            lista_resultados.close();
            comando.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
        }
        return visões;
    }
    
    public Visão<String> getVisão(){
        return new Visão<>(CPF,nome+" - "+CPF);
    }
    
    
    public Paciente(String CPF, String NOME, Sexo sexo, Data DATA_NASCIMENTO, Data DATA_CADASTRO, String telefone, Endereço endereço, boolean diagnóstico) {
        this.CPF = CPF;
        this.nome = NOME;
        this.sexo = sexo;
        this.DATA_NASCIMENTO = DATA_NASCIMENTO;
        this.telefone = telefone;
        this.endereço = endereço;
        this.diagnóstico = diagnóstico;
        this.DATA_CADASTRO = DATA_CADASTRO;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Sexo getSexo(){
        return sexo;
    }
    
    public String getDataNascimento(){
        return DATA_NASCIMENTO.toString();
    } 
    
    public Data getDataNascimentoData(){
        return DATA_NASCIMENTO;
    }  
    
    public String getDataCadastro(){
        return DATA_CADASTRO.toString();
    }
    
    public Data getDataCadastroData(){
        return DATA_CADASTRO;
    }
        
    public String getTelefone(){
        return telefone;
    }
    
    public Endereço getEndereço(){
        return endereço;
    }
    
    public boolean getDiagnóstico(){
        return diagnóstico;
    }  
       
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setDiagnóstico(boolean diagnóstico){
        this.diagnóstico = diagnóstico;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEndereço(Endereço endereço){
        this.endereço = endereço;
    }
    
    @Override
    public String toString(){
        String dados;        
        dados = "\n\nPaciente: "+nome+"\nCPF: "+CPF+"\nSexo: "+sexo.toString()+"\nData de nascimento: "+DATA_NASCIMENTO.getDia()+"/"+DATA_NASCIMENTO.getMês()+"/"+DATA_NASCIMENTO.getAno()+"\nData de cadastro: "+DATA_CADASTRO.getDia()+"/"+DATA_CADASTRO.getMês()+"/"+DATA_CADASTRO.getAno()+"\nTelefone: "+telefone;        
        return dados;
    }
}
