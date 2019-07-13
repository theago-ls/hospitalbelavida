package entidades;

import entidades.Paciente.Sexo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import persistência.BD;

public class Enfermeiro extends Funcionário{
    
    public Enfermeiro(String CPF, String nome,Sexo sexo, String telefone, Data data_nascimento, Data data_admissão, Endereço endereço, Funcionário.Área área){
        super(CPF,nome,sexo,telefone,data_nascimento,data_admissão,endereço,área);
    } 
    
    public static Vector<Visão<String>> getVisões(){
        String sql = "SELECT CPF, Nome FROM Enfermeiros";
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

    public static Enfermeiro buscarEnfermeiro(String cpf) {
        String sql = "SELECT CPF, Nome, Sexo, Data_nascimento, Data_admissão, Telefone, Área, Logradouro, Número, Bairro, Complemento, CEP, Cidade, Estado FROM Enfermeiros, Endereços WHERE CPF = ? AND Chave = ?";
        ResultSet lista_resultados; 
        Enfermeiro enfermeiro = null;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);            
            comando.setString(1, cpf);
            comando.setString(2,cpf);
            lista_resultados = comando.executeQuery();           
            while(lista_resultados.next()){    
                Endereço endereço = new Endereço(lista_resultados.getString("Logradouro"),lista_resultados.getString("Número"),lista_resultados.getString("Bairro"),lista_resultados.getString("Complemento"),lista_resultados.getString("CEP"),lista_resultados.getString("Cidade"),Endereço.ESTADOS[lista_resultados.getInt("Estado")]);
                enfermeiro = new Enfermeiro(cpf,lista_resultados.getString("Nome"),Paciente.SEXOS[lista_resultados.getInt("Sexo")],lista_resultados.getString("Telefone"),Data.toData(lista_resultados.getString("Data_nascimento")),Data.toData(lista_resultados.getString("Data_admissão")),endereço,Médico.ÁREA[lista_resultados.getInt("Área")]);
            }
            comando.close();
            lista_resultados.close();
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();            
        }
        return enfermeiro;
    }

    public static String inserirEnfermeiro(Enfermeiro enfermeiro){
        String sql = "INSERT INTO Enfermeiros(CPF,Nome,Sexo,Data_nascimento,Data_admissão,Telefone,Área) VALUES (?,?,?,?,?,?,?)";
        String sqlend = "INSERT INTO Endereços(Chave,Logradouro,Número,Bairro,Complemento,CEP,Cidade,Estado) VALUES (?,?,?,?,?,?,?,?)";
        try{
            Endereço endereço = enfermeiro.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            PreparedStatement comando2 = BD.conexão.prepareStatement(sqlend);
            comando.setString(1,enfermeiro.getCPF());
            comando.setString(2,enfermeiro.getNome());
            comando.setInt(3,enfermeiro.getSexo().ordinal());
            comando.setString(4,enfermeiro.getDataNascimento());
            comando.setString(5,enfermeiro.getDataAdmissão());
            comando.setString(6,enfermeiro.getTelefone());
            comando.setInt(7,enfermeiro.getÁrea().ordinal());
            comando2.setString(1,enfermeiro.getCPF());
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
            return "Erro ao inserir enfermeiro no banco de dados!";            
        }
    } 
    
    public static String removerEnfermeiro(String cpf){
        String sql = "DELETE FROM Enfermeiros WHERE CPF = ?";
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
            return "Erro ao deletar enfermeiro no banco de dados!";
        }
    }
    
    public static String alterarEnfermeiro(Enfermeiro enfermeiro){
        String sql = "UPDATE Enfermeiros, Endereços SET Nome = ?, Telefone = ?, Data_nascimento = ?, Área = ?, Logradouro = ?,Número = ?,Bairro = ?,Complemento = ?,CEP = ?,Cidade = ?,Estado = ? WHERE CPF = ? AND Chave = ?";
        try{
            Endereço endereço = enfermeiro.getEndereço();
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,enfermeiro.getNome());
            comando.setString(2,enfermeiro.getTelefone());
            comando.setString(3,enfermeiro.getDataNascimento());
            comando.setInt(4,enfermeiro.getÁrea().ordinal());
            comando.setString(5,endereço.getLogradouro());
            comando.setString(6,endereço.getNúmero());
            comando.setString(7,endereço.getBairro());
            comando.setString(8,endereço.getComplemento());
            comando.setString(9,endereço.getCEP());
            comando.setString(10,endereço.getCidade());
            comando.setInt(11,endereço.getEstado().ordinal());
            comando.setString(12,enfermeiro.getCPF());
            comando.setString(13,enfermeiro.getCPF());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar enfermeiro no banco de dados!";
        }
    }

    @Override
    public String toString(){
        String dados = "\n\nCategoria: Enfermeiro"+"\nNome: "+nome+"\nCPF: "+CPF+"\nSexo: "+sexo.toString()+"\nData de nascimento: "+data_nascimento.getDia()+"/"+data_nascimento.getMês()+"/"+data_nascimento.getAno()+"\nData de admissão: "+data_admissão.getDia()+"/"+data_admissão.getMês()+"/"+data_admissão.getAno()+"\nÁrea: "+área.toString()+"\n";
        return dados;
    }
}
