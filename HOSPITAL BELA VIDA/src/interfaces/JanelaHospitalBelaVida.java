package interfaces;

import controle.ControladorCadastroConsulta;
import controle.ControladorCadastroDiagnóstico;
import controle.ControladorCadastroFuncionário;
import controle.ControladorCadastroPaciente;
import controle.ControladorCadastroTurnos;
import controle.ControladorPesquisaConsulta;
import persistência.BD;


public class JanelaHospitalBelaVida extends javax.swing.JFrame {

    public JanelaHospitalBelaVida() {
        BD.criaConexão();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBar = new javax.swing.JMenuBar();
        pacienteMenu = new javax.swing.JMenu();
        cadastrar_pacienteMenuItem = new javax.swing.JMenuItem();
        diagnósticosMenuItem = new javax.swing.JMenuItem();
        médicoMenu = new javax.swing.JMenu();
        cadastrar_médicoMenuItem = new javax.swing.JMenuItem();
        turnosMenuItem = new javax.swing.JMenuItem();
        consultaMenu = new javax.swing.JMenu();
        agendar_consultaMenuItem = new javax.swing.JMenuItem();
        pesquisaMenu = new javax.swing.JMenu();
        pesquisarMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Bela Vida");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pacienteMenu.setText("Paciente");
        pacienteMenu.setToolTipText("");

        cadastrar_pacienteMenuItem.setText("Cadastro de pacientes");
        cadastrar_pacienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_pacienteMenuItemActionPerformed(evt);
            }
        });
        pacienteMenu.add(cadastrar_pacienteMenuItem);

        diagnósticosMenuItem.setText("Diagnósticos");
        diagnósticosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnósticosMenuItemActionPerformed(evt);
            }
        });
        pacienteMenu.add(diagnósticosMenuItem);

        MenuBar.add(pacienteMenu);

        médicoMenu.setText("Funcionário");

        cadastrar_médicoMenuItem.setText("Cadastro de funcionários");
        cadastrar_médicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_médicoMenuItemActionPerformed(evt);
            }
        });
        médicoMenu.add(cadastrar_médicoMenuItem);

        turnosMenuItem.setText("Turnos");
        turnosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnosMenuItemActionPerformed(evt);
            }
        });
        médicoMenu.add(turnosMenuItem);

        MenuBar.add(médicoMenu);

        consultaMenu.setText("Consulta");

        agendar_consultaMenuItem.setText("Agendar consulta");
        agendar_consultaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendar_consultaMenuItemActionPerformed(evt);
            }
        });
        consultaMenu.add(agendar_consultaMenuItem);

        MenuBar.add(consultaMenu);

        pesquisaMenu.setText("Pesquisa");

        pesquisarMenuItem.setText("Pesquisar");
        pesquisarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarMenuItemActionPerformed(evt);
            }
        });
        pesquisaMenu.add(pesquisarMenuItem);

        MenuBar.add(pesquisaMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrar_pacienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_pacienteMenuItemActionPerformed
        new ControladorCadastroPaciente();
    }//GEN-LAST:event_cadastrar_pacienteMenuItemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        BD.fechaConexão();
        System.exit(1);
    }//GEN-LAST:event_formWindowClosed

    private void cadastrar_médicoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_médicoMenuItemActionPerformed
        new ControladorCadastroFuncionário();
    }//GEN-LAST:event_cadastrar_médicoMenuItemActionPerformed

    private void turnosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnosMenuItemActionPerformed
        new ControladorCadastroTurnos();
    }//GEN-LAST:event_turnosMenuItemActionPerformed

    private void diagnósticosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnósticosMenuItemActionPerformed
        new ControladorCadastroDiagnóstico(1,null,null);
    }//GEN-LAST:event_diagnósticosMenuItemActionPerformed

    private void agendar_consultaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendar_consultaMenuItemActionPerformed
        new ControladorCadastroConsulta();
    }//GEN-LAST:event_agendar_consultaMenuItemActionPerformed

    private void pesquisarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarMenuItemActionPerformed
        new ControladorPesquisaConsulta();
    }//GEN-LAST:event_pesquisarMenuItemActionPerformed

    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaHospitalBelaVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaHospitalBelaVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaHospitalBelaVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaHospitalBelaVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaHospitalBelaVida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem agendar_consultaMenuItem;
    private javax.swing.JMenuItem cadastrar_médicoMenuItem;
    private javax.swing.JMenuItem cadastrar_pacienteMenuItem;
    private javax.swing.JMenu consultaMenu;
    private javax.swing.JMenuItem diagnósticosMenuItem;
    private javax.swing.JMenu médicoMenu;
    private javax.swing.JMenu pacienteMenu;
    private javax.swing.JMenu pesquisaMenu;
    private javax.swing.JMenuItem pesquisarMenuItem;
    private javax.swing.JMenuItem turnosMenuItem;
    // End of variables declaration//GEN-END:variables
}
