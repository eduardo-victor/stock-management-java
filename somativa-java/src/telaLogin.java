import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class telaLogin extends JFrame {
    public ArrayList<String> logLista = new ArrayList<String>();
    Log logTxt = new Log();
    private JLabel texto = new JLabel("SM - IDENTIFICAÇÃO");
    private JLabel username = new JLabel("NOME: ");
    private JTextField userLogin = new JTextField(100);
    private JButton login = new JButton("ENTRAR");
    String usuario;


    public telaLogin() {
        super("SM - Identificação");
        setLayout(null);

        texto.setBounds(100, 10, 300, 50);
        texto.setFont(new Font("Montserrat", Font.BOLD, 18));
        texto.setForeground(Color.white);
        add(texto);

        username.setBounds(80, 80, 200, 40);
        username.setFont(new Font("Montserrat", Font.BOLD, 16));
        username.setForeground(Color.white);
        add(username);

        userLogin.setBounds(150, 90, 150, 20);
        add(userLogin);

        login.setBounds(150, 140, 90, 30);
        login.setBackground(Color.yellow);
        add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = userLogin.getText();
                if (userLogin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O NOME NÃO PODE SER VAZIO.", "ERRO", JOptionPane.ERROR_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "BEM VINDO " + usuario.toUpperCase());
                    JFrame estoque = new Gerenciamento();
                    dispose();
                    estoque.setVisible(true);
                    try {
                        logLista.add("O usuário " + usuario + " entrou - " + logTxt.dataFormatada );
                        logTxt.criarLog(logLista);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        });


        setSize(400, 230);

        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
