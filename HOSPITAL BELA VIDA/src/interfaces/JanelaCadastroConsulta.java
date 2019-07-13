package interfaces;

import controle.ControladorCadastroConsulta;
import entidades.Consulta;
import entidades.Data;
import entidades.Hora;
import entidades.Médico;
import entidades.Paciente;
import entidades.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JanelaCadastroConsulta extends javax.swing.JFrame {
    ControladorCadastroConsulta controlador;
    Vector<Visão<String>> médicos, pacientes;
    
    public JanelaCadastroConsulta(ControladorCadastroConsulta controlador) {
        this.controlador = controlador;
        médicos = Médico.getVisões();
        pacientes = Paciente.getVisões();
        initComponents();
    }
    
    private void agendarConsulta(){
        Consulta consulta = obterInfo();
        String mensagem_erro;
        if(consulta != null){
            mensagem_erro = controlador.agendarConsulta(consulta);
            if(mensagem_erro != null){
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Consulta agendada.","Confirmação",JOptionPane.WARNING_MESSAGE);
                limpar();
            }            
        }
    }
    
    private void alterarConsulta(){
        Consulta consulta = obterInfo();
        String mensagem_erro;
        if(consulta != null){
            mensagem_erro = controlador.alterarConsulta(consulta);
            if(mensagem_erro != null){
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Consulta alterada.","Confirmação",JOptionPane.WARNING_MESSAGE);
                limpar();
            }
        }
    }
    
    private void cancelarConsulta(){
        int n = médicosComboBox.getSelectedIndex();
        String mensagem_erro;
        Visão<String> médico, paciente;
        if(n != -1){
           médico = (Visão<String>) médicosComboBox.getSelectedItem();
           n = pacientesComboBox.getSelectedIndex();
            if(n != -1){
                paciente = (Visão<String>) pacientesComboBox.getSelectedItem();
                Consulta consulta = Consulta.buscarConsulta(médico.getChave(),paciente.getChave());
                if(consulta != null){
                    mensagem_erro = controlador.cancelarConsulta(médico.getChave(),paciente.getChave());
                    if(mensagem_erro != null){
                        JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(this,"Consulta cancelada.","Confirmação",JOptionPane.WARNING_MESSAGE);
                }
            }
            else
               JOptionPane.showMessageDialog(this,"Nenhum paciente selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE); 
        }
        else
            JOptionPane.showMessageDialog(this,"Nenhum médico selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);
    }
    
    private Consulta obterInfo(){        
        Visão<String> médico;
        Visão<String> paciente;
        int n = médicosComboBox.getSelectedIndex();
        if(n != -1)
            médico = (Visão<String>) médicosComboBox.getSelectedItem();
        else{
            JOptionPane.showMessageDialog(this,"Nenhum médico selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }           
        n = pacientesComboBox.getSelectedIndex();
        if(n != -1)
            paciente = (Visão<String>) pacientesComboBox.getSelectedItem();
        else{
            JOptionPane.showMessageDialog(this,"Nenhum paciente selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String data, horário;
        data = dataFormattedTextField.getText();
        horário = horárioFormattedTextField.getText();
        if((data.isEmpty()) || (!Data.validarData(data))){
            JOptionPane.showMessageDialog(this,"Data inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }       
        if(((horário.isEmpty()) || (Hora.validarHora(horário) == null))){
            JOptionPane.showMessageDialog(this,"Horário inválido!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int tipo = tipoComboBox.getSelectedIndex();
        if(tipo == -1){
            JOptionPane.showMessageDialog(this,"Nenhum tipo selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Consulta(Médico.buscarMédico(médico.getChave()),Paciente.buscarPaciente(paciente.getChave()),new Data(data.substring(0,2),data.substring(3,5),data.substring(6)),Hora.validarHora(horário),Consulta.TIPO[tipo]);         
    }

    private void consultarConsulta(){
        int n = médicosComboBox.getSelectedIndex();
        String mensagem_erro;
        Visão<String> médico, paciente;
        if(n != -1){
           médico = (Visão<String>) médicosComboBox.getSelectedItem();
           n = pacientesComboBox.getSelectedIndex();
            if(n != -1){
                paciente = (Visão<String>) pacientesComboBox.getSelectedItem();
                Consulta consulta = Consulta.buscarConsulta(médico.getChave(),paciente.getChave());
                if(consulta != null){
                    String data = consulta.getData().substring(8)+consulta.getData().substring(5,7)+consulta.getData().substring(0,4);
                    dataFormattedTextField.setText(data);
                    horárioFormattedTextField.setText(consulta.getHorário());
                    tipoComboBox.setSelectedIndex(consulta.getTipo().ordinal());
                }else
                    JOptionPane.showMessageDialog(this,"Nenhuma consulta agendada entre médico e paciente selecionados.","ERRO!",JOptionPane.ERROR_MESSAGE); 
            }
            else
               JOptionPane.showMessageDialog(this,"Nenhum paciente selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE); 
        }
        else
            JOptionPane.showMessageDialog(this,"Nenhum médico selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpar(){
        dataFormattedTextField.setText("");
        horárioFormattedTextField.setText("");
        tipoComboBox.setSelectedIndex(-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        médicoLabel = new javax.swing.JLabel();
        pacienteLabel = new javax.swing.JLabel();
        pacientesComboBox = new javax.swing.JComboBox<>();
        médicosComboBox = new javax.swing.JComboBox<>();
        dataLabel = new javax.swing.JLabel();
        dataFormattedTextField = new javax.swing.JFormattedTextField();
        horárioLabel = new javax.swing.JLabel();
        horárioFormattedTextField = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        consultarButton = new javax.swing.JButton();
        agendarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        tipoLabel = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        médicoLabel.setText("Médico:");

        pacienteLabel.setText("Paciente:");
        pacienteLabel.setToolTipText("");

        pacientesComboBox.setModel(new DefaultComboBoxModel(pacientes));

        médicosComboBox.setModel(new DefaultComboBoxModel(médicos));

        dataLabel.setText("Data:");

        try {
            dataFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        horárioLabel.setText("Horário:");

        try {
            horárioFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(consultarButton);

        agendarButton.setText("Agendar");
        agendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(agendarButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(alterarButton);

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelarButton);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limparButton);

        tipoLabel.setText("Tipo:");

        tipoComboBox.setModel(new DefaultComboBoxModel(Consulta.TIPO));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dataLabel)
                            .addComponent(pacienteLabel)
                            .addComponent(médicoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(horárioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horárioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pacientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(médicosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(médicoLabel)
                    .addComponent(médicosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteLabel)
                    .addComponent(pacientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horárioLabel)
                    .addComponent(horárioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoLabel)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limpar();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        cancelarConsulta();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarButtonActionPerformed
        alterarConsulta();
    }//GEN-LAST:event_alterarButtonActionPerformed

    private void agendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarButtonActionPerformed
        agendarConsulta();
    }//GEN-LAST:event_agendarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        consultarConsulta();
    }//GEN-LAST:event_consultarButtonActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendarButton;
    private javax.swing.JButton alterarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton consultarButton;
    private javax.swing.JFormattedTextField dataFormattedTextField;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JFormattedTextField horárioFormattedTextField;
    private javax.swing.JLabel horárioLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel médicoLabel;
    private javax.swing.JComboBox<String> médicosComboBox;
    private javax.swing.JLabel pacienteLabel;
    private javax.swing.JComboBox<String> pacientesComboBox;
    private javax.swing.JComboBox<String> tipoComboBox;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables
}
