package interfaces;

import controle.ControladorPesquisaConsulta;
import entidades.Consulta;
import entidades.Funcionário;
import entidades.Médico;
import entidades.Paciente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class JanelaPesquisaConsulta extends javax.swing.JFrame {
    ControladorPesquisaConsulta controlador;
    int aux = 1;
   
    public JanelaPesquisaConsulta(ControladorPesquisaConsulta controlador) {
        this.controlador = controlador;
        initComponents();
        áreaComboBox.setSelectedIndex(-1);
        tipoComboBox.setSelectedIndex(-1);
    }
    
    public void pesquisar(){
        int área, tipo;
        String bairro;
        ArrayList<Consulta> resultados = new ArrayList();
        
        área = áreaComboBox.getSelectedIndex();
        tipo = tipoComboBox.getSelectedIndex();
        if(bairroTextField.getText().isEmpty()){
            bairro = null;
        }else
            bairro = bairroTextField.getText();
        resultados = controlador.pesquisarConsulta(área,bairro,tipo);       
        if(resultados != null){
            int cont = 1;
            resultadoTextArea.append("\n\nPesquisa "+aux);
            for(Consulta consulta: resultados){
                Paciente paciente = consulta.getPaciente();
                Médico médico = consulta.getMédico();
                resultadoTextArea.append("\n\nConsulta "+cont);
                resultadoTextArea.append("\nÁrea do médico: "+médico.getÁrea().toString()+"\nBairro do paciente: "+paciente.getEndereço().getBairro()+"\nTipo da consulta: "+consulta.getTipo());                
                cont++;
            }
            aux++;
        }else
            JOptionPane.showMessageDialog(this,"Erro ao acessar o banco de dados!","ERRO!",JOptionPane.ERROR_MESSAGE);
    }
    
    private void limpar(){
        áreaComboBox.setSelectedIndex(-1);
        bairroTextField.setText("");
        tipoComboBox.setSelectedIndex(-1);
        resultadoTextArea.setText("");
        aux = 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        áreaLabel = new javax.swing.JLabel();
        áreaComboBox = new javax.swing.JComboBox<>();
        bairroLabel = new javax.swing.JLabel();
        bairroTextField = new javax.swing.JTextField();
        tipoLabel = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoTextArea = new javax.swing.JTextArea();
        resultadoLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pesquisarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        áreaLabel.setText("Área do médico:");

        áreaComboBox.setModel(new DefaultComboBoxModel(Funcionário.ÁREA));

        bairroLabel.setText("Bairro do paciente:");

        tipoLabel.setText("Tipo de consulta:");

        tipoComboBox.setModel(new DefaultComboBoxModel(Consulta.TIPO));

        resultadoTextArea.setEditable(false);
        resultadoTextArea.setColumns(20);
        resultadoTextArea.setRows(5);
        jScrollPane1.setViewportView(resultadoTextArea);

        resultadoLabel.setText("Resultado:");

        pesquisarButton.setText("Pesquisar");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pesquisarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarButton)
                    .addComponent(limparButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(áreaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(áreaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipoLabel)
                            .addComponent(bairroLabel)
                            .addComponent(resultadoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(áreaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(áreaLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroLabel)
                    .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLabel)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(resultadoLabel)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed
        pesquisar();
    }//GEN-LAST:event_pesquisarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limpar();
    }//GEN-LAST:event_limparButtonActionPerformed
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JLabel resultadoLabel;
    private javax.swing.JTextArea resultadoTextArea;
    private javax.swing.JComboBox<String> tipoComboBox;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JComboBox<String> áreaComboBox;
    private javax.swing.JLabel áreaLabel;
    // End of variables declaration//GEN-END:variables
}
