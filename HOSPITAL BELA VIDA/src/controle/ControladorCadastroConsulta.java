package controle;

import entidades.Consulta;
import interfaces.JanelaCadastroConsulta;


public class ControladorCadastroConsulta {
    public ControladorCadastroConsulta(){
        new JanelaCadastroConsulta(this).setVisible(true);
    }
    
    public static String agendarConsulta(Consulta consulta){
        Consulta consulta1 = Consulta.buscarConsulta(consulta.getMédico().getCPF(),consulta.getPaciente().getCPF());
        if(consulta1 == null)
            return Consulta.agendarConsulta(consulta);
        else
            return "Consulta já agendada!";
    }
    
    public static String alterarConsulta(Consulta consulta){
        Consulta consulta1 = Consulta.buscarConsulta(consulta.getMédico().getCPF(),consulta.getPaciente().getCPF());
        if(consulta1 != null)
            return Consulta.alterarConsulta(consulta);
        else
            return "Consulta não encontrada!";
    }
    
    public static String cancelarConsulta(String médico, String paciente){
        Consulta consulta1 = Consulta.buscarConsulta(médico,paciente);
        if(consulta1 != null)
            return Consulta.cancelarConsulta(paciente);
        else
            return "Consulta não encontrada!";
    }
}
