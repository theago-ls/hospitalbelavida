package interfaces;

import controle.ControladorCadastroFuncionário;
import entidades.Data;
import entidades.Endereço;
import entidades.Enfermeiro;
import entidades.Funcionário;
import entidades.Médico;
import entidades.Paciente;
import entidades.Visão;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class JanelaCadastroFuncionário extends javax.swing.JFrame{
    ControladorCadastroFuncionário controlador;
    Vector<Visão<String>> médicos, enfermeiros;
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo2 = new DefaultListModel();
    
    public JanelaCadastroFuncionário(ControladorCadastroFuncionário controlador) {
        this.médicos = Médico.getVisões();
        this.enfermeiros = Enfermeiro.getVisões();
        initLista();
        this.controlador = controlador; 
        initComponents();        
    }    
     
    private void initLista(){
        for(Visão<String> visão : médicos){
            modelo.addElement(visão);
        }
        for(Visão<String> visão: enfermeiros){
            modelo2.addElement(visão);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        funcionárioTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        enfermeirosLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enfermeirosList = new javax.swing.JList<>();
        nome_enfermeiroLabel = new javax.swing.JLabel();
        nome_enfermeiroTextField = new javax.swing.JTextField();
        telefone_enfermeiroLabel1 = new javax.swing.JLabel();
        telefone_enfermeiroFormattedTextField = new javax.swing.JFormattedTextField();
        área_enfermeiroComboBox = new javax.swing.JComboBox<>();
        área_enfermeiroLabel = new javax.swing.JLabel();
        data_nascimento_enfermeiroFormattedTextField = new javax.swing.JFormattedTextField();
        data_nascimento_enfermeiroLabel = new javax.swing.JLabel();
        cpf_enfermeiroFormattedTextField = new javax.swing.JFormattedTextField();
        cpf_enfermeiroLabel = new javax.swing.JLabel();
        data_admissão_enfermeiroLabel = new javax.swing.JLabel();
        data_admissão_enfermeiroFormattedTextField = new javax.swing.JFormattedTextField();
        número_enfermeiroTextField = new javax.swing.JTextField();
        logradouro_enfermeiroTextField = new javax.swing.JTextField();
        logradouro_enfermeiroLabel = new javax.swing.JLabel();
        complemento_enfermeiroLabel = new javax.swing.JLabel();
        complemento_enfermeiroTextField = new javax.swing.JTextField();
        cep_enfermeiroLabel = new javax.swing.JLabel();
        cep_enfermeiroFormattedTextField = new javax.swing.JFormattedTextField();
        cidade_enfermeiroLabel = new javax.swing.JLabel();
        cidade_enfermeiroTextField = new javax.swing.JTextField();
        bairro_enfermeiroLabel = new javax.swing.JLabel();
        bairro_enfermeiroTextField = new javax.swing.JTextField();
        estado_enfermeiroLabel = new javax.swing.JLabel();
        estado_enfermeiroComboBox = new javax.swing.JComboBox<>();
        número_enfermeiroLabel = new javax.swing.JLabel();
        botões_enfermeiroPanel = new javax.swing.JPanel();
        consultar_enfermeiroButton = new javax.swing.JButton();
        inserir_enfermeiroButton = new javax.swing.JButton();
        alterar_enfermeiroButton = new javax.swing.JButton();
        remover_enfermeiroButton = new javax.swing.JButton();
        limpar_enfermeiroButton = new javax.swing.JButton();
        sexo_enfermeiroLabel = new javax.swing.JLabel();
        sexo_enfermeiroComboBox = new javax.swing.JComboBox<>();
        médicosPanel = new javax.swing.JPanel();
        médicosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        médicosList = new javax.swing.JList<>();
        cpfLabel = new javax.swing.JLabel();
        crmLabel = new javax.swing.JLabel();
        crmTextField = new javax.swing.JTextField();
        nome_médicoLabel = new javax.swing.JLabel();
        nome_médicoTextField = new javax.swing.JTextField();
        data_nascimentoLabel = new javax.swing.JLabel();
        data_nascimento_médicoFormattedTextField = new javax.swing.JFormattedTextField();
        cpf_médicoFormattedTextField = new javax.swing.JFormattedTextField();
        data_admissão_médicoLabel = new javax.swing.JLabel();
        data_admissão_médicoFormattedTextField = new javax.swing.JFormattedTextField();
        logradouro_médicoLabel = new javax.swing.JLabel();
        logradouro_médicoTextField = new javax.swing.JTextField();
        número_médicoLabel = new javax.swing.JLabel();
        número_médicoTextField = new javax.swing.JTextField();
        bairro_médicoLabel = new javax.swing.JLabel();
        complemento_médicoLabel = new javax.swing.JLabel();
        complemento_médicoTextField = new javax.swing.JTextField();
        cep_médicoLabel = new javax.swing.JLabel();
        cep_médicoFormattedTextField = new javax.swing.JFormattedTextField();
        telefone_médicoLabel = new javax.swing.JLabel();
        telefone_médicoFormattedTextField = new javax.swing.JFormattedTextField();
        área_médicoLabel = new javax.swing.JLabel();
        área_médicoComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        consultar_médicoButton = new javax.swing.JButton();
        inserir_médicoButton = new javax.swing.JButton();
        alterar_médicoButton = new javax.swing.JButton();
        remover_médicoButton = new javax.swing.JButton();
        limpar_médicoButton = new javax.swing.JButton();
        bairro_médicoTextField = new javax.swing.JTextField();
        cidade_médicoLabel = new javax.swing.JLabel();
        cidade_médicoTextField = new javax.swing.JTextField();
        estado_médicoLabel = new javax.swing.JLabel();
        estado_médicoComboBox = new javax.swing.JComboBox<>();
        sexo_médicoLabel = new javax.swing.JLabel();
        sexo_médicoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        funcionárioTabbedPane.setPreferredSize(new java.awt.Dimension(700, 400));

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel2.setLayout(null);

        enfermeirosLabel.setLabelFor(enfermeirosList);
        enfermeirosLabel.setText("Enfermeiros:");
        jPanel2.add(enfermeirosLabel);
        enfermeirosLabel.setBounds(12, 45, 90, 15);

        enfermeirosList.setModel(modelo2);
        enfermeirosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(enfermeirosList);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(90, 10, 630, 97);

        nome_enfermeiroLabel.setLabelFor(nome_enfermeiroTextField);
        nome_enfermeiroLabel.setText("Nome:");
        jPanel2.add(nome_enfermeiroLabel);
        nome_enfermeiroLabel.setBounds(50, 120, 45, 15);
        jPanel2.add(nome_enfermeiroTextField);
        nome_enfermeiroTextField.setBounds(92, 116, 291, 23);

        telefone_enfermeiroLabel1.setLabelFor(telefone_enfermeiroFormattedTextField);
        telefone_enfermeiroLabel1.setText("Telefone:");
        jPanel2.add(telefone_enfermeiroLabel1);
        telefone_enfermeiroLabel1.setBounds(395, 120, 67, 15);

        try {
            telefone_enfermeiroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## - #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(telefone_enfermeiroFormattedTextField);
        telefone_enfermeiroFormattedTextField.setBounds(453, 118, 98, 19);

        área_enfermeiroComboBox.setModel(new DefaultComboBoxModel(Médico.ÁREA));
        jPanel2.add(área_enfermeiroComboBox);
        área_enfermeiroComboBox.setBounds(92, 260, 120, 25);

        área_enfermeiroLabel.setLabelFor(área_enfermeiroComboBox);
        área_enfermeiroLabel.setText("Área:");
        jPanel2.add(área_enfermeiroLabel);
        área_enfermeiroLabel.setBounds(58, 265, 38, 15);

        try {
            data_nascimento_enfermeiroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(data_nascimento_enfermeiroFormattedTextField);
        data_nascimento_enfermeiroFormattedTextField.setBounds(328, 153, 96, 19);

        data_nascimento_enfermeiroLabel.setLabelFor(data_nascimento_enfermeiroFormattedTextField);
        data_nascimento_enfermeiroLabel.setText("Data de nascimento:");
        jPanel2.add(data_nascimento_enfermeiroLabel);
        data_nascimento_enfermeiroLabel.setBounds(206, 155, 147, 15);

        try {
            cpf_enfermeiroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(cpf_enfermeiroFormattedTextField);
        cpf_enfermeiroFormattedTextField.setBounds(92, 153, 96, 19);

        cpf_enfermeiroLabel.setLabelFor(cpf_enfermeiroFormattedTextField);
        cpf_enfermeiroLabel.setText("CPF:");
        jPanel2.add(cpf_enfermeiroLabel);
        cpf_enfermeiroLabel.setBounds(61, 155, 31, 15);

        data_admissão_enfermeiroLabel.setLabelFor(data_admissão_enfermeiroFormattedTextField);
        data_admissão_enfermeiroLabel.setText("Data de admissão:");
        jPanel2.add(data_admissão_enfermeiroLabel);
        data_admissão_enfermeiroLabel.setBounds(442, 155, 133, 15);

        try {
            data_admissão_enfermeiroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data_admissão_enfermeiroFormattedTextField.setText("        /       /    ");
        jPanel2.add(data_admissão_enfermeiroFormattedTextField);
        data_admissão_enfermeiroFormattedTextField.setBounds(559, 153, 103, 19);
        jPanel2.add(número_enfermeiroTextField);
        número_enfermeiroTextField.setBounds(417, 185, 40, 23);
        jPanel2.add(logradouro_enfermeiroTextField);
        logradouro_enfermeiroTextField.setBounds(92, 185, 258, 23);

        logradouro_enfermeiroLabel.setLabelFor(logradouro_enfermeiroTextField);
        logradouro_enfermeiroLabel.setText("Logradouro:");
        jPanel2.add(logradouro_enfermeiroLabel);
        logradouro_enfermeiroLabel.setBounds(18, 190, 88, 15);

        complemento_enfermeiroLabel.setLabelFor(complemento_enfermeiroTextField);
        complemento_enfermeiroLabel.setText("Complemento:");
        jPanel2.add(complemento_enfermeiroLabel);
        complemento_enfermeiroLabel.setBounds(6, 226, 102, 15);

        complemento_enfermeiroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complemento_enfermeiroTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(complemento_enfermeiroTextField);
        complemento_enfermeiroTextField.setBounds(92, 222, 185, 23);

        cep_enfermeiroLabel.setLabelFor(cep_enfermeiroFormattedTextField);
        cep_enfermeiroLabel.setText("CEP:");
        jPanel2.add(cep_enfermeiroLabel);
        cep_enfermeiroLabel.setBounds(291, 226, 31, 15);

        try {
            cep_enfermeiroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(cep_enfermeiroFormattedTextField);
        cep_enfermeiroFormattedTextField.setBounds(323, 224, 75, 19);

        cidade_enfermeiroLabel.setLabelFor(cidade_enfermeiroTextField);
        cidade_enfermeiroLabel.setText("Cidade:");
        jPanel2.add(cidade_enfermeiroLabel);
        cidade_enfermeiroLabel.setBounds(410, 226, 54, 15);
        jPanel2.add(cidade_enfermeiroTextField);
        cidade_enfermeiroTextField.setBounds(458, 222, 136, 23);

        bairro_enfermeiroLabel.setLabelFor(bairro_enfermeiroTextField);
        bairro_enfermeiroLabel.setText("Bairro:");
        jPanel2.add(bairro_enfermeiroLabel);
        bairro_enfermeiroLabel.setBounds(462, 190, 48, 15);
        jPanel2.add(bairro_enfermeiroTextField);
        bairro_enfermeiroTextField.setBounds(506, 185, 217, 23);

        estado_enfermeiroLabel.setLabelFor(estado_enfermeiroComboBox);
        estado_enfermeiroLabel.setText("UF:");
        jPanel2.add(estado_enfermeiroLabel);
        estado_enfermeiroLabel.setBounds(606, 226, 23, 15);

        estado_enfermeiroComboBox.setModel(new DefaultComboBoxModel(Endereço.ESTADOS));
        jPanel2.add(estado_enfermeiroComboBox);
        estado_enfermeiroComboBox.setBounds(629, 222, 50, 25);

        número_enfermeiroLabel.setLabelFor(número_enfermeiroTextField);
        número_enfermeiroLabel.setText("Número:");
        jPanel2.add(número_enfermeiroLabel);
        número_enfermeiroLabel.setBounds(363, 190, 60, 15);

        botões_enfermeiroPanel.setVerifyInputWhenFocusTarget(false);

        consultar_enfermeiroButton.setText("Consultar");
        consultar_enfermeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_enfermeiroButtonActionPerformed(evt);
            }
        });
        botões_enfermeiroPanel.add(consultar_enfermeiroButton);

        inserir_enfermeiroButton.setText("Inserir");
        inserir_enfermeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserir_enfermeiroButtonActionPerformed(evt);
            }
        });
        botões_enfermeiroPanel.add(inserir_enfermeiroButton);

        alterar_enfermeiroButton.setText("Alterar");
        alterar_enfermeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar_enfermeiroButtonActionPerformed(evt);
            }
        });
        botões_enfermeiroPanel.add(alterar_enfermeiroButton);

        remover_enfermeiroButton.setText("Remover");
        remover_enfermeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover_enfermeiroButtonActionPerformed(evt);
            }
        });
        botões_enfermeiroPanel.add(remover_enfermeiroButton);

        limpar_enfermeiroButton.setText("Limpar campos");
        limpar_enfermeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_enfermeiroButtonActionPerformed(evt);
            }
        });
        botões_enfermeiroPanel.add(limpar_enfermeiroButton);

        jPanel2.add(botões_enfermeiroPanel);
        botões_enfermeiroPanel.setBounds(82, 298, 614, 41);

        sexo_enfermeiroLabel.setLabelFor(sexo_enfermeiroComboBox);
        sexo_enfermeiroLabel.setText("Sexo:");
        jPanel2.add(sexo_enfermeiroLabel);
        sexo_enfermeiroLabel.setBounds(570, 120, 39, 15);

        sexo_enfermeiroComboBox.setModel(new DefaultComboBoxModel(Paciente.SEXOS));
        jPanel2.add(sexo_enfermeiroComboBox);
        sexo_enfermeiroComboBox.setBounds(610, 118, 110, 25);

        funcionárioTabbedPane.addTab("Enfermeiros", jPanel2);

        médicosPanel.setPreferredSize(new java.awt.Dimension(700, 400));
        médicosPanel.setLayout(null);

        médicosLabel.setLabelFor(médicosList);
        médicosLabel.setText("Médicos:");
        médicosPanel.add(médicosLabel);
        médicosLabel.setBounds(30, 40, 63, 15);

        médicosList.setModel(modelo);
        médicosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(médicosList);

        médicosPanel.add(jScrollPane1);
        jScrollPane1.setBounds(90, 10, 630, 96);

        cpfLabel.setLabelFor(cpf_médicoFormattedTextField);
        cpfLabel.setText("CPF:");
        médicosPanel.add(cpfLabel);
        cpfLabel.setBounds(398, 120, 31, 15);

        crmLabel.setLabelFor(crmTextField);
        crmLabel.setText("CRM:");
        médicosPanel.add(crmLabel);
        crmLabel.setBounds(61, 155, 35, 15);
        médicosPanel.add(crmTextField);
        crmTextField.setBounds(92, 153, 96, 23);

        nome_médicoLabel.setLabelFor(nome_médicoTextField);
        nome_médicoLabel.setText("Nome:");
        médicosPanel.add(nome_médicoLabel);
        nome_médicoLabel.setBounds(50, 120, 45, 15);
        médicosPanel.add(nome_médicoTextField);
        nome_médicoTextField.setBounds(92, 116, 292, 23);

        data_nascimentoLabel.setLabelFor(data_nascimento_médicoFormattedTextField);
        data_nascimentoLabel.setText("Data de nascimento:");
        médicosPanel.add(data_nascimentoLabel);
        data_nascimentoLabel.setBounds(206, 155, 147, 15);

        try {
            data_nascimento_médicoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        médicosPanel.add(data_nascimento_médicoFormattedTextField);
        data_nascimento_médicoFormattedTextField.setBounds(328, 153, 96, 19);

        try {
            cpf_médicoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        médicosPanel.add(cpf_médicoFormattedTextField);
        cpf_médicoFormattedTextField.setBounds(429, 118, 96, 19);

        data_admissão_médicoLabel.setLabelFor(data_admissão_médicoFormattedTextField);
        data_admissão_médicoLabel.setText("Data de admissão:");
        médicosPanel.add(data_admissão_médicoLabel);
        data_admissão_médicoLabel.setBounds(442, 155, 133, 15);

        try {
            data_admissão_médicoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data_admissão_médicoFormattedTextField.setText("        /       /    ");
        médicosPanel.add(data_admissão_médicoFormattedTextField);
        data_admissão_médicoFormattedTextField.setBounds(559, 153, 103, 19);

        logradouro_médicoLabel.setLabelFor(logradouro_médicoTextField);
        logradouro_médicoLabel.setText("Logradouro:");
        médicosPanel.add(logradouro_médicoLabel);
        logradouro_médicoLabel.setBounds(18, 190, 88, 15);
        médicosPanel.add(logradouro_médicoTextField);
        logradouro_médicoTextField.setBounds(92, 185, 258, 23);

        número_médicoLabel.setLabelFor(número_médicoTextField);
        número_médicoLabel.setText("Número:");
        médicosPanel.add(número_médicoLabel);
        número_médicoLabel.setBounds(363, 190, 60, 15);
        médicosPanel.add(número_médicoTextField);
        número_médicoTextField.setBounds(417, 185, 40, 23);

        bairro_médicoLabel.setLabelFor(bairro_médicoTextField);
        bairro_médicoLabel.setText("Bairro:");
        médicosPanel.add(bairro_médicoLabel);
        bairro_médicoLabel.setBounds(462, 190, 48, 15);

        complemento_médicoLabel.setLabelFor(complemento_médicoTextField);
        complemento_médicoLabel.setText("Complemento:");
        médicosPanel.add(complemento_médicoLabel);
        complemento_médicoLabel.setBounds(6, 226, 102, 15);
        médicosPanel.add(complemento_médicoTextField);
        complemento_médicoTextField.setBounds(92, 222, 185, 23);

        cep_médicoLabel.setLabelFor(cep_médicoFormattedTextField);
        cep_médicoLabel.setText("CEP:");
        médicosPanel.add(cep_médicoLabel);
        cep_médicoLabel.setBounds(291, 226, 31, 15);

        try {
            cep_médicoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        médicosPanel.add(cep_médicoFormattedTextField);
        cep_médicoFormattedTextField.setBounds(323, 224, 75, 19);

        telefone_médicoLabel.setLabelFor(telefone_médicoFormattedTextField);
        telefone_médicoLabel.setText("Telefone:");
        médicosPanel.add(telefone_médicoLabel);
        telefone_médicoLabel.setBounds(230, 265, 67, 15);

        try {
            telefone_médicoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## - #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        médicosPanel.add(telefone_médicoFormattedTextField);
        telefone_médicoFormattedTextField.setBounds(290, 263, 96, 19);

        área_médicoLabel.setLabelFor(área_médicoComboBox);
        área_médicoLabel.setText("Área:");
        médicosPanel.add(área_médicoLabel);
        área_médicoLabel.setBounds(58, 265, 38, 15);

        área_médicoComboBox.setModel(new DefaultComboBoxModel(Médico.ÁREA));
        médicosPanel.add(área_médicoComboBox);
        área_médicoComboBox.setBounds(92, 260, 120, 25);

        consultar_médicoButton.setText("Consultar");
        consultar_médicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_médicoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(consultar_médicoButton);

        inserir_médicoButton.setText("Inserir");
        inserir_médicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserir_médicoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(inserir_médicoButton);

        alterar_médicoButton.setText("Alterar");
        alterar_médicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar_médicoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(alterar_médicoButton);

        remover_médicoButton.setText("Remover");
        remover_médicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover_médicoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(remover_médicoButton);

        limpar_médicoButton.setText("Limpar campos");
        limpar_médicoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_médicoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limpar_médicoButton);

        médicosPanel.add(jPanel1);
        jPanel1.setBounds(82, 298, 614, 41);
        médicosPanel.add(bairro_médicoTextField);
        bairro_médicoTextField.setBounds(506, 185, 217, 23);

        cidade_médicoLabel.setLabelFor(cidade_médicoTextField);
        cidade_médicoLabel.setText("Cidade:");
        médicosPanel.add(cidade_médicoLabel);
        cidade_médicoLabel.setBounds(410, 226, 54, 15);
        médicosPanel.add(cidade_médicoTextField);
        cidade_médicoTextField.setBounds(458, 222, 136, 23);

        estado_médicoLabel.setLabelFor(estado_médicoComboBox);
        estado_médicoLabel.setText("UF:");
        médicosPanel.add(estado_médicoLabel);
        estado_médicoLabel.setBounds(606, 226, 23, 15);

        estado_médicoComboBox.setModel(new DefaultComboBoxModel(Endereço.ESTADOS));
        médicosPanel.add(estado_médicoComboBox);
        estado_médicoComboBox.setBounds(629, 222, 50, 25);

        sexo_médicoLabel.setLabelFor(sexo_médicoComboBox);
        sexo_médicoLabel.setText("Sexo:");
        médicosPanel.add(sexo_médicoLabel);
        sexo_médicoLabel.setBounds(540, 120, 41, 15);

        sexo_médicoComboBox.setModel(new DefaultComboBoxModel(Paciente.SEXOS));
        médicosPanel.add(sexo_médicoComboBox);
        sexo_médicoComboBox.setBounds(590, 118, 130, 25);

        funcionárioTabbedPane.addTab("Médicos", médicosPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(funcionárioTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(funcionárioTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar_médicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_médicoButtonActionPerformed
        limparFuncionário(1);
    }//GEN-LAST:event_limpar_médicoButtonActionPerformed

    private void remover_médicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_médicoButtonActionPerformed
        removerFuncionário(1);
    }//GEN-LAST:event_remover_médicoButtonActionPerformed

    private void alterar_médicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar_médicoButtonActionPerformed
        alterarFuncionário(1);
    }//GEN-LAST:event_alterar_médicoButtonActionPerformed

    private void inserir_médicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserir_médicoButtonActionPerformed
        inserirFuncionário(1);
    }//GEN-LAST:event_inserir_médicoButtonActionPerformed

    private void consultar_médicoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_médicoButtonActionPerformed
        consultarFuncionário(1);
    }//GEN-LAST:event_consultar_médicoButtonActionPerformed

    private void complemento_enfermeiroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complemento_enfermeiroTextFieldActionPerformed
        
    }//GEN-LAST:event_complemento_enfermeiroTextFieldActionPerformed

    private void consultar_enfermeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_enfermeiroButtonActionPerformed
        consultarFuncionário(2);
    }//GEN-LAST:event_consultar_enfermeiroButtonActionPerformed

    private void inserir_enfermeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserir_enfermeiroButtonActionPerformed
        inserirFuncionário(2);
    }//GEN-LAST:event_inserir_enfermeiroButtonActionPerformed

    private void alterar_enfermeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar_enfermeiroButtonActionPerformed
        alterarFuncionário(2);
    }//GEN-LAST:event_alterar_enfermeiroButtonActionPerformed

    private void remover_enfermeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_enfermeiroButtonActionPerformed
        removerFuncionário(2);
    }//GEN-LAST:event_remover_enfermeiroButtonActionPerformed

    private void limpar_enfermeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_enfermeiroButtonActionPerformed
        limparFuncionário(2);
    }//GEN-LAST:event_limpar_enfermeiroButtonActionPerformed
    
    private Funcionário obterInformações(int tela) {
        if(tela == 1){
            String CPF = cpf_médicoFormattedTextField.getText().replaceAll("[.-]+","");                  
            if(CPF.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum CPF informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String CRM = crmTextField.getText();
            if(CRM.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum CRM informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String Nome = nome_médicoTextField.getText();
            if(Nome.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum nome informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String data, data_admissão;
            data = data_nascimento_médicoFormattedTextField.getText();
            if(data.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum data de nascimento informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            data_admissão = data_admissão_médicoFormattedTextField.getText();
            if(data_admissão.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum data de admissão informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            } 
            boolean data_valida = Data.validarData(data);
            Data data_nasc, data_admi;
            if(data_valida)
                data_nasc = new Data(data.substring(0,2),data.substring(3,5),data.substring(6));
            else{
                JOptionPane.showMessageDialog(this,"Data de nascimento inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            data_valida = Data.validarData(data_admissão);
            if(data_valida)
                data_admi = new Data(data_admissão.substring(0,2),data_admissão.substring(3,5),data_admissão.substring(6));
            else{
                JOptionPane.showMessageDialog(this,"Data de admissão inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }                  
            String logradouro = logradouro_médicoTextField.getText();     
            if(logradouro.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum logradouro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String número = número_médicoTextField.getText();
            if(número.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum número de residência informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String bairro = bairro_médicoTextField.getText();
            if(bairro.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum bairro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String complemento = complemento_médicoTextField.getText();
            String cep = cep_médicoFormattedTextField.getText().replaceAll("-","");
            if(cep.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum CEP informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String cidade = cidade_médicoTextField.getText();
            if(cidade.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum cidade informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            int estado = estado_médicoComboBox.getSelectedIndex();
            if(estado < 0){
                JOptionPane.showMessageDialog(this,"Nenhum estado selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            Endereço endereço = new Endereço(logradouro,número,bairro,complemento,cep,cidade,Endereço.ESTADOS[estado]);
            String telefone = telefone_médicoFormattedTextField.getText().replaceAll("[- ]","");            
            if(telefone.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum número de telefone informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }  
            int especialidade = área_médicoComboBox.getSelectedIndex();
            if(especialidade < 0){
                JOptionPane.showMessageDialog(this,"Nenhuma área selecionada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            int sexo = sexo_médicoComboBox.getSelectedIndex();
            if(sexo == -1){
                JOptionPane.showMessageDialog(this,"Nenhum sexo selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return new Médico(CRM,CPF,Nome,Paciente.SEXOS[sexo],data_nasc,data_admi,endereço,telefone,Médico.ÁREA[especialidade]);
        }
        else{
            String CPF = cpf_enfermeiroFormattedTextField.getText().replaceAll("[.-]","");                  
            if(CPF.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum CPF informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }            
            String Nome = nome_enfermeiroTextField.getText();
            if(Nome.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum nome informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String data, data_admissão;            
            data = data_nascimento_enfermeiroFormattedTextField.getText();
            if(data.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum data de nascimento informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            data_admissão = data_admissão_enfermeiroFormattedTextField.getText();            
            if(data_admissão.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum data de admissão informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            } 
            boolean data_valida = Data.validarData(data);            
            Data data_nasc, data_admi;
            if(data_valida)
                data_nasc = new Data(data.substring(0,2),data.substring(3,5),data.substring(6));
            else{
                JOptionPane.showMessageDialog(this,"Data de nascimento inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }            
            data_valida = Data.validarData(data_admissão);
            if(data_valida)
                data_admi = new Data(data_admissão.substring(0,2),data_admissão.substring(3,5),data_admissão.substring(6));
            else{
                JOptionPane.showMessageDialog(this,"Data de admissão inválida!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }                  
            String logradouro = logradouro_enfermeiroTextField.getText();     
            if(logradouro.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum logradouro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String número = número_enfermeiroTextField.getText();
            if(número.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum número de residência informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String bairro = bairro_enfermeiroTextField.getText();
            if(bairro.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum bairro informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String complemento = complemento_enfermeiroTextField.getText();
            String cep = cep_enfermeiroFormattedTextField.getText().replaceAll("[-]","");
            if(cep.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum CEP informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String cidade = cidade_enfermeiroTextField.getText();
            if(cidade.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhuma cidade informada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            int estado = estado_enfermeiroComboBox.getSelectedIndex();
            if(estado < 0){
                JOptionPane.showMessageDialog(this,"Nenhum estado selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            Endereço endereço = new Endereço(logradouro,número,bairro,complemento,cep,cidade,Endereço.ESTADOS[estado]);
            String telefone = telefone_enfermeiroFormattedTextField.getText().replaceAll("[- ]","");        
            if(telefone.isEmpty()){
                JOptionPane.showMessageDialog(this,"Nenhum número de telefone informado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }  
            int especialidade = área_enfermeiroComboBox.getSelectedIndex();
            if(especialidade < 0){
                JOptionPane.showMessageDialog(this,"Nenhuma área selecionada!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            int sexo = sexo_enfermeiroComboBox.getSelectedIndex();
            if(sexo == -1){
                JOptionPane.showMessageDialog(this,"Nenhum sexo selecionado!","ERRO!",JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return new Enfermeiro(CPF,Nome,Paciente.SEXOS[sexo],telefone,data_nasc,data_admi,endereço,Médico.ÁREA[especialidade]);
        }
    }
    
    private Visão<String> obterFuncionário(int tela){
        if(tela == 1){
            int n = médicosList.getSelectedIndex();
            if(n != -1)
                return (Visão<String>) modelo.get(n);
            else
                return null;
        }else{
            int n = enfermeirosList.getSelectedIndex();
            if(n != -1)
                return (Visão<String>) modelo2.get(n);
            else
                return null;
        }
    }
    
    private Visão<String> obterFuncionário(String cpf, int tela){
        if(tela == 1){
            for(Visão<String> visão : médicos){
                if(visão.getChave().equals(cpf))
                    return visão;
            }
            return null;
        }else{
            for(Visão<String> visão : enfermeiros){
                if(visão.getChave().equals(cpf))
                    return visão;
            }
            return null;
        }
    }
    
    private void inserirFuncionário(int tela){
        if(tela == 1){
            Médico médico = (Médico) obterInformações(1);
            String mensagem_erro = null;
            if(médico != null){           
                mensagem_erro = controlador.inserirMédico(médico);
                if(mensagem_erro == null){
                    modelo.addElement(médico.getVisão());
                    limparFuncionário(1);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }       
            } 
        }else{
            Enfermeiro enfermeiro = (Enfermeiro) obterInformações(2);
            String mensagem_erro = null;
            if(enfermeiro != null){           
                mensagem_erro = controlador.inserirEnfermeiro(enfermeiro);
                if(mensagem_erro == null){
                    modelo2.addElement(enfermeiro.getVisão());
                    limparFuncionário(2);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }        
            }
        }
    }
    
    private void removerFuncionário(int tela){
        if(tela == 1){
            Visão<String> médico = obterFuncionário(1);
            String mensagem_erro = null;
            if(médico != null){           
                mensagem_erro = controlador.removerMédico(médico.getChave());
                if(mensagem_erro == null){                
                    modelo.removeElement(médico);
                    limparFuncionário(2);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }           
            }else{            
                JOptionPane.showMessageDialog(this,"Nenhum médico selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);            
            }
        }else{
            Visão<String> enfermeiro = obterFuncionário(2);
            String mensagem_erro = null;
            if(enfermeiro != null){           
                mensagem_erro = controlador.removerEnfermeiro(enfermeiro.getChave());
                if(mensagem_erro == null){                
                    modelo2.removeElement(enfermeiro);
                    limparFuncionário(2);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }           
            }else{            
                JOptionPane.showMessageDialog(this,"Nenhum enfermeiro selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);            
            }  
        }
    }
   
    private void alterarFuncionário(int tela){
        if(tela == 1){                 
            String mensagem_erro = null;
            Médico médico = (Médico) obterInformações(1);
            if(médico != null){
                mensagem_erro = controlador.alterarMédico(médico);
                Visão<String> visão = obterFuncionário(médico.getCPF(),1);
                if(mensagem_erro == null){
                    visão.setInfo(médico.getVisão().getInfo());
                    limparFuncionário(2);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }             
            }
        }else{            
            String mensagem_erro = null;
            Enfermeiro enfermeiro = (Enfermeiro) obterInformações(2);
            if(enfermeiro != null){
                mensagem_erro = controlador.alterarEnfermeiro(enfermeiro);
                Visão<String> visão = obterFuncionário(enfermeiro.getCPF(),2);
                if(mensagem_erro == null){
                    visão.setInfo(enfermeiro.getVisão().getInfo());
                    limparFuncionário(2);
                }else{
                    JOptionPane.showMessageDialog(this,mensagem_erro,"ERRO!",JOptionPane.ERROR_MESSAGE);
                }
            }            
        }
    }
    
    private void consultarFuncionário(int tela){
        if(tela == 1){
            int n = médicosList.getSelectedIndex();
            if(n != -1){
               Visão<String> visão = (Visão) modelo.getElementAt(n);
               preencherFuncionário(visão.getChave(),1); 
            }else
                JOptionPane.showMessageDialog(this,"Nenhum médico selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);
        }else{
            int n = enfermeirosList.getSelectedIndex();
            if(n != -1){
               Visão<String> visão = (Visão) modelo2.getElementAt(n);        
                preencherFuncionário(visão.getChave(),2); 
            }else
                JOptionPane.showMessageDialog(this,"Nenhum enfermeiro selecionado.","ERRO!",JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    private void preencherFuncionário(String chave, int tela){
        if(tela == 1){
            Médico médico = Médico.buscarMédico(chave);
            String dia, mês, ano;
            ano = médico.getDataNascimento().substring(0,4);
            mês = médico.getDataNascimento().substring(5,7);
            dia = médico.getDataNascimento().substring(8);

            nome_médicoTextField.setText(médico.getNome());
            cpf_médicoFormattedTextField.setText(médico.getCPF());
            crmTextField.setText(médico.getCRM());
            data_nascimento_médicoFormattedTextField.setText(dia+mês+ano);
            ano = médico.getDataAdmissão().substring(0,4);
            mês = médico.getDataAdmissão().substring(5,7);
            dia = médico.getDataAdmissão().substring(8);
            data_admissão_médicoFormattedTextField.setText(dia+mês+ano);
            logradouro_médicoTextField.setText(médico.getEndereço().getLogradouro());
            número_médicoTextField.setText(médico.getEndereço().getNúmero());
            bairro_médicoTextField.setText(médico.getEndereço().getBairro());
            complemento_médicoTextField.setText(médico.getEndereço().getComplemento());
            cep_médicoFormattedTextField.setText(médico.getEndereço().getCEP());
            cidade_médicoTextField.setText(médico.getEndereço().getCidade());
            estado_médicoComboBox.setSelectedIndex(médico.getEndereço().getEstado().ordinal());       
            área_médicoComboBox.setSelectedItem(médico.getÁrea());
            telefone_médicoFormattedTextField.setText(médico.getTelefone());
        }else{
            Enfermeiro enfermeiro = Enfermeiro.buscarEnfermeiro(chave);
            String dia, mês, ano;
            ano = enfermeiro.getDataNascimento().substring(0,4);
            mês = enfermeiro.getDataNascimento().substring(5,7);
            dia = enfermeiro.getDataNascimento().substring(8);

            nome_enfermeiroTextField.setText(enfermeiro.getNome());
            cpf_enfermeiroFormattedTextField.setText(enfermeiro.getCPF());            
            data_nascimento_enfermeiroFormattedTextField.setText(dia+mês+ano);
            ano = enfermeiro.getDataAdmissão().substring(0,4);
            mês = enfermeiro.getDataAdmissão().substring(5,7);
            dia = enfermeiro.getDataAdmissão().substring(8);
            data_admissão_enfermeiroFormattedTextField.setText(dia+mês+ano);
            logradouro_enfermeiroTextField.setText(enfermeiro.getEndereço().getLogradouro());
            número_enfermeiroTextField.setText(enfermeiro.getEndereço().getNúmero());
            bairro_enfermeiroTextField.setText(enfermeiro.getEndereço().getBairro());
            complemento_enfermeiroTextField.setText(enfermeiro.getEndereço().getComplemento());
            cep_enfermeiroFormattedTextField.setText(enfermeiro.getEndereço().getCEP());
            cidade_enfermeiroTextField.setText(enfermeiro.getEndereço().getCidade());
            estado_enfermeiroComboBox.setSelectedIndex(enfermeiro.getEndereço().getEstado().ordinal());       
            área_enfermeiroComboBox.setSelectedItem(enfermeiro.getÁrea());
            telefone_enfermeiroFormattedTextField.setText(enfermeiro.getTelefone());
        }
    } 
    
    private void limparFuncionário(int tela){
        if(tela == 1){
            médicosList.clearSelection();
            nome_médicoTextField.setText("");
            cpf_médicoFormattedTextField.setText("");
            crmTextField.setText("");
            data_nascimento_médicoFormattedTextField.setText("");
            data_admissão_médicoFormattedTextField.setText("");
            logradouro_médicoTextField.setText("");
            número_médicoTextField.setText("");
            bairro_médicoTextField.setText("");
            complemento_médicoTextField.setText("");
            cep_médicoFormattedTextField.setText("");
            cidade_médicoTextField.setText("");
            estado_médicoComboBox.setSelectedIndex(-1);        
            telefone_médicoFormattedTextField.setText("");
            área_médicoComboBox.setSelectedIndex(-1);
        }else{
            enfermeirosList.clearSelection();
            nome_enfermeiroTextField.setText("");
            cpf_enfermeiroFormattedTextField.setText("");            
            data_nascimento_enfermeiroFormattedTextField.setText("");
            data_admissão_enfermeiroFormattedTextField.setText("");
            logradouro_enfermeiroTextField.setText("");
            número_enfermeiroTextField.setText("");
            bairro_enfermeiroTextField.setText("");
            complemento_enfermeiroTextField.setText("");
            cep_enfermeiroFormattedTextField.setText("");
            cidade_enfermeiroTextField.setText("");
            estado_enfermeiroComboBox.setSelectedIndex(-1);        
            telefone_enfermeiroFormattedTextField.setText("");
            área_enfermeiroComboBox.setSelectedIndex(-1);
        }
    }    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar_enfermeiroButton;
    private javax.swing.JButton alterar_médicoButton;
    private javax.swing.JLabel bairro_enfermeiroLabel;
    private javax.swing.JTextField bairro_enfermeiroTextField;
    private javax.swing.JLabel bairro_médicoLabel;
    private javax.swing.JTextField bairro_médicoTextField;
    private javax.swing.JPanel botões_enfermeiroPanel;
    private javax.swing.JFormattedTextField cep_enfermeiroFormattedTextField;
    private javax.swing.JLabel cep_enfermeiroLabel;
    private javax.swing.JFormattedTextField cep_médicoFormattedTextField;
    private javax.swing.JLabel cep_médicoLabel;
    private javax.swing.JLabel cidade_enfermeiroLabel;
    private javax.swing.JTextField cidade_enfermeiroTextField;
    private javax.swing.JLabel cidade_médicoLabel;
    private javax.swing.JTextField cidade_médicoTextField;
    private javax.swing.JLabel complemento_enfermeiroLabel;
    private javax.swing.JTextField complemento_enfermeiroTextField;
    private javax.swing.JLabel complemento_médicoLabel;
    private javax.swing.JTextField complemento_médicoTextField;
    private javax.swing.JButton consultar_enfermeiroButton;
    private javax.swing.JButton consultar_médicoButton;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JFormattedTextField cpf_enfermeiroFormattedTextField;
    private javax.swing.JLabel cpf_enfermeiroLabel;
    private javax.swing.JFormattedTextField cpf_médicoFormattedTextField;
    private javax.swing.JLabel crmLabel;
    private javax.swing.JTextField crmTextField;
    private javax.swing.JFormattedTextField data_admissão_enfermeiroFormattedTextField;
    private javax.swing.JLabel data_admissão_enfermeiroLabel;
    private javax.swing.JFormattedTextField data_admissão_médicoFormattedTextField;
    private javax.swing.JLabel data_admissão_médicoLabel;
    private javax.swing.JLabel data_nascimentoLabel;
    private javax.swing.JFormattedTextField data_nascimento_enfermeiroFormattedTextField;
    private javax.swing.JLabel data_nascimento_enfermeiroLabel;
    private javax.swing.JFormattedTextField data_nascimento_médicoFormattedTextField;
    private javax.swing.JLabel enfermeirosLabel;
    private javax.swing.JList<String> enfermeirosList;
    private javax.swing.JComboBox<String> estado_enfermeiroComboBox;
    private javax.swing.JLabel estado_enfermeiroLabel;
    private javax.swing.JComboBox<String> estado_médicoComboBox;
    private javax.swing.JLabel estado_médicoLabel;
    private javax.swing.JTabbedPane funcionárioTabbedPane;
    private javax.swing.JButton inserir_enfermeiroButton;
    private javax.swing.JButton inserir_médicoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar_enfermeiroButton;
    private javax.swing.JButton limpar_médicoButton;
    private javax.swing.JLabel logradouro_enfermeiroLabel;
    private javax.swing.JTextField logradouro_enfermeiroTextField;
    private javax.swing.JLabel logradouro_médicoLabel;
    private javax.swing.JTextField logradouro_médicoTextField;
    private javax.swing.JLabel médicosLabel;
    private javax.swing.JList<String> médicosList;
    private javax.swing.JPanel médicosPanel;
    private javax.swing.JLabel nome_enfermeiroLabel;
    private javax.swing.JTextField nome_enfermeiroTextField;
    private javax.swing.JLabel nome_médicoLabel;
    private javax.swing.JTextField nome_médicoTextField;
    private javax.swing.JLabel número_enfermeiroLabel;
    private javax.swing.JTextField número_enfermeiroTextField;
    private javax.swing.JLabel número_médicoLabel;
    private javax.swing.JTextField número_médicoTextField;
    private javax.swing.JButton remover_enfermeiroButton;
    private javax.swing.JButton remover_médicoButton;
    private javax.swing.JComboBox<String> sexo_enfermeiroComboBox;
    private javax.swing.JLabel sexo_enfermeiroLabel;
    private javax.swing.JComboBox<String> sexo_médicoComboBox;
    private javax.swing.JLabel sexo_médicoLabel;
    private javax.swing.JFormattedTextField telefone_enfermeiroFormattedTextField;
    private javax.swing.JLabel telefone_enfermeiroLabel1;
    private javax.swing.JFormattedTextField telefone_médicoFormattedTextField;
    private javax.swing.JLabel telefone_médicoLabel;
    private javax.swing.JComboBox<String> área_enfermeiroComboBox;
    private javax.swing.JLabel área_enfermeiroLabel;
    private javax.swing.JComboBox<String> área_médicoComboBox;
    private javax.swing.JLabel área_médicoLabel;
    // End of variables declaration//GEN-END:variables
}
