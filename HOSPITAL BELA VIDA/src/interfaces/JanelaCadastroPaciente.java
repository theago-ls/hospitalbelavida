package interfaces;

import controle.ControladorCadastroDiagnóstico;
import controle.ControladorCadastroPaciente;
import entidades.Data;
import entidades.Endereço;
import entidades.Paciente;
import entidades.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JanelaCadastroPaciente extends javax.swing.JFrame {
    
    ControladorCadastroPaciente controlador;
    Vector<Visão<String>>pacientes;
    
    public JanelaCadastroPaciente(ControladorCadastroPaciente controlador) {
        this.controlador = controlador;
        pacientes = Paciente.getVisões(); 
        initComponents();
        diagnósticoButton.setVisible(false);
    }
    
    private void inserirPaciente(){
        Paciente paciente = obterInformações(1);
        String mensagem_erro = null;
        if(paciente != null){           
            mensagem_erro = controlador.inserirPaciente(paciente);
            if(mensagem_erro == null){
                pacientes.add(paciente.getVisão());
                pacientesComboBox.setSelectedItem(pacientes.lastElement());
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }        
        }
    }
  
    private void removerPaciente(){
        Visão<String> paciente = obterPaciente();
        String mensagem_erro = null;
        if(paciente != null){           
            mensagem_erro = controlador.removerPaciente(paciente.getChave());
            if(mensagem_erro == null){
                pacientes.remove(paciente);
                pacientesComboBox.setSelectedIndex(-1);
                pacientesComboBox.updateUI();
            }else{
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }           
        }else{            
            JOptionPane.showMessageDialog(this,"Nenhum paciente selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);            
        }        
    }
   
    private void alterarPaciente(){
        Paciente paciente = Paciente.buscarPaciente(cpfFormattedTextField.getText().replaceAll("[.-]+",""));
        String mensagem_erro = null;
        if(paciente != null){
            paciente = obterInformações(2);            
            mensagem_erro = controlador.alterarPaciente(paciente);
            Visão<String> visão = obterPaciente(paciente.getCPF());
            if(mensagem_erro == null){
                visão.setInfo(paciente.getVisão().getInfo());
                pacientesComboBox.updateUI();
                pacientesComboBox.setSelectedItem(visão);
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }        
        }
    }
    
    private Visão<String> obterPaciente(){
        if(pacientesComboBox.getSelectedIndex() != -1)
            return (Visão<String>) pacientesComboBox.getSelectedItem();
        else
            return null;
    }
    
    private Visão<String> obterPaciente(String cpf){
        for(Visão<String> visão : pacientes){
            if(visão.getChave().equals(cpf))
                return visão;
        }
        return null;
    }
    
    private void consultarPaciente(){
        Visão<String> visão = (Visão) pacientesComboBox.getSelectedItem();        
        preencherCampos(visão.getChave());
    }
    
    private void preencherCampos(String chave){
        Paciente paciente = Paciente.buscarPaciente(chave);
        String dia, mês, ano;
        ano = paciente.getDataNascimento().substring(0,4);
        mês = paciente.getDataNascimento().substring(5,7);
        dia = paciente.getDataNascimento().substring(8);
        
        nomeTextField.setText(paciente.getNome());
        cpfFormattedTextField.setText(String.valueOf(paciente.getCPF()));
        dataFormattedTextField.setText(dia+"/"+mês+"/"+ano);
        logradouroTextField.setText(paciente.getEndereço().getLogradouro());
        númeroTextField.setText(paciente.getEndereço().getNúmero());
        bairroTextField.setText(paciente.getEndereço().getBairro());
        complementoTextField.setText(paciente.getEndereço().getComplemento());
        cepFormattedTextField.setText(paciente.getEndereço().getCEP());
        cidadeTextField.setText(paciente.getEndereço().getCidade());
        estadoComboBox.setSelectedIndex(paciente.getEndereço().getEstado().ordinal());       
        diagnósticoCheckBox.setSelected(paciente.getDiagnóstico());
        if(diagnósticoCheckBox.isSelected())
            diagnósticoButton.setVisible(true);
        telefoneFormattedTextField.setText(paciente.getTelefone());
    }     
   
    
    private Paciente obterInformações(int opcao) {
        String CPF = cpfFormattedTextField.getText().replaceAll("[.-]+","");
        if(CPF.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum CPF informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String Nome = nomeTextField.getText();
        if(Nome.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum nome informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String data;
        data = dataFormattedTextField.getText();
        if(data.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhuma data de nascimento informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        boolean data_valida = Data.validarData(data);
        Data nova_data;
        if(data_valida)
            nova_data = new Data(data.substring(0,2),data.substring(3,5),data.substring(6));
        else{
            JOptionPane.showMessageDialog(this,"Data de nascimento inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }        
        String logradouro = logradouroTextField.getText();     
        if(logradouro.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum logradouro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String número = númeroTextField.getText();
        if(número.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum número de residência informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String bairro = bairroTextField.getText();
        if(bairro.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum bairro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String complemento = complementoTextField.getText();
        String cep = cepFormattedTextField.getText().replace("-","");
        if(cep.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum CEP informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        String cidade = cidadeTextField.getText();
        if(cidade.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhuma cidade informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int estado = estadoComboBox.getSelectedIndex();
        if(estado < 0){
            JOptionPane.showMessageDialog(this,"Nenhum estado selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Endereço endereço = new Endereço(logradouro,número,bairro,complemento,cep,cidade,Endereço.ESTADOS[estado]);
        String telefone = telefoneFormattedTextField.getText().replaceAll("[- ]","");
        if(telefone.isEmpty()){
            JOptionPane.showMessageDialog(this,"Nenhum número de telefone informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }       
        String data1 = Data.getDataSistema();
        Data data_cadastro = new Data(data1.substring(0,2),data1.substring(2,4),data1.substring(4));
        int sexo = sexoComboBox.getSelectedIndex();
        if(sexo == -1){
            JOptionPane.showMessageDialog(this,"Nenhum sexo selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if(diagnósticoCheckBox.isSelected()){
            if(opcao == 1){
                new ControladorCadastroDiagnóstico(2,CPF,Nome);
                return new Paciente(CPF,Nome,Paciente.SEXOS[sexo],nova_data,data_cadastro,telefone,endereço,true);
            }            
        }            
        return new Paciente(CPF,Nome,Paciente.SEXOS[sexo],nova_data,data_cadastro,telefone,endereço,false);
    }

    private void limparCampos(){
        nomeTextField.setText("");
        cpfFormattedTextField.setText("");
        dataFormattedTextField.setText("");
        logradouroTextField.setText("");
        númeroTextField.setText("");
        bairroTextField.setText("");
        complementoTextField.setText("");
        cepFormattedTextField.setText("");
        cidadeTextField.setText("");
        estadoComboBox.setSelectedIndex(-1);        
        telefoneFormattedTextField.setText("");
        diagnósticoCheckBox.setSelected(false);
        diagnósticoButton.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        logradouroLabel = new javax.swing.JLabel();
        logradouroTextField = new javax.swing.JTextField();
        númeroLabel = new javax.swing.JLabel();
        númeroTextField = new javax.swing.JTextField();
        complementoLabel = new javax.swing.JLabel();
        complementoTextField = new javax.swing.JTextField();
        bairroLabel = new javax.swing.JLabel();
        bairroTextField = new javax.swing.JTextField();
        pacientesLabel = new javax.swing.JLabel();
        pacientesComboBox = new javax.swing.JComboBox<>();
        telefoneLabel = new javax.swing.JLabel();
        diagnósticoLabel = new javax.swing.JLabel();
        diagnósticoCheckBox = new javax.swing.JCheckBox();
        diagnósticoButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        consultarButton = new javax.swing.JButton();
        inserirButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        cidadeLabel = new javax.swing.JLabel();
        cidadeTextField = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();
        data_nascimentoLabel = new javax.swing.JLabel();
        dataFormattedTextField = new javax.swing.JFormattedTextField();
        telefoneFormattedTextField = new javax.swing.JFormattedTextField();
        cpfFormattedTextField = new javax.swing.JFormattedTextField();
        cepLabel = new javax.swing.JLabel();
        cepFormattedTextField = new javax.swing.JFormattedTextField();
        sexoLabel = new javax.swing.JLabel();
        sexoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de paciente");
        setPreferredSize(new java.awt.Dimension(700, 300));
        setResizable(false);

        nomeLabel.setText("Nome:");

        cpfLabel.setText("CPF:");

        logradouroLabel.setText("Logradouro:");

        númeroLabel.setText("Número:");

        complementoLabel.setText("Complemento:");

        bairroLabel.setText("Bairro:");

        pacientesLabel.setText("Pacientes:");

        pacientesComboBox.setModel(new DefaultComboBoxModel(pacientes));

        telefoneLabel.setText("Telefone:");
        telefoneLabel.setToolTipText("");

        diagnósticoLabel.setText("Diagnóstico:");

        diagnósticoButton.setText("Informações");
        diagnósticoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnósticoButtonActionPerformed(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(consultarButton);

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });
        jPanel1.add(inserirButton);

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(alterarButton);

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(removerButton);

        limparButton.setText("Limpar campos");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limparButton);

        cidadeLabel.setText("Cidade:");

        estadoLabel.setText("UF:");

        estadoComboBox.setModel(new DefaultComboBoxModel(Endereço.ESTADOS));

        data_nascimentoLabel.setText("Data de nascimento:");

        dataFormattedTextField.setColumns(10);
        try {
            dataFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataFormattedTextField.setText("");

        try {
            telefoneFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## - #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefoneFormattedTextField.setText(" ");

        try {
            cpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfFormattedTextField.setText("");

        cepLabel.setText("CEP:");

        try {
            cepFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cepFormattedTextField.setText("");

        sexoLabel.setText("Sexo:");

        sexoComboBox.setModel(new DefaultComboBoxModel(Paciente.SEXOS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cidadeLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pacientesLabel)
                                        .addComponent(cpfLabel)
                                        .addComponent(nomeLabel)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(complementoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(logradouroLabel, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnósticoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnósticoCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnósticoButton))
                            .addComponent(pacientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(complementoTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(logradouroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(númeroLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(númeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bairroLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(cepLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cepFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cpfFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(data_nascimentoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(telefoneLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sexoLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(sexoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacientesLabel)
                    .addComponent(pacientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoLabel)
                    .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(data_nascimentoLabel)
                    .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneLabel)
                    .addComponent(telefoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logradouroLabel)
                    .addComponent(númeroLabel)
                    .addComponent(númeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroLabel)
                    .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complementoLabel)
                    .addComponent(complementoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepLabel)
                    .addComponent(cepFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cidadeLabel)
                        .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estadoLabel)
                        .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(diagnósticoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(diagnósticoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diagnósticoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirButtonActionPerformed
        inserirPaciente();
    }//GEN-LAST:event_inserirButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        consultarPaciente();
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarButtonActionPerformed
        alterarPaciente();
    }//GEN-LAST:event_alterarButtonActionPerformed

    private void diagnósticoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnósticoButtonActionPerformed
        String nome, cpf;
        nome = nomeTextField.getText();
        cpf = cpfFormattedTextField.getText().replaceAll("[.-]","");
        new ControladorCadastroDiagnóstico(3,cpf,nome);
    }//GEN-LAST:event_diagnósticoButtonActionPerformed

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        removerPaciente();
    }//GEN-LAST:event_removerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JFormattedTextField cepFormattedTextField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JLabel complementoLabel;
    private javax.swing.JTextField complementoTextField;
    private javax.swing.JButton consultarButton;
    private javax.swing.JFormattedTextField cpfFormattedTextField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JFormattedTextField dataFormattedTextField;
    private javax.swing.JLabel data_nascimentoLabel;
    private javax.swing.JButton diagnósticoButton;
    private javax.swing.JCheckBox diagnósticoCheckBox;
    private javax.swing.JLabel diagnósticoLabel;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JButton inserirButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel logradouroLabel;
    private javax.swing.JTextField logradouroTextField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel númeroLabel;
    private javax.swing.JTextField númeroTextField;
    private javax.swing.JComboBox<String> pacientesComboBox;
    private javax.swing.JLabel pacientesLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JComboBox<String> sexoComboBox;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JFormattedTextField telefoneFormattedTextField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
