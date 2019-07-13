package entidades;

import entidades.Paciente.Sexo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import persistência.BD;

public class Médico extends Funcionário{    
    private final String CRM;   
    
    public static Vector<Visão<String>> getVisões(){
        String sql = "SELECT CPF, Nome FROM Médicos";
        ResultSet lista_resultados;
        Vector<Visão<String>> visões = new Vector<>();
        String cpf;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                cpf = lista_resultados.getString("CPF");
                visões.add(new Visão<String>(cpf,lista_resultados.getString("Nome")+" - "+cpf));
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
    
    public static String inserirMédico(Médico médico){
        String sql = "INSERT INTO Médicos(CPF,CRM,Nome,Sexo,Data_nascimento,Data_admissão,Telefone,Especialidade) VALUES (?,?,?,?,?,?,?,?)";
        String sqlend = "INSERT INTO Endereços(Chave,Logradouro,Número,Bairro,Complemento,CEP,Cidade,Estado) VALUES (?,?,?,?,?,?,?,?)";
        try{
            Endereço endereço = médico.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            PreparedStatement comando2 = BD.conexão.prepareStatement(sqlend);
            comando.setString(1,médico.getCPF());
            comando.setString(2,médico.getCRM());
            comando.setString(3,médico.getNome());
            comando.setInt(4,médico.getSexo().ordinal());
            comando.setString(5,médico.getDataNascimento());
            comando.setString(6,médico.getDataAdmissão());
            comando.setString(7,médico.getTelefone());
            comando.setInt(8,médico.getÁrea().ordinal());
            comando2.setString(1,médico.getCPF());
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
            return "Erro ao inserir médico no banco de dados!";            
        }
    } 
    
    public static String removerMédico(String cpf){
        String sql = "DELETE FROM Médicos WHERE CPF = ?";
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
            Turno.removerTurno(cpf);
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao deletar médico no banco de dados!";
        }
    }
    
    public static String alterarMédico(Médico médico){
        String sql = "UPDATE Médicos, Endereços SET Nome = ?, Telefone = ?, Data_nascimento = ?, Logradouro = ?,Número = ?,Bairro = ?,Complemento = ?,CEP = ?,Cidade = ?,Estado = ? WHERE CPF = ? AND Chave = ?";
        try{
            Endereço endereço = médico.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,médico.getNome());
            comando.setString(2,médico.getTelefone());
            comando.setString(3,médico.getDataNascimento());
            comando.setString(4,endereço.getLogradouro());
            comando.setString(5,endereço.getNúmero());
            comando.setString(6,endereço.getBairro());
            comando.setString(7,endereço.getComplemento());
            comando.setString(8,endereço.getCEP());
            comando.setString(9,endereço.getCidade());
            comando.setInt(10,endereço.getEstado().ordinal());
            comando.setString(11,médico.getCPF());
            comando.setString(12,médico.getCPF());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar médico no banco de dados!";
        }
    }
    
    public static Médico buscarMédico(String cpf){
        String sql = "SELECT CPF, CRM, Sexo, Nome, Data_nascimento, Data_admissão, Telefone, Especialidade, Logradouro, Número, Bairro, Complemento, CEP, Cidade, Estado FROM Médicos, Endereços WHERE CPF = ? AND Chave = ?";
        ResultSet lista_resultados; 
        Médico médico = null;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);            
            comando.setString(1, cpf);
            comando.setString(2,cpf);
            lista_resultados = comando.executeQuery();           
            while(lista_resultados.next()){    
                Endereço endereço = new Endereço(lista_resultados.getString("Logradouro"),lista_resultados.getString("Número"),lista_resultados.getString("Bairro"),lista_resultados.getString("Complemento"),lista_resultados.getString("CEP"),lista_resultados.getString("Cidade"),Endereço.ESTADOS[lista_resultados.getInt("Estado")]);
                médico = new Médico(lista_resultados.getString("CRM"),cpf,lista_resultados.getString("Nome"),Paciente.SEXOS[lista_resultados.getInt("Sexo")],Data.toData(lista_resultados.getString("Data_nascimento")),Data.toData(lista_resultados.getString("Data_admissão")),endereço,lista_resultados.getString("Telefone"),Funcionário.ÁREA[lista_resultados.getInt("Especialidade")]);
            }
            comando.close();
            lista_resultados.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();            
        }
        return médico;
    }
    
    public Médico (String CRM, String CPF, String nome, Sexo sexo, Data data_nascimento, Data data_admissão, Endereço endereço, String telefone, Área área){
        super(CPF,nome,sexo,telefone,data_nascimento,data_admissão,endereço,área);
        this.CRM = CRM;
    }
    
    public String getCRM(){
        return CRM;
    }     
    
    @Override
    public String toString(){
        String dados = "\n\nCategoria: Médico"+"\nNome: "+nome+"\nCPF: "+CPF+"\nCRM: "+CRM+"\nSexo: "+sexo.toString()+"\nData de nascimento: "+data_nascimento.getDia()+"/"+data_nascimento.getMês()+"/"+data_nascimento.getAno()+"\nData de admissão: "+data_admissão.getDia()+"/"+data_admissão.getMês()+"/"+data_admissão.getAno()+"\nÁrea: "+área.toString();
        return dados;
    }
}
