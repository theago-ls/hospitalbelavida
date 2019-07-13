package interfaces;

import controle.ControladorCadastroDiagnóstico;
import entidades.Data;
import entidades.Diagnóstico;
import entidades.Médico;
import entidades.Paciente;
import entidades.Visão;
import java.time.LocalDate;
import java.time.Period;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class JanelaCadastroDiagnóstico extends javax.swing.JFrame {
    ControladorCadastroDiagnóstico controlador;
    int op;
    Vector<Visão<String>> médicos = new Vector<>();
     Vector<Visão<String>> pacientes = new Vector<>();
   
    public JanelaCadastroDiagnóstico(ControladorCadastroDiagnóstico controlador, int opcao, String cpf, String nome) {
        if(opcao == 1){
            this.controlador = controlador;
            médicos = Médico.getVisões();
            pacientes = Paciente.getVisões();
            op = opcao;
            initComponents();
        }
        if(opcao == 2){
            this.controlador = controlador;
            médicos = Médico.getVisões();
            Visão<String> visão = new Visão<>(cpf,nome+" - "+cpf);
            pacientes.add(visão);
            op = opcao;
            initComponents();
            alterarButton.setVisible(false);
            consultarButton.setVisible(false);
            idadeTextField.setVisible(false);
            idadeLabel.setVisible(false);            
        }
        if(opcao == 3){
            this.controlador = controlador;
            Diagnóstico diagnóstico = Diagnóstico.pesquisarDiagnóstico("",cpf);
            if(diagnóstico != null){
                Visão<String> visão = new Visão<>(cpf,nome+" - "+cpf);
                pacientes.add(visão);
                op = opcao;
                String médico = diagnóstico.getMédico();
                visão = new Visão<>(médico,Médico.buscarMédico(médico).getVisão().getInfo());
                médicos.add(visão);
                initComponents();
                alterarButton.setVisible(false);
                consultarButton.setVisible(false);
                registrarButton.setVisible(false);                
                doençaTextField.setEditable(false);
                observaçãoTextField.setEditable(false);
                data_diagnósticoFormattedTextField.setEditable(false);
                estágioComboBox.setEditable(false);
                consultarDiagnóstico(2,médico,cpf);
            }else{                
                JOptionPane.showMessageDialog(this,"Nenhum diagnóstico registrado para este paciente!","ERRO!",JOptionPane.ERROR_MESSAGE);
                this.controlador = controlador;
                médicos = Médico.getVisões();
                Visão<String> visão = new Visão<>(cpf,nome+" - "+cpf);
                pacientes.add(visão);
                op = 2;
                initComponents();
                alterarButton.setVisible(false);
                consultarButton.setVisible(false);
                idadeTextField.setVisible(false);
                idadeLabel.setVisible(false);                
            }
        }
    }  
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pacienteLabel = new javax.swing.JLabel();
        médicoLabel = new javax.swing.JLabel();
        pacienteComboBox = new javax.swing.JComboBox<>();
        médicoComboBox = new javax.swing.JComboBox<>();
        doençaLabel = new javax.swing.JLabel();
        observaçãoTextField = new javax.swing.JTextField();
        observaçãoLabel = new javax.swing.JLabel();
        doençaTextField = new javax.swing.JTextField();
        estágioLabel = new javax.swing.JLabel();
        estágioComboBox = new javax.swing.JComboBox<>();
        idadeLabel = new javax.swing.JLabel();
        idadeTextField = new javax.swing.JTextField();
        data_diagnósticoLabel = new javax.swing.JLabel();
        data_diagnósticoFormattedTextField = new javax.swing.JFormattedTextField();
        botõesPanel = new javax.swing.JPanel();
        consultarButton = new javax.swing.JButton();
        registrarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pacienteLabel.setText("Paciente:");

        médicoLabel.setText("Médico:");

        pacienteComboBox.setModel(new DefaultComboBoxModel(pacientes));

        médicoComboBox.setModel(new DefaultComboBoxModel(médicos));

        doençaLabel.setText("Doença:");

        observaçãoLabel.setText("Observações:");

        estágioLabel.setText("Estágio:");

        estágioComboBox.setModel(new DefaultComboBoxModel(Diagnóstico.ESTÁGIOS));

        idadeLabel.setText("Idade:");

        idadeTextField.setEditable(false);

        data_diagnósticoLabel.setText("Data do diagnóstico:");

        try {
            data_diagnósticoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });
        botõesPanel.add(consultarButton);

        registrarButton.setText("Registrar");
        registrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarButtonActionPerformed(evt);
            }
        });
        botõesPanel.add(registrarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });
        botõesPanel.add(alterarButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estágioLabel)
                            .addComponent(observaçãoLabel)
                            .addComponent(doençaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(observaçãoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doençaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(estágioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(data_diagnósticoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(data_diagnósticoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pacienteLabel)
                            .addComponent(médicoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pacienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(idadeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(médicoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(botõesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(médicoLabel)
                    .addComponent(médicoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteLabel)
                    .addComponent(pacienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idadeLabel)
                    .addComponent(idadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doençaLabel)
                    .addComponent(doençaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(observaçãoLabel)
                    .addComponent(observaçãoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estágioLabel)
                    .addComponent(estágioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_diagnósticoLabel)
                    .addComponent(data_diagnósticoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botõesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarButtonActionPerformed
        registrarDiagnóstico();
    }//GEN-LAST:event_registrarButtonActionPerformed

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarButtonActionPerformed
        alterarDiagnóstico();
    }//GEN-LAST:event_alterarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        consultarDiagnóstico(1,null,null);
    }//GEN-LAST:event_consultarButtonActionPerformed
   
    private void registrarDiagnóstico(){
        Diagnóstico diagnóstico = obterInformações();
        if(diagnóstico != null){
            String mensagem_erro = controlador.registrarDiagnóstico(diagnóstico);
            if(mensagem_erro != null){
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this,"Diagnóstico registrado!","",JOptionPane.WARNING_MESSAGE);
            limparCampos();
            if(op == 2)
                this.dispose();
        }        
    }
    
    private void alterarDiagnóstico(){
        Diagnóstico diagnóstico = obterInformações();
        if(diagnóstico != null){
            String mensagem_erro = controlador.alterarDiagnóstico(diagnóstico);
            if(mensagem_erro != null){
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this,"Registro de diagnóstico alterado!","",JOptionPane.WARNING_MESSAGE);
            limparCampos();
        }  
    }
    
    private void consultarDiagnóstico(int n,String médico, String paciente){
        if(n != 2){
            Visão<String> visão_médico, visão_paciente;
            visão_paciente = (Visão<String>) pacienteComboBox.getSelectedItem();
            visão_médico = (Visão<String>) médicoComboBox.getSelectedItem();
            Diagnóstico diagnóstico = Diagnóstico.buscarDiagnóstico(visão_médico.getChave(), visão_paciente.getChave());
            Paciente paciente1;
            String idade, data;
            if(diagnóstico != null){
                paciente1 = Paciente.buscarPaciente(visão_paciente.getChave());
                doençaTextField.setText(diagnóstico.getDoença());
                observaçãoTextField.setText(diagnóstico.getObservação());
                estágioComboBox.setSelectedIndex(diagnóstico.getEstágio().ordinal());
                Period período = Period.between(LocalDate.parse(paciente1.getDataNascimento()),LocalDate.now());            
                idade = período.getYears()+ " anos.";
                idadeTextField.setText(idade);
                data = diagnóstico.getData().getDia()+diagnóstico.getData().getMês()+diagnóstico.getData().getAno();
                data_diagnósticoFormattedTextField.setText(data);
            }else
                JOptionPane.showMessageDialog(this,"Nenhum diagnóstico registrado para este paciente!","ERRO!",JOptionPane.ERROR_MESSAGE);
        }
        else{
                Diagnóstico diagnóstico = Diagnóstico.buscarDiagnóstico(médico, paciente);
                Paciente paciente1;
                String idade, data;
                if(diagnóstico != null){
                    paciente1 = Paciente.buscarPaciente(paciente);
                    doençaTextField.setText(diagnóstico.getDoença());
                    observaçãoTextField.setText(diagnóstico.getObservação());
                    estágioComboBox.setSelectedIndex(diagnóstico.getEstágio().ordinal());
                    Period período = Period.between(LocalDate.parse(paciente1.getDataNascimento()),LocalDate.now());            
                    idade = período.getYears()+ " anos.";
                    idadeTextField.setText(idade);
                    data = diagnóstico.getData().getDia()+diagnóstico.getData().getMês()+diagnóstico.getData().getAno();
                    data_diagnósticoFormattedTextField.setText(data);
                }else 
                    JOptionPane.showMessageDialog(this,"Nenhum diagnóstico registrado para este paciente!","ERRO!",JOptionPane.ERROR_MESSAGE);
            }
    }
           
    private Diagnóstico obterInformações(){
        Visão<String> visão;
        String médico,paciente;
        if(médicoComboBox.getSelectedIndex() != -1){
            visão = (Visão<String>) médicoComboBox.getSelectedItem();
            médico = visão.getChave();
        }else{
            JOptionPane.showMessageDialog(this,"Nenhum médico selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if(pacienteComboBox.getSelectedIndex() != -1){
            visão = (Visão<String>) pacienteComboBox.getSelectedItem();
            paciente = visão.getChave();
        }else{
            JOptionPane.showMessageDialog(this,"Nenhum paciente selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String doença = doençaTextField.getText();
        if(doença.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhuma doença informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String observação = observaçãoTextField.getText();
        String data;
        data = data_diagnósticoFormattedTextField.getText();
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum data de nascimento informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }            
        boolean data_valida = Data.validarData(data);
        Data data1;
        if(data_valida)
            data1 = new Data(data.substring(0,2),data.substring(3,5),data.substring(6));
        else{
            JOptionPane.showMessageDialog(this,"Data inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int estágio = estágioComboBox.getSelectedIndex();
        if(estágio == -1){
            JOptionPane.showMessageDialog(this,"Selecione um estágio!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Diagnóstico(médico,paciente,doença,Diagnóstico.ESTÁGIOS[estágio],observação,data1);
    }
    
    private void limparCampos(){
        data_diagnósticoFormattedTextField.setText("");
        doençaTextField.setText("");
        estágioComboBox.setSelectedIndex(-1);
        observaçãoTextField.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel botõesPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JFormattedTextField data_diagnósticoFormattedTextField;
    private javax.swing.JLabel data_diagnósticoLabel;
    private javax.swing.JLabel doençaLabel;
    private javax.swing.JTextField doençaTextField;
    private javax.swing.JComboBox<String> estágioComboBox;
    private javax.swing.JLabel estágioLabel;
    private javax.swing.JLabel idadeLabel;
    private javax.swing.JTextField idadeTextField;
    private javax.swing.JComboBox<String> médicoComboBox;
    private javax.swing.JLabel médicoLabel;
    private javax.swing.JLabel observaçãoLabel;
    private javax.swing.JTextField observaçãoTextField;
    private javax.swing.JComboBox<String> pacienteComboBox;
    private javax.swing.JLabel pacienteLabel;
    private javax.swing.JButton registrarButton;
    // End of variables declaration//GEN-END:variables
}
