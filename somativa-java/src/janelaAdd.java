
import org.w3c.dom.xpath.XPathNamespace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class janelaAdd extends JFrame {
    private JLabel nome = new JLabel("Digite o produto: ");
    private JLabel quantidade = new JLabel("Digite a quantidade: ");
    private JTextField nomeProduto = new JTextField(100);
    private JTextField quantidadeProduto = new JTextField(100);
    private JButton btnAdicionar = new JButton("Adicionar");

    public ArrayList<Produto> lista = new ArrayList<Produto>();
    telaLogin user;
    public janelaAdd(ArrayList<Produto> lista) {
        super("SM - Adicionar Produtos");
        this.lista = lista;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        nome.setForeground(Color.white);
        quantidade.setForeground(Color.white);
        btnAdicionar.setBackground(Color.yellow);
        setSize(450, 400);
        iniciarAdd();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void iniciarAdd() {
        this.setLayout(null);
        nome.setBounds(10, 10, 180, 100);
        add(nome);
        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);
        quantidade.setBounds(10, 80, 250, 100);
        add(quantidade);
        quantidadeProduto.setBounds(200, 120, 200, 20);
        add(quantidadeProduto);
        btnAdicionar.setBounds(160, 270, 100, 40);
        add(btnAdicionar);
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pNome, pQuantidade;
                int ok = 1;
                pNome = nomeProduto.getText();
                pQuantidade = quantidadeProduto.getText();
                boolean quantidadeNumerica = true;
                try{
                    Double num = Double.parseDouble(pQuantidade);
                }catch (NumberFormatException et){
                    quantidadeNumerica = false;
                }
                if (quantidadeNumerica == false)
                    JOptionPane.showMessageDialog(null, "A Quantidade deve ser um número!");
                nomeProduto.setText("");
                quantidadeProduto.setText("");
                if(quantidadeNumerica==true){
                    for (int i = 0; i <lista.size(); i++) {
                        if(lista.get(i).nome.equals(pNome)){
                            JOptionPane.showMessageDialog(null, "Produto já existe!");
                            nomeProduto.setText("");
                            quantidadeProduto.setText("");
                            ok = 0;
                        }
                    }
                    if(ok==1){
                        try {
                            user.logLista.add("O usuário " + user.usuario + " adicionou o produto " + nomeProduto.getText() +" " + quantidadeProduto.getText() + " vezes - " + user.logTxt.dataFormatada );
                            user.logTxt.criarLog(user.logLista);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        lista.add(new Produto(pNome, pQuantidade));
                        JOptionPane.showMessageDialog(null, "Produto adicionado.");
                        nomeProduto.setText("");
                        quantidadeProduto.setText("");

                    }
                }
            }
        });
    }
}
