package gui;

import dao.UserDAO;
import modelo.User;
import javax.swing.*;
import java.awt.*;

public class UserGUI extends JFrame {

    private JTextField jTextField1; // nome
    private JTextField jTextField2; // cpf
    private JTextField jTextField3; // email
    private JTextField jTextField4; // telefone

    public UserGUI() {
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Rótulo principal
        JLabel titulo = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel painel = new JPanel(new GridLayout(4, 2, 8, 8));
        painel.setBorder(BorderFactory.createTitledBorder("Cadastrar novo usuário"));

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();

        painel.add(new JLabel("Nome:"));
        painel.add(jTextField1);
        painel.add(new JLabel("CPF:"));
        painel.add(jTextField2);
        painel.add(new JLabel("Email:"));
        painel.add(jTextField3);
        painel.add(new JLabel("Telefone:"));
        painel.add(jTextField4);

        add(painel, BorderLayout.CENTER);

        // Botões
        JPanel painelBotoes = new JPanel();
        JButton jButton1 = new JButton("Cadastrar");
        JButton jButton2 = new JButton("Limpar");
        JButton jButton3 = new JButton("Sair");

        painelBotoes.add(jButton1);
        painelBotoes.add(jButton2);
        painelBotoes.add(jButton3);
        add(painelBotoes, BorderLayout.SOUTH);

        // CADASTRAR
        jButton1.addActionListener(e -> {
            User usuarios = new User();
            usuarios.setNome(jTextField1.getText());
            usuarios.setCpf(jTextField2.getText());
            usuarios.setEmail(jTextField3.getText());
            usuarios.setTelefone(jTextField4.getText());

            if (jTextField1.getText().isEmpty()
                    || jTextField2.getText().isEmpty()
                    || jTextField3.getText().isEmpty()
                    || jTextField4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
            } else {
                UserDAO dao = new UserDAO();
                dao.adiciona(usuarios);
                JOptionPane.showMessageDialog(null, "Usuário " + jTextField1.getText() + " inserido com sucesso!");
            }
        });

        // LIMPAR
        jButton2.addActionListener(e -> {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        });

        // SAIR
        jButton3.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserGUI tela = new UserGUI();
            tela.setVisible(true);
        });
    }
}
