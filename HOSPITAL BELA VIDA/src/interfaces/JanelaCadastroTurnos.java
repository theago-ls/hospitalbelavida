package interfaces;

import controle.ControladorCadastroTurnos;
import entidades.Enfermeiro;
import entidades.Funcionário;
import entidades.Hora;
import entidades.Médico;
import entidades.Turno;
import entidades.Visão;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroTurnos extends javax.swing.JFrame {
    ControladorCadastroTurnos controlador;
    Vector<Visão<String>> médicos, enfermeiros;
    DefaultListModel modelo = new DefaultListModel();
    int selecionado;
   
    public JanelaCadastroTurnos(ControladorCadastroTurnos controlador) {
        this.controlador = controlador;        
        initComponents();
    }
    
    private void preencherLista(int opcao){
        médicos = Médico.getVisões();
        enfermeiros = Enfermeiro.getVisões();
        modelo.clear();
        if(opcao == 1){
            for(Visão<String> visão: médicos){
                Visão<String> visãoturno = new Visão<>(visão.getChave(),visão.getInfo()+" - Médico");
                modelo.addElement(visãoturno);
            }
        }
        if(opcao == 2){
            for(Visão<String> visão: enfermeiros){
                Visão<String> visãoturno = new Visão<>(visão.getChave(),visão.getInfo()+" - Enfermeiro");
                modelo.addElement(visãoturno);
            }
        }
        if(opcao == 3){
            for(Visão<String> visão: médicos){
                Visão<String> visãoturno = new Visão<>(visão.getChave(),visão.getInfo()+" - Médico");
                modelo.addElement(visãoturno);
            }
            for(Visão<String> visão: enfermeiros){
                Visão<String> visãoturno = new Visão<>(visão.getChave(),visão.getInfo()+" - Enfermeiro");
                modelo.addElement(visãoturno);                
            }
        }
    }   
   
    
    
    private void registrarTurno(){
        Turno turno = obterInformações();
        String mensagem_erro = null;
        if(turno != null){
           mensagem_erro = controlador.registrarTurno(turno);
           if(mensagem_erro == null)
              JOptionPane.showMessageDialog(this,"Turno registrado com sucesso!","",JOptionPane.WARNING_MESSAGE);
           else
              JOptionPane.showMessageDialog(this,mensagem_erro,"",JOptionPane.ERROR_MESSAGE);
        }
    }  
       
    private void alterarTurno(){
        Turno turno = obterInformações();
        String mensagem_erro = null;
        if(turno != null){
            mensagem_erro = controlador.alterarTurno(turno);
            if(mensagem_erro == null)
                preencherLista(selecionado);
            else
                JOptionPane.showMessageDialog(this,mensagem_erro,"",JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    private void obterTurno(String CPF){
        Turno turno = Turno.buscarTurno(CPF);
        if(turno != null){
            hora_entradaFormattedTextField.setText(turno.getHorárioEntrada());
            hora_saídaFormattedTextField.setText(turno.getHorárioSaída());
        }
        else
            JOptionPane.showMessageDialog(this,"Nenhum turno registrado para o funcionário selecionado","",JOptionPane.ERROR_MESSAGE);
    }
              
    private Turno obterInformações(){           
        int n = funcionáriosList.getSelectedIndex();          
        if(n != -1){
            Hora hora_saída, hora_entrada;
            Visão<String> visão = (Visão<String>) modelo.get(n);
            String funcionário = visão.getChave();            
            String entrada, saída;
            entrada = hora_entradaFormattedTextField.getText();
            saída = hora_saídaFormattedTextField.getText();
            hora_entrada = Hora.validarHora(entrada);
            if(hora_entrada == null){                 
                JOptionPane.showMessageDialog(this,"Horário de entrada inválido!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            hora_saída = Hora.validarHora(saída);
            if(hora_saída == null){
                JOptionPane.showMessageDialog(this,"Horário de saída inválido!","ERRO!",JOptionPane.ERROR_MESSAGE); 
                return null;
            }
            return new Turno(funcionário,hora_entrada,hora_saída);
        }else{
            JOptionPane.showMessageDialog(this,"Selecione o funcionário para registro de turno!","ERRO!",JOptionPane.ERROR_MESSAGE); 
            return null;
        }
    }      
    
    private void limparCampos(){
        hora_entradaFormattedTextField.setText("");
        hora_saídaFormattedTextField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        funcionário_buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        hora_entradaLabel = new javax.swing.JLabel();
        hora_entradaFormattedTextField = new javax.swing.JFormattedTextField();
        hora_saídaLabel = new javax.swing.JLabel();
        hora_saídaFormattedTextField = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        registrar_turnoButton = new javax.swing.JButton();
        alterar_turnoButton = new javax.swing.JButton();
        funcionáriosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        funcionáriosList = new javax.swing.JList<>();
        categoriaLabel = new javax.swing.JLabel();
        todosRadioButton = new javax.swing.JRadioButton();
        médicosRadioButton = new javax.swing.JRadioButton();
        enfermeirosRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(null);

        hora_entradaLabel.setText("Hora de entrada:");
        jPanel2.add(hora_entradaLabel);
        hora_entradaLabel.setBounds(100, 160, 83, 14);

        try {
            hora_entradaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(hora_entradaFormattedTextField);
        hora_entradaFormattedTextField.setBounds(200, 160, 40, 20);

        hora_saídaLabel.setText("Hora de saída:");
        jPanel2.add(hora_saídaLabel);
        hora_saídaLabel.setBounds(280, 160, 70, 14);

        try {
            hora_saídaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(hora_saídaFormattedTextField);
        hora_saídaFormattedTextField.setBounds(370, 160, 40, 20);

        registrar_turnoButton.setText("Registrar");
        registrar_turnoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_turnoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(registrar_turnoButton);

        alterar_turnoButton.setText("Alterar");
        alterar_turnoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar_turnoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(alterar_turnoButton);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(160, 200, 161, 33);

        funcionáriosLabel.setText("Funcionários:");
        jPanel2.add(funcionáriosLabel);
        funcionáriosLabel.setBounds(20, 100, 64, 14);

        funcionáriosList.setModel(modelo);
        funcionáriosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        funcionáriosList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                funcionáriosListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(funcionáriosList);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(100, 70, 332, 77);

        categoriaLabel.setText("Categoria:");
        jPanel2.add(categoriaLabel);
        categoriaLabel.setBounds(30, 30, 51, 14);

        funcionário_buttonGroup.add(todosRadioButton);
        todosRadioButton.setText("Todos funcionários");
        todosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(todosRadioButton);
        todosRadioButton.setBounds(100, 20, 115, 23);

        funcionário_buttonGroup.add(médicosRadioButton);
        médicosRadioButton.setText("Médicos");
        médicosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                médicosRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(médicosRadioButton);
        médicosRadioButton.setBounds(230, 20, 93, 23);

        funcionário_buttonGroup.add(enfermeirosRadioButton);
        enfermeirosRadioButton.setSelected(true);
        enfermeirosRadioButton.setText("Enfermeiros");
        enfermeirosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enfermeirosRadioButtonActionPerformed(evt);
            }
        });
        jPanel2.add(enfermeirosRadioButton);
        enfermeirosRadioButton.setBounds(330, 20, 83, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funcionáriosListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_funcionáriosListValueChanged
        int n = funcionáriosList.getSelectedIndex();
        if(n != -1){
            Visão<String> visão = (Visão<String>)modelo.get(n);
            obterTurno(visão.getChave());
        }
    }//GEN-LAST:event_funcionáriosListValueChanged

    private void alterar_turnoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar_turnoButtonActionPerformed
        alterarTurno();
    }//GEN-LAST:event_alterar_turnoButtonActionPerformed

    private void registrar_turnoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_turnoButtonActionPerformed
        registrarTurno();
    }//GEN-LAST:event_registrar_turnoButtonActionPerformed

    private void todosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosRadioButtonActionPerformed
        funcionáriosList.clearSelection();
        limparCampos();
        selecionado = 3;
        preencherLista(selecionado);
    }//GEN-LAST:event_todosRadioButtonActionPerformed

    private void médicosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_médicosRadioButtonActionPerformed
        funcionáriosList.clearSelection();
        limparCampos();
        selecionado = 1;
        preencherLista(selecionado);
    }//GEN-LAST:event_médicosRadioButtonActionPerformed

    private void enfermeirosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enfermeirosRadioButtonActionPerformed
        funcionáriosList.clearSelection();
        limparCampos();
        selecionado = 2;
        preencherLista(selecionado);
    }//GEN-LAST:event_enfermeirosRadioButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar_turnoButton;
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JRadioButton enfermeirosRadioButton;
    private javax.swing.ButtonGroup funcionário_buttonGroup;
    private javax.swing.JLabel funcionáriosLabel;
    private javax.swing.JList<String> funcionáriosList;
    private javax.swing.JFormattedTextField hora_entradaFormattedTextField;
    private javax.swing.JLabel hora_entradaLabel;
    private javax.swing.JFormattedTextField hora_saídaFormattedTextField;
    private javax.swing.JLabel hora_saídaLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton médicosRadioButton;
    private javax.swing.JButton registrar_turnoButton;
    private javax.swing.JRadioButton todosRadioButton;
    // End of variables declaration//GEN-END:variables
}
