import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    
    private Database db;
    private JTextField cpfField, nomeField, idadeField, telefoneField;
    private JTextArea display;
  

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

        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);


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
            
            else {
                String cpf = cpfField.getText();
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String telefone = telefoneField.getText();

                Cuidador cuidador = new Cuidador(cpf, nome, idade, telefone);
                db.setCuidador(cuidador);
                display.setText("CUIDADOR CADASTRADO:\n" + cuidador.getNome());

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


    private void JanelaFamiliaCadastro(){

        JFrame janelacuidadorcadastro = new JFrame("CUIDA+: CADASTRO FAMILIAR");
        janelacuidadorcadastro.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janelacuidadorcadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacuidadorcadastro.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(200, 248, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("CUIDA+");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(70, 130, 180));

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

                else{
                    String cpf = cpfField.getText();
                    String nome = nomeField.getText();
                    int idade = Integer.parseInt(idadeField.getText());
    
                    Familiar familiar = new Familiar (cpf, nome, idade);
                    db.setFamiliar(familiar);
                    display.setText("FAMILIAR CADASTRADO:\n" + familiar.getNome());
    
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

                String cpf = cpfField.getText();

                Cuidador cuidador = db.getCuidador(cpf);
                Familiar familiar = db.getFamiliar(cpf);

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

        JButton btnListarA = new JButton("LISTAR SEUS ANÚNCIOS");
        JButton btnCadA = new JButton("CADASTRAR ANÚNCIO");
        JButton btnEdiA = new JButton("EDITAR ANÚNCIO");
        JButton btnDelA = new JButton("DELETAR ANÚNCIO");
        JButton btnListTodosA = new JButton("LISTAR TODOS ANÚNCIOS");
        JButton btnMenu = new JButton("VOLTAR AO MENU");

        c.gridy = 2;
        panel.add(btnListarA, c);
        c.gridy++;
        panel.add(btnCadA, c);
        c.gridy++;
        panel.add(btnEdiA, c);
        c.gridy++;
        panel.add(btnDelA, c);
        c.gridy++;
        panel.add(btnListTodosA, c);
        c.gridy++;
        panel.add(btnMenu, c);

        btnListarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("Listando seus anúncios...");
            }
        });
    
        btnCadA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("Abrindo formulário de cadastro de anúncio...");
            }
        });
    
        btnEdiA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("Abrindo editor de anúncios...");
            }
        });
    
        btnDelA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("Deletando anúncio selecionado...");
            }
        });
    
        btnListTodosA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para listar todos os anúncios disponíveis
                display.setText("Listando todos os anúncios...");
            }
        });
    
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retornar ao menu principal
                janelacuidador1.dispose();
                initUI();
            }
        });

        janelacuidador1.add(panel);
        janelacuidador1.setVisible(true);

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

}
