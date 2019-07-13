package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistência.BD;

public class Turno {
    private String funcionário;
    private Hora entrada, saída;
    
    public Turno(String funcionário, Hora entrada, Hora saída){
        this.funcionário = funcionário;        
        this.entrada = entrada;
        this.saída = saída;
    }
    
    public static String registrarTurno(Turno turno){
        String sql = "INSERT INTO Turnos(Funcionário,Entrada,Saída) VALUES(?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,turno.getFuncionário());
            comando.setString(2,turno.getHorárioEntrada());
            comando.setString(3,turno.getHorárioSaída());
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao registrar turno no banco de dados!";
        }        
    }
    
    public static String removerTurno(String cpf){
        String sql = "DELETE FROM Turnos WHERE Funcionário = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, sql);
            comando.executeUpdate();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao remover turno do banco de dados!";
        }
    }
    
    public static String alterarTurno(Turno turno){
        String sql = "UPDATE Turnos SET Entrada = ?, Saída = ? WHERE Funcionário = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, turno.getHorárioEntrada());
            comando.setString(2,turno.getHorárioSaída());
            comando.setString(3,turno.getFuncionário());
            comando.executeUpdate();
            comando.close();            
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();
            return "Erro ao alterar turno no banco de dados!";
        }
    }  
        
    public static String buscarTurno(Turno turno){
        String sql = "SELECT * FROM Turnos WHERE Funcionário = ?";
        ResultSet lista_resultado;
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,turno.getFuncionário());            
            lista_resultado = comando.executeQuery();
            while(lista_resultado.next()){
                lista_resultado.close();
                comando.close();
                return "Turno já cadastrado no banco de dados!";
            }
            lista_resultado.close();
            comando.close();
            return null;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();;
            return "Erro ao acessar banco de dados!";
        }
    }
    
    public static Turno buscarTurno(String cpf){
        String sql = "SELECT * FROM Turnos WHERE Funcionário = ?";
        ResultSet lista_resultado;
        try{
            Turno turno = null;
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1,cpf);            
            lista_resultado = comando.executeQuery();
            while(lista_resultado.next()){
                turno = new Turno(cpf,Hora.toHora(lista_resultado.getString("Entrada")),Hora.toHora(lista_resultado.getString("Saída")));
            }
            lista_resultado.close();
            comando.close();
            return turno;
        }catch(SQLException exceção_sql){
            exceção_sql.printStackTrace();;
            return null;
        }
    }    
    
    public String getFuncionário(){
        return funcionário;
    }   
       
    public String getHorárioEntrada(){
        return entrada.toString();
    }
    
    public String getHorárioSaída(){
        return saída.toString();
    }
    
    public void setFuncionário(String funcionário){
        this.funcionário = funcionário;
    }
    
    public void setHorárioEntrada(Hora entrada){
        this.entrada = entrada;
    }
    
    public void setHorárioSaída(Hora saída){
        this.saída = saída;
    }
}
