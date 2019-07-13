package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistência.BD;

public class Diagnóstico{
    public static enum Estágio{Inicial,Moderado,Avançado,Terminal};
    public static Estágio[] ESTÁGIOS = {Estágio.Inicial,Estágio.Moderado,Estágio.Avançado,Estágio.Terminal};
            
    private final String MÉDICO, PACIENTE;    
    private String doença, observação;
    private Estágio estágio;
    private Data data;

    public static String registrarDiagnóstico(Diagnóstico diagnóstico){
        String sql = "INSERT INTO Diagnósticos(Médico,Paciente,Doença,Estágio,Observação,Data_diagnóstico) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,diagnóstico.getMédico());
            comando.setString(2,diagnóstico.getPaciente());
            comando.setString(3,diagnóstico.getDoença());
            comando.setInt(4,diagnóstico.getEstágio().ordinal());
            comando.setString(5,diagnóstico.getObservação());
            comando.setString(6,diagnóstico.getData().toString());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao registrar diagnóstico no banco de dados!";
        }
    }
    
    public static String alterarDiagnóstico(Diagnóstico diagnóstico){
        String sql = "UPDATE Diagnósticos SET Doença = ?, Estágio = ?, Observação = ? WHERE Médico = ? AND Paciente = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,diagnóstico.getDoença());
            comando.setInt(2,diagnóstico.getEstágio().ordinal());
            comando.setString(3,diagnóstico.getObservação());
            comando.setString(4,diagnóstico.getMédico());
            comando.setString(5,diagnóstico.getPaciente());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar diagnóstico no banco de dados!";
        }        
    }
    
    public static Diagnóstico buscarDiagnóstico(String médico, String paciente){
        String sql = "SELECT * FROM Diagnósticos WHERE Médico = ? AND Paciente = ?";
        ResultSet lista_resultado;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,médico);
            comando.setString(2,paciente);
            lista_resultado = comando.executeQuery();
            while(lista_resultado.next()){
                return new Diagnóstico(médico,paciente,lista_resultado.getString("Doença"),Diagnóstico.ESTÁGIOS[lista_resultado.getInt("Estágio")],lista_resultado.getString("Observação"),Data.toData(lista_resultado.getString("Data_diagnóstico")));
            }
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();            
        }
        return null;
    }
    
    public static Diagnóstico pesquisarDiagnóstico(String médico, String paciente){
        String sql = "SELECT * FROM Diagnósticos";
        boolean arg = false;
        if(!médico.isEmpty()){
            sql += " WHERE Médico = "+médico;
            arg = true;            
        }
        if(!paciente.isEmpty()){            
            if(arg)
                sql += " AND Paciente = "+paciente;
            else
                sql += " WHERE Paciente = "+paciente;
        }
        ResultSet lista_resultado;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultado = comando.executeQuery();
            while(lista_resultado.next()){
                return new Diagnóstico(lista_resultado.getString("Médico"),lista_resultado.getString("Paciente"),lista_resultado.getString("Doença"),Diagnóstico.ESTÁGIOS[lista_resultado.getInt("Estágio")],lista_resultado.getString("Observação"),Data.toData(lista_resultado.getString("Data_diagnóstico")));
            }
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            
        }
        return null;        
    }
    
    public Diagnóstico(String MÉDICO, String PACIENTE, String doença, Estágio estágio, String observação,Data data){
        this.MÉDICO = MÉDICO;
        this.PACIENTE = PACIENTE;
        this.doença = doença;
        this.estágio = estágio;
        this.observação = observação;
        this.data = data;
    }
        
    public String getMédico(){
        return MÉDICO;
    }
    
    public String getPaciente(){
        return PACIENTE;
    }
    
    public String getDoença(){
        return doença;
    }
    
    public Estágio getEstágio(){
        return estágio;
    }
    
    public Data getData(){
        return data;
    }
    
    public String getObservação(){
        return observação;
    }
    
    public void setEstágio(Estágio estágio){
        this.estágio = estágio;
    }    
}
