
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class janelaAlt extends JFrame {
    public ArrayList<Produto> lista = new ArrayList<Produto>();
    telaLogin user;

    private JLabel nome = new JLabel("Nome do produto: ");
    private JTextField nomeProduto = new JTextField(100);
    private JLabel qtdProduto = new JLabel("Digite a qtd: ");
    private JTextField qtd = new JTextField(100);
    private JButton btnAlterar = new JButton("Alterar");

    public janelaAlt(ArrayList<Produto> lista) {
        super("SM - Alterar Quantidade");
        this.lista = lista;
        getContentPane().setBackground(Color.black);
        btnAlterar.setBackground(Color.yellow);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);
        iniciarAlterar();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void iniciarAlterar() {
        this.setLayout(null);
        nome.setBounds(30, 10, 180, 100);
        nome.setFont(new Font("Montserrat", Font.BOLD, 16));
        nome.setForeground(Color.white);
        add(nome);
        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);
        qtdProduto.setBounds(50, 80, 250, 100);
        qtdProduto.setFont(new Font("Montserrat", Font.BOLD, 16));
        qtdProduto.setForeground(Color.white);
        add(qtdProduto);
        qtd.setBounds(200, 120, 130, 20);
        add(qtd);
        btnAlterar.setBounds(160, 270, 100, 40);
        add(btnAlterar);
        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pNome, pQuantidade;
                pNome = nomeProduto.getText();
                int contole = -1;
                pQuantidade = qtd.getText();
                boolean qtdNumerica = true;
                try {
                    Double numero = Double.parseDouble(pQuantidade);
                } catch (NumberFormatException et) {
                    qtdNumerica = false;
                }
                if (qtdNumerica == false)
                    JOptionPane.showMessageDialog(null, "A quantidade precisa ser um número!");
                if (qtdNumerica == true) {
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).nome.equals(pNome)) {
                            lista.get(i).quantidade = pQuantidade;
                            contole = 1;
                            JOptionPane.showMessageDialog(null, "Quantidade do produto alterada!");

                            try {
                                user.logLista.add("O usuário " + user.usuario + " deletou o produto "  + nomeProduto.getText() + " - " + user.logTxt.dataFormatada );
                                user.logTxt.criarLog(user.logLista);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                if (contole == -1)
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

