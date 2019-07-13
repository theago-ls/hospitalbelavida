package controle;

import entidades.Diagnóstico;
import interfaces.JanelaCadastroDiagnóstico;

public class ControladorCadastroDiagnóstico {
    public ControladorCadastroDiagnóstico(int opcao, String cpf, String nome){
        new JanelaCadastroDiagnóstico(this,opcao,cpf,nome).setVisible(true);
    }
    
    public String registrarDiagnóstico(Diagnóstico diagnóstico){
        return Diagnóstico.registrarDiagnóstico(diagnóstico);
    }
    
    public String alterarDiagnóstico(Diagnóstico diagnóstico){
        Diagnóstico diagnóstico1 = Diagnóstico.buscarDiagnóstico(diagnóstico.getMédico(),diagnóstico.getPaciente());
        if(diagnóstico1 != null)
            return Diagnóstico.alterarDiagnóstico(diagnóstico);
        else
            return "Diagnóstico não encontrado no banco de dados!";
    }
}
