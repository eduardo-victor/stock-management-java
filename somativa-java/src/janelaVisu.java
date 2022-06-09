import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class janelaVisu extends JFrame {
    private JTextArea textArea = new JTextArea();
    public ArrayList<Produto> lista = new ArrayList<Produto>();

    public janelaVisu(ArrayList<Produto> lista){
        super("SM - Visualizar Produto");
        this.lista = lista;
        getContentPane().setBackground(Color.black);
        textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        iniciarVisu();
        setVisible(true);
    }

    public void iniciarVisu(){
        this.setLayout(null);
        textArea.setBounds(10, 10, 410, 230);
        add(textArea);
        try{
            for(Produto l:lista){
                janelaVisu.this.textArea.append(l.toString());
                janelaVisu.this.textArea.append("\n");
            }
        }catch (Exception ep){
            ep.printStackTrace();
        }
    }

    public class visualizarProdutos implements ActionListener {

        ArrayList<Produto> lista = new ArrayList<Produto>();

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
}
