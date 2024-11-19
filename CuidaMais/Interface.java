import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    
    private Database db;
    private JTextField cpfField, nomeField, idadeField, telefoneField, valorField, descricaoField, cuidadorField, idField;
    private JTextArea display;
    private Cuidador cuidador;
    private Familiar familiar;
    private Anuncio anuncio;
    private String cpf;
    private int id;;
  

    public Interface (Database db){
        this.db = db;
        initUI();
    }

    private void initUI(){

        setTitle("CUIDA+: MENU");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel();
        ImageIcon iconLogo = new ImageIcon("logocuidaplus.png");
        titleLabel.setIcon(iconLogo);


        JLabel titleLabel1 = new JLabel("COMO DESEJA ACESSAR O SISTEMA?");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel1.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);

        c.gridy = 1;
        panel.add(titleLabel1, c);

        JButton btnLogin = new JButton("LOGIN");
        JButton btnCadastro = new JButton("CADASTRO");
        
        c.gridy = 2;
        panel.add(btnLogin, c);
        c.gridy = 3;
        panel.add(btnCadastro, c);


        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                JanelaCadastro();

            }   
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JanelaLogin();
            }
        });

        add(panel);
        setVisible(true);
        
    }

    private void JanelaCadastro(){

        JFrame janelacadastro = new JFrame("CUIDA+: CADASTRO");
        janelacadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacadastro.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));

        JLabel titleLabel1 = new JLabel("ESCOLHA O TIPO DE ACESSO");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel1.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);

        c.gridy = 1;
        panel.add(titleLabel1, c);

        JButton btnCuidador = new JButton("CUIDADOR");
        JButton btnFamiliar = new JButton("FAMILIAR");
        JButton btnMenu = new JButton("VOLTAR AO MENU");

        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(btnCuidador, c);
        c.gridx = 1;
        panel.add(btnFamiliar, c);
        c.gridy = 3;
        panel.add(btnMenu,c);

        btnCuidador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelacadastro.dispose();
                JanelaCuidadorCadastro();
            }
        });

        btnFamiliar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelacadastro.dispose();
                JanelaFamiliaCadastro();
            }
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                janelacadastro.dispose();
                initUI();
            }
        });


        janelacadastro.add(panel);
        janelacadastro.setVisible(true);
    }
    
    private void JanelaCuidadorCadastro (){

        JFrame janelacuidadorcadastro = new JFrame("CUIDA+: CADASTRO CUIDADOR");
        janelacuidadorcadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidadorcadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidadorcadastro.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);


        c.gridx = 0;
        c.gridy = 3;


        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(15);
        JLabel nomeLabel = new JLabel("NOME:");
        nomeField = new JTextField(15);
        JLabel idadeLabel = new JLabel("IDADE:");
        idadeField = new JTextField(15);
        JLabel telefoneLabel = new JLabel("TELEFONE:");
        telefoneField = new JTextField(15);
        JButton btnSalvar = new JButton("SALVAR");
        JButton btnMenu =  new JButton("VOLTAR AO MENU");

        c.gridy++;
        panel.add(cpfLabel, c);
        c.gridx = 2;
        panel.add(cpfField, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(nomeLabel, c);
        c.gridx = 2;
        panel.add(nomeField, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(idadeLabel, c);
        c.gridx = 2;
        panel.add(idadeField, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(telefoneLabel, c);
        c.gridx = 2;
        panel.add(telefoneField, c);

        c.gridx = 2;
        c.gridy=8;
        c.gridwidth = 2;
        panel.add(btnSalvar, c);

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        c.gridx = 2;
        c.gridy = 9;
        c.gridwidth = 2;
        panel.add(scroll, c);

        c.gridy = 10;
        panel.add(btnMenu,c);

        

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if (cpfField.getText().isEmpty() || nomeField.getText().isEmpty() || 
                idadeField.getText().isEmpty() || telefoneField.getText().isEmpty()) {
                
                display.setText("TODOS OS CAMPOS SÃO OBRIGATÓRIOS, PREENCHA-OS");
                
            } 

            String cpf = cpfField.getText();

            if (db.getCuidador(cpf) != null || db.getFamiliar(cpf) != null) {
                display.setText("CPF JÁ REGISTRADO. NÃO É POSSÍVEL REALIZAR O CADASTRO.");

            }
            
            else {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String telefone = telefoneField.getText();

                db.addCuidador(cpf, nome, idade, telefone);
                cuidador = db.getCuidador(cpf);
                display.setText("CUIDADOR " + cuidador.getNome().toUpperCase() + " CADASTRADO");

                LimparCampos();
            }


            }
            
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                initUI();
                janelacuidadorcadastro.dispose();
  
            }
        });

        janelacuidadorcadastro.add(panel);
        janelacuidadorcadastro.setVisible(true);
    }
    
    private void LimparCampos(){

        if (cpfField != null) cpfField.setText("");
        if (nomeField != null) nomeField.setText("");
        if (idadeField != null) idadeField.setText("");
        if (telefoneField != null) telefoneField.setText("");

    }

    public void limparDisplay() {
        display.setText("");
    }

    private void JanelaFamiliaCadastro(){

        JFrame janelacuidadorcadastro = new JFrame("CUIDA+: CADASTRO FAMILIAR");
        janelacuidadorcadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidadorcadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidadorcadastro.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);


        c.gridx = 0;
        c.gridy = 3;

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(15);
        JLabel nomeLabel = new JLabel("NOME:");
        nomeField = new JTextField(15);
        JLabel idadeLabel = new JLabel("IDADE:");
        idadeField = new JTextField(15);
        JButton btnSalvar = new JButton("SALVAR");
        JButton btnMenu = new JButton("VOLTAR AO MENU");

        panel.add(cpfLabel, c);
        c.gridx = 2;
        panel.add(cpfField, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(nomeLabel, c);
        c.gridx = 2;
        panel.add(nomeField, c);

        c.gridx = 0;
        c.gridy++;
        panel.add(idadeLabel, c);
        c.gridx = 2;
        panel.add(idadeField, c);

        c.gridx = 2;
        c.gridy=8;
        c.gridwidth = 2;
        panel.add(btnSalvar, c);

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        c.gridx = 2;
        c.gridy = 9;
        c.gridwidth = 2;
        panel.add(scroll, c);

        c.gridy = 10;
        panel.add(btnMenu,c);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if (cpfField.getText().isEmpty() || nomeField.getText().isEmpty() || 
                idadeField.getText().isEmpty()) {
                
                    display.setText("TODOS OS CAMPOS SÃO OBRIGATÓRIOS, PREENCHA-OS");
                
                } 

                String cpf = cpfField.getText();

                if (db.getCuidador(cpf) != null || db.getFamiliar(cpf) != null) {
                    display.setText("CPF JÁ REGISTRADO. NÃO É POSSÍVEL REALIZAR O CADASTRO.");

                }

                else{
                    String nome = nomeField.getText();
                    int idade = Integer.parseInt(idadeField.getText());
    
                    db.addFamiliar(cpf, nome, idade);
                    familiar = db.getFamiliar(cpf);
                    display.setText("FAMILIAR CADASTRADO:\n" + familiar.getNome().toUpperCase());
    
                }



            }
            
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                initUI();
                janelacuidadorcadastro.dispose();
  
            }
        });

        janelacuidadorcadastro.add(panel);
        janelacuidadorcadastro.setVisible(true);
    }


    private void JanelaLogin(){

        JFrame janelalogin = new JFrame("CUIDA+: LOGIN");
        janelalogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelalogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelalogin.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);

        c.gridx = 0;
        c.gridy = 3;

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(15);
        JButton btnEntrar = new JButton("ENTRAR");
        JButton btnMenu = new JButton("VOLTAR AO MENU");

        panel.add(cpfLabel, c);
        c.gridx = 2;
        panel.add(cpfField, c);

        c.gridx = 2;
        c.gridy=4;
        c.gridwidth = 2;
        panel.add(btnEntrar, c);

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 2;
        panel.add(scroll, c);

        c.gridy = 6;
        panel.add(btnMenu,c);


        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                cpf = cpfField.getText();

                cuidador = db.getCuidador(cpf);
                familiar = db.getFamiliar(cpf);

                if (cuidador != null) {
                    
                    janelalogin.dispose();
                    JanelaCuidador1();
                }
                
                else if (familiar != null) {
                    janelalogin.dispose();
                    JanelaFamiliar();
                }
                else {
                    display.setText("CPF NÃO ENCONTRADO. FAÇA SEU CADASTRO.");
                }
            }
        });


        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                initUI();
                janelalogin.dispose();
  
            }
        });


        janelalogin.add(panel);
        janelalogin.setVisible(true);
    }

    public void JanelaCuidador1(){

        JFrame janelacuidador1 = new JFrame("CUIDA+: CUIDADOR");
        janelacuidador1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidador1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidador1.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel();
        ImageIcon iconLogo = new ImageIcon("logocuidaplus.png");
        titleLabel.setIcon(iconLogo);

        JLabel titleLabel1 = new JLabel("ESCOLHA ESSAS OPÇOES COMO CUIDADOR");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel1.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);
    
        c.gridy = 1;
        panel.add(titleLabel1, c);

        
        JLabel cuidadorLabel = new JLabel("CUIDADOR:");
        cuidadorField  = new JTextField(15);
        cuidadorField.setEditable(false);
        cuidador = db.getCuidador(cpf);
        cuidadorField.setText(cuidador.getNome().toUpperCase());

        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy ++;
        panel.add(cuidadorLabel, c);
        c.gridx = 1;
        c.gridy ++;
        panel.add(cuidadorField, c);

        JButton btnListarA = new JButton("LISTAR SEUS ANÚNCIOS");
        JButton btnCadA = new JButton("CADASTRAR ANÚNCIO");
        JButton btnEdiDelA = new JButton("EDITAR/DELETAR ANÚNCIO");
        JButton btnListTodosA = new JButton("LISTAR TODOS ANÚNCIOS");
        JButton btnMenu = new JButton("VOLTAR AO MENU");

        c.gridy ++;
        panel.add(btnListarA, c);
        c.gridy++;
        panel.add(btnCadA, c);
        c.gridy++;
        panel.add(btnEdiDelA, c);
        c.gridy++;
        panel.add(btnEdiDelA, c);
        c.gridy++;
        panel.add(btnListTodosA, c);
        c.gridy++;
        panel.add(btnMenu, c);

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        c.gridx = 3;
        c.gridy ++;
        c.gridwidth = 2;
        panel.add(scroll, c);

        btnListarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuidador = db.getCuidador(cpf);
                db.listarAnuncios(cuidador, display);

            }
        });
    
        btnCadA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                janelacuidador1.dispose();
                JanelaCuidador2();

            }
        });
    
        btnEdiDelA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelacuidador1.dispose();
                JanelaCuidador3();
            }
        });
    
        btnListTodosA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                db.listarAnuncios(display);
            }
        });
    
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                janelacuidador1.dispose();
                initUI();
            }
        });

        janelacuidador1.add(panel);
        janelacuidador1.setVisible(true);

    }

    public void JanelaCuidador2(){

        JFrame janelacuidador2 = new JFrame("CUIDA+: CADASTRAR ANÚNCIO");
        janelacuidador2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidador2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidador2.setLocationRelativeTo(null);
    
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
    
        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));
    
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);
    
        JLabel valorLabel = new JLabel("VALOR (R$)");
        valorField = new JTextField(15);
    
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(valorLabel, c);
        c.gridx = 1;
        panel.add(valorField, c);
    
        JLabel descricaoLabel = new JLabel("DESCRIÇÃO");
        descricaoField = new JTextField(15);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(descricaoLabel, c);
        c.gridx = 1;
        panel.add(descricaoField, c);
    
        JButton btnSalvarAnuncio = new JButton("SALVAR ANÚNCIO");
        JButton btnVoltar = new JButton("VOLTAR");
    
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panel.add(btnSalvarAnuncio, c);
    
        c.gridy = 5;
        panel.add(btnVoltar, c);

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.gridx = 2;
        c.gridy = 8;
        c.gridwidth = 2;
        panel.add(scroll, c);

    
        btnSalvarAnuncio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String descricao = descricaoField.getText();
                    Double valor = Double.parseDouble(valorField.getText());

                    cuidador = db.getCuidador(cpf);
                    id = db.getId();
        
                    if (valor != null && !descricao.isEmpty()) {
                        limparDisplay();
                        db.addAnuncio(cuidador, descricao, valor);
                        anuncio = db.getAnuncio(id);
                        db.listarAnuncio(cuidador, anuncio, display);

                        

                        

                    } else {
                        limparDisplay();
                        display.setText("ERRO: TODOS OS CAMPOS SÃO OBRIGATÓRIOS.");
                    }
                } catch (NumberFormatException ex) {
                    limparDisplay();
                    display.setText("ERRO: O VALOR DEVE SER NUMÉRICO");
                }



            }
        });
        
        

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelacuidador2.dispose();
                JanelaCuidador1();
            }
        });
    
        janelacuidador2.add(panel);
        janelacuidador2.setVisible(true);
    }

    public void JanelaCuidador3(){

        JFrame janelacuidador3 = new JFrame("CUIDA+: DELETAR E EDITAR ANÚNCIO");
        janelacuidador3.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidador3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidador3.setLocationRelativeTo(null);
    
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
    
        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));
    
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        panel.add(titleLabel, c);

        JLabel titleLabel1 = new JLabel("INSIRA ID DE ANÚNCIO QUE GOSTARIA DE DELETAR OU EDITAR");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel1.setForeground(new Color(70, 130, 180));

        c.gridy = 1;
        panel.add(titleLabel1, c);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idField  = new JTextField(15);

        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy ++;
        panel.add(idLabel, c);
        c.gridx = 1;
        c.gridy ++;
        panel.add(idField, c);

        JLabel titleLabel2 = new JLabel("ESCOLHA UMA AÇÃO");
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel2.setForeground(new Color(70, 130, 180));
        c.gridx = 0;
        c.gridy ++;
        c.gridwidth = 0;
        panel.add(titleLabel2, c);

        JButton btnDel = new JButton("DELETAR");
        JButton btnEdit = new JButton("EDITAR");
        JButton btnVoltar = new JButton("VOLTAR");

        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy++;
        panel.add(btnDel, c);

        c.gridy++;

        panel.add(btnEdit, c);
        

        display = new JTextArea(10, 30);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.gridy++;
        c.gridwidth = 2;
        panel.add(scroll, c);

        c.gridwidth = 0;
        c.gridy++;
        panel.add(btnVoltar);
    

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    
                    Cuidador cuidador = db.getCuidador(cpf);
                    Anuncio anuncio = db.getAnuncio(id);
        
                    if (anuncio == null) {
                        limparDisplay();
                        display.setText("ID NÃO ENCONTRADO, TENTE NOVAMENTE");
                        return;
                    }
        
                    int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "TEM CERTEZA QUE DESEJA DELETAR ANÚNCIO COM " + id + "?",
                        "CONFIRMAR A EXCLUSÃO",
                        JOptionPane.YES_NO_OPTION
                    );
        
                    if (confirm == JOptionPane.YES_OPTION) {
                        limparDisplay();
                        db.deletarAnuncio(cuidador, anuncio, display); 
                        display.setText("ANÚNCIO DELETADO COM SUCESSO!");
                    }
        
                } catch (NumberFormatException ex) {
                    limparDisplay();
                    display.setText("POR FAVOR, INSIRA UM ID VÁLIDO.");
                } 
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
        
                    Cuidador cuidador = db.getCuidador(cpf);
                    Anuncio anuncio = db.getAnuncio(id);
        
                    if (anuncio == null) {
                        display.setText("ID NÃO ENCONTRADO, TENTE NOVAMENTE.");
                        return;
                    }
        
                    JTextField descricaoField = new JTextField(anuncio.getDescricao(), 20);
                    JTextField valorField = new JTextField(String.valueOf(anuncio.getValor()), 10);
        
                    JPanel panel = new JPanel(new GridLayout(3, 2));
                    panel.add(new JLabel("DESCRIÇÃO:"));
                    panel.add(descricaoField);
                    panel.add(new JLabel("VALOR:"));
                    panel.add(valorField);
        
                    int result = JOptionPane.showConfirmDialog(
                        null,
                        panel,
                        "EDITAR ANÚNCIO (ID: " + id + ")",
                        JOptionPane.OK_CANCEL_OPTION
                    );
        
                    if (result == JOptionPane.OK_OPTION) {
                        String novaDescricao = descricaoField.getText();
                        Double novoValor = Double.parseDouble(valorField.getText());
        
                        try {
                            
                        } catch (NumberFormatException ex) {
                            display.setText("POR FAVOR, INSIRA UM ID VÁLIDO.");
                        }
        
                        if (!novaDescricao.equals(anuncio.getDescricao()) && saoValoresDiferentes(novoValor, anuncio.getValor())) {
                            limparDisplay();
                            db.editarAnuncio(cuidador, id, novaDescricao, novoValor, display);
                        } else if (!novaDescricao.equals(anuncio.getDescricao())) {
                            limparDisplay();
                            db.editarAnuncio(cuidador, id, novaDescricao, display);
                        } else if (saoValoresDiferentes(novoValor, anuncio.getValor())) {
                            limparDisplay();
                            db.editarAnuncio(cuidador, id, novoValor, display);
                        } else {
                            limparDisplay();
                            display.setText("NENHUMA ALTERAÇÃO FOI REALIZADA.");
                        }
                        
                    }
        
                } catch (NumberFormatException ex) {
                    display.setText("POR FAVOR, INSIRA UM ID VÁLIDO.");

                }   
            }
        });
        
        

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelacuidador3.dispose();
                JanelaCuidador1();
            }
        });
    

        janelacuidador3.add(panel);
        janelacuidador3.setVisible(true);
    }

    public void JanelaFamiliar(){

        JFrame janelafamiliar = new JFrame("CUIDA+: FAMILIAR");
        janelafamiliar.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelafamiliar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelafamiliar.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);

        janelafamiliar.add(panel);
        janelafamiliar.setVisible(true);

    }

    private boolean saoValoresDiferentes(double valor1, double valor2) {
        double tolerancia = 0.0001; // Define a margem de erro aceitável
        return Math.abs(valor1 - valor2) > tolerancia;
    }
    

}
