import javax.swing.*;
import java.awt.*;

public class telaLogin extends JFrame {
    private JLabel username = new JLabel("USERNAME: ");
    private JTextField userLogin = new JTextField(100);
    private JLabel password = new JLabel("PASSWORD: ");
    private JTextField userPass = new JTextField(100);
    private JButton login = new JButton("Login");
    private JButton pass = new JButton("Register");

    public telaLogin(){
        super("SM - Login and Register");
        setLayout(null);

        username.setBounds(100,80,200,40);
        username.setFont(new Font("Montserrat", Font.BOLD, 16));
        username.setForeground(Color.white);
        add(username);

        userLogin.setBounds(220, 90, 150, 20);
        add(userLogin);

        password.setBounds(100, 150, 200, 40);
        password.setFont(new Font("Montserrat", Font.BOLD, 16));
        password.setForeground(Color.white);
        add(password);

        userPass.setBounds(220, 160, 150, 20);
        add(userPass);


        setSize(450, 350);

        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

