import javax.swing.*;
import java.awt.*;

public class telaLogin extends JFrame {
    private JLabel username = new JLabel("Username: ");
    private JTextField userLogin = new JTextField(100);
    private JLabel password = new JLabel("Password: ");
    private JTextField userPass = new JTextField(100);
    private JButton login = new JButton("Login");
    private JButton pass = new JButton("Register");

    public telaLogin(){
        super("SM - Login and Register");

        username.setBounds(40,80,200,40);
        username.setFont(new Font("Montserrato", Font.BOLD, 12));
        username.setForeground(Color.white);
        add(username);

        userLogin.setBounds(160, 240, 30, 80);
        add(userLogin);

        password.setFont(new Font("Montserrato", Font.BOLD, 12));
        password.setForeground(Color.white);

        add(password);

        login.setBackground(Color.yellow);
        add(login);
        pass.setBackground(Color.yellow);
        add(pass);

        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

