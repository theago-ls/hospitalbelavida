package controle;

import entidades.Consulta;
import interfaces.JanelaPesquisaConsulta;
import java.util.ArrayList;

public class ControladorPesquisaConsulta {
    public ControladorPesquisaConsulta(){
        new JanelaPesquisaConsulta(this).setVisible(true);
    }
    
    public static ArrayList<Consulta> pesquisarConsulta(int área, String bairro, int tipo){
        ArrayList<Consulta> resultado = new ArrayList();
        resultado = Consulta.pesquisarConsulta(área,bairro,tipo);        
        return resultado;
    }
}
