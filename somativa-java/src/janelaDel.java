import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class janelaDel extends JFrame {
    public ArrayList<Produto> lista = new ArrayList<Produto>();
    telaLogin user;

    private JLabel nome = new JLabel("Insira o nome do produto: ");
    private JTextField nomeProduto = new JTextField(100);
    private JButton btnDel = new JButton("Deletar");

    public janelaDel(ArrayList<Produto> lista) {
        super("SM - Deletar Produto");
        this.lista = lista;
        getContentPane().setBackground(Color.black);
        nome.setForeground(Color.white);
        btnDel.setBackground(Color.yellow);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);
        iniciarDel();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void iniciarDel() {
        this.setLayout(null);
        nome.setBounds(10, 10, 180, 100);
        add(nome);
        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);
        btnDel.setBounds(160, 270, 100, 40);
        add(btnDel);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pNome;
                int controle = -1;
                pNome = nomeProduto.getText();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).nome.equals(pNome)) {
                        lista.remove(i);
                        controle = 1;
                        JOptionPane.showMessageDialog(null, "Produto Deletado!");
                        try {
                            user.logLista.add("O usuário " + user.usuario + " deletou o produto "  + nomeProduto.getText() + " - " + user.logTxt.dataFormatada );
                            user.logTxt.criarLog(user.logLista);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
                if (controle == -1) JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            }
        });
    }
}

