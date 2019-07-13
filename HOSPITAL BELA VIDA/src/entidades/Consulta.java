package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

public class Consulta {
    public enum Tipo{Privado,Público};
    public static Tipo[] TIPO = {Tipo.Privado,Tipo.Público};
    
    private Médico médico;
    private Paciente paciente;
    private Data data;
    private Hora horário;
    private Tipo tipo;
    
    public static String agendarConsulta(Consulta consulta){
        String sql = "INSERT INTO Consultas(Médico,Paciente,Data_consulta,Horário,Tipo) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,consulta.getMédico().getCPF());
            comando.setString(2,consulta.getPaciente().getCPF());
            comando.setString(3,consulta.getData());
            comando.setString(4,consulta.getHorário());
            comando.setInt(5,consulta.getTipo().ordinal());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao agendar consulta no banco de dados!";
        }
    } 
    
    public static String alterarConsulta(Consulta consulta){
        String sql = "UPDATE Consultas SET Médico = ?, Data_consulta = ?, Horário = ?, Tipo = ? WHERE Paciente = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,consulta.getMédico().getCPF());
            comando.setString(2,consulta.getData());
            comando.setString(3,consulta.getHorário());
            comando.setInt(4,consulta.getTipo().ordinal());
            comando.setString(5,consulta.getPaciente().getCPF());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar consulta no banco de dados!";
        }
    }
    
    public static String cancelarConsulta(String paciente){
        String sql = "DELETE FROM Consultas WHERE Paciente = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,paciente);
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao cancelar consulta no banco de dados!";
        }        
    }
    
    public static Consulta buscarConsulta(String médico, String paciente){
        String sql = "SELECT * FROM Consultas";
        ResultSet lista_resultado;
        boolean arg = false;
        if(!médico.isEmpty()){
            sql += " WHERE Médico = "+médico;
            arg = true;
        }
        if(!paciente.isEmpty()){
            if(arg)
                sql += " AND Paciente = "+paciente;
            else
                sql += "WHERE Paciente = "+paciente;
        }
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultado = comando.executeQuery();
            while(lista_resultado.next())
                return new Consulta(Médico.buscarMédico(lista_resultado.getString("Médico")),Paciente.buscarPaciente(lista_resultado.getString("Paciente")),Data.toData(lista_resultado.getString("Data_consulta")),Hora.toHora(lista_resultado.getString("Horário")),TIPO[lista_resultado.getInt("Tipo")]);
            
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();            
        }
        return null;
    }
    
    public static ArrayList<Consulta> pesquisarConsulta(int área, String bairro, int tipo){
        int index = 0;
        ArrayList<Consulta> resultados = new ArrayList();
        String sql = "SELECT C.* FROM Consultas C, Endereços E, Médicos M WHERE C.Paciente = E.Chave AND C.Médico = M.CPF";
        if(área > -1){
            sql += " AND M.Especialidade = "+área;
        }
        if(bairro != null){            
            sql += " AND E.Bairro = "+"'"+bairro+"'";            
        }
        if(tipo > -1){
            sql += " AND C.Tipo = "+tipo;
        }        
        ResultSet lista_resultados;        
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()){
                Paciente paciente = Paciente.buscarPaciente(lista_resultados.getString("Paciente"));
                resultados.add(new Consulta(Médico.buscarMédico(lista_resultados.getString("Médico")),paciente,Data.toData(lista_resultados.getString("Data_consulta")),Hora.toHora(lista_resultados.getString("Horário")),Consulta.TIPO[lista_resultados.getInt("Tipo")]));                
            }
            lista_resultados.close();
            comando.close();
            return resultados;
        }catch(SQLException exceção){
            exceção.printStackTrace();
        }
        return null;
    }
    
    public Consulta(Médico médico, Paciente paciente, Data data, Hora horário, Tipo tipo){
        this.médico = médico;
        this.paciente = paciente;
        this.data = data;
        this.horário = horário;
        this.tipo = tipo;
    }
    
    public Médico getMédico(){
        return médico;
    }
    
    public Paciente getPaciente(){
        return paciente;
    }
    
    public String getData(){
        return data.toString();
    }
    
    public String getHorário(){
        return horário.toString();
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public void setMédico(Médico médico){
        this.médico = médico;
    }
    
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    
    public void setData(Data data){
        this.data = data;
    }
    
    public void setHorário(Hora horário){
        this.horário = horário;
    }
    
    @Override
    public String toString(){
        String dados = "\nData da consulta:"+data.getDia()+"/"+data.getMês()+"/"+data.getAno()+"\nHorário da consulta: "+horário.toString();
        return dados;
    }
}
