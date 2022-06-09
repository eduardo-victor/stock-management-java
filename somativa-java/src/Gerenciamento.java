import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gerenciamento extends JFrame {

    public ArrayList<Produto> lista = new ArrayList<Produto>();

    private JButton addProduto = new JButton("Adicionar Produto");
    private JButton visuProduto = new JButton("Visualizar Produtos");
    private JButton delProduto = new JButton("Deletar Produto");
    private JButton altProduto = new JButton("Alterar Produto");
    private JLabel textProduto = new JLabel("GERENCIAMENTO DE ESTOQUE");

    Gerenciamento(){
        super("Gerenciamento de Estoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textProduto.setForeground(Color.white);
        textProduto.setFont(new Font("Montserrato", Font.BOLD, 15));
        addProduto.setBackground(Color.yellow);
        addProduto.setForeground(Color.black);
        visuProduto.setBackground(Color.yellow);
        visuProduto.setForeground(Color.black);
        delProduto.setBackground(Color.yellow);
        delProduto.setForeground(Color.black);
        altProduto.setBackground(Color.yellow);
        altProduto.setForeground(Color.black);
        getContentPane().setBackground(Color.black);
        iniciar();
        setSize(540, 400);
        setVisible(true);
    }

    public void iniciar(){
        this.setLayout(null);
        textProduto.setBounds(160, 15, 250, 50);
        add(textProduto);
        addProduto.setBounds(150, 70, 230, 40);
        add(addProduto);
        addProduto.addActionListener(new adicionarProdutos());
        visuProduto.setBounds(150, 130, 230, 40);
        add(visuProduto);
        visuProduto.addActionListener(new visualizarProdutos());
        delProduto.setBounds(150, 190, 230, 40);
        add(delProduto);
        delProduto.addActionListener(new deletarProdutos());
        altProduto.setBounds(150, 250, 230, 40);
        add(altProduto);
        altProduto.addActionListener(new alterarProdutos());
    }

    public class adicionarProdutos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaAdd janelaAdd = new janelaAdd(lista);
            janelaAdd.setVisible(true);
        }
    }

    public class visualizarProdutos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (lista.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Lista de produtos vazia, adicione um produto.");
            } else {
                janelaVisu janelaVisu = new janelaVisu(lista);
                janelaVisu.setVisible(true);
            }
        }
    }

    public class deletarProdutos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (lista.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Lista de produtos vazia, adicione um produto");
            } else {
                janelaDel janelaDel = new janelaDel(lista);
                janelaDel.setVisible(true);
            }
        }
    }

    public class alterarProdutos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (lista.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Lista de produtos vazia, adicione um produto.");
            } else {
                janelaAlt janelaAlt = new janelaAlt(lista);
                janelaAlt.setVisible(true);
            }
        }
    }

}
