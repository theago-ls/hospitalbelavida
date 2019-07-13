package controle;

import entidades.Paciente;
import interfaces.JanelaCadastroPaciente;

public class ControladorCadastroPaciente {
    
    public ControladorCadastroPaciente(){
        new JanelaCadastroPaciente(this).setVisible(true);
    }
    
    public String inserirPaciente(Paciente paciente){
        Paciente paciente1 = paciente.buscarPaciente(paciente.getCPF());
        if(paciente1 == null){
            return Paciente.inserirPaciente(paciente);
        }else
            return "Paciente já cadastrado no banco de dados";
    }
    
    public String removerPaciente(String cpf){
        Paciente paciente1 = Paciente.buscarPaciente(cpf);
        if(paciente1 != null){            
            return Paciente.removerPaciente(cpf);
        }else
            return "Erro ao remover paciente no banco de dados!";
    }
    
    public String alterarPaciente(Paciente paciente){
        Paciente paciente1 = paciente.buscarPaciente(paciente.getCPF());
        if(paciente1 != null){
            return Paciente.alterarPaciente(paciente);
        }else
            return "Paciente não cadastrado no banco de dados!";
    }
}
