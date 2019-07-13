package controle;

import entidades.Turno;
import interfaces.JanelaCadastroTurnos;

public class ControladorCadastroTurnos {
    public ControladorCadastroTurnos(){
        new JanelaCadastroTurnos(this).setVisible(true);
    }    
    
    public static String registrarTurno(Turno turno){
        String turno1 = Turno.buscarTurno(turno);
        if(turno1 == null)
            Turno.registrarTurno(turno);
        return turno1;
    }   
      
    public static String alterarTurno(Turno turno){
        String turno1 = Turno.buscarTurno(turno);
        if(turno1 != null){
            if(turno1.equals("Turno já cadastrado no banco de dados!")){
                Turno.alterarTurno(turno);
                return null;
            }else{
                return turno1;
            }
        }else
            return "Turno não registrado no banco de dados!";
    }
}
