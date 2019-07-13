package controle;

import entidades.Enfermeiro;
import entidades.Médico;
import interfaces.JanelaCadastroFuncionário;

public class ControladorCadastroFuncionário {
    public ControladorCadastroFuncionário(){
        new JanelaCadastroFuncionário(this).setVisible(true);
    }
    
    public String inserirMédico(Médico médico){
        Médico médico1 = médico.buscarMédico(médico.getCPF());
        if(médico1 == null){
            return Médico.inserirMédico(médico);
        }else
            return "Médico já cadastrado no banco de dados!";
    }
    
    public String removerMédico(String cpf){
        Médico médico1 = Médico.buscarMédico(cpf);
        if(médico1 != null){
            return Médico.removerMédico(cpf);
        }else
            return "Erro ao remover médico do banco de dados!";
    }
    
    public String alterarMédico(Médico médico){
        Médico médico1 = Médico.buscarMédico(médico.getCPF());
        if(médico1 != null){
            return Médico.alterarMédico(médico);
        }else
            return "Erro ao alterar médico no banco de dados!";
    }
    
    public String inserirEnfermeiro(Enfermeiro enfermeiro){
        Enfermeiro enfermeiro1 = enfermeiro.buscarEnfermeiro(enfermeiro.getCPF());
        if(enfermeiro1 == null){
            return Enfermeiro.inserirEnfermeiro(enfermeiro);
        }else
            return "Enfermeiro já cadastrado no banco de dados!";
    }
    
    public String removerEnfermeiro(String cpf){
        Enfermeiro enfermeiro1 = Enfermeiro.buscarEnfermeiro(cpf);
        if(enfermeiro1 != null){
            return Enfermeiro.removerEnfermeiro(cpf);
        }else
            return "Erro ao remover enfermeiro do banco de dados!";
    }
    
    public String alterarEnfermeiro(Enfermeiro enfermeiro){
        Enfermeiro enfermeiro1 = Enfermeiro.buscarEnfermeiro(enfermeiro.getCPF());
        if(enfermeiro1 != null){
            return Enfermeiro.alterarEnfermeiro(enfermeiro);
        }else
            return "Erro ao alterar enfermeiro no banco de dados!";
    }
}
