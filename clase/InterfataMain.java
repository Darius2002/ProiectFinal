package clase;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;

public class InterfataMain {
    private JFrame FereastraDeDeschidere;
    private Utilizator persoana;
    //adugare la creeaza si urmator nr de persoane

    public InterfataMain(){ // logo, aragare text rand2, culori
        FereastraDeDeschidere = new JFrame();
        FereastraDeDeschidere.setTitle("Hotel Firenze: Pagina de Deschidere");
        FereastraDeDeschidere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FereastraDeDeschidere.setSize(700, 300);
        FereastraDeDeschidere.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(4, 1, 0, 0));
        
        JPanel rand1 = new JPanel();
        JLabel text1 = new JLabel("Bun venit la Hotel Firenze");
        Font font = new Font("Cambria", Font.BOLD, 30);
        text1.setFont(font);
        rand1.add(text1);

        JPanel rand2 = new JPanel();
        JLabel text2 = new JLabel("<html>Daca doriti sa va cazati apasa butonul <b>CREEAZA</b></html>");
        Font font1 = new Font("Cambria", Font.PLAIN, 20);
        text2.setFont(font1);
        rand2.add(text2);

        JPanel rand3 = new JPanel();
        JLabel text3 = new JLabel("<html>Daca doriti sa mergeti doar la restaurant apasa butonul <b>URMATOR</b></html>");
        Font font2 = new Font("Cambria", Font.PLAIN,20);
        text3.setFont(font2);
        rand3.add(text3);

        JPanel rand4 = new JPanel();
        JButton creeaza = new JButton("Creeaza");
        creeaza.setPreferredSize(new Dimension(130,50));
        creeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(creeaza);
                currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
                FerestaCreazaCont();
            }
        });
        rand4.add(creeaza);
        JButton urmator = new JButton("Urmator");
        urmator.setPreferredSize(new Dimension(130,50));
        urmator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(urmator);
                currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
                Urmator();
            }
        });
        rand4.add(urmator);

        
        PanouPrincipal.add(rand1);
        PanouPrincipal.add(rand2);
        PanouPrincipal.add(rand3);
        PanouPrincipal.add(rand4);
        FereastraDeDeschidere.add(PanouPrincipal);
    }

    public void show()
    {
        FereastraDeDeschidere.setVisible(true);
    }


    private void FerestaCreazaCont() // scroll, culori
    {
        JFrame ferestra = new JFrame();
        ferestra.setTitle("Hotel Firenze: Creeaza cont");
        ferestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ferestra.setSize(600, 600);
        ferestra.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(4, 1));

        JPanel rand1 = new JPanel();
        JLabel text1 = new JLabel("Nume: ");
        rand1.add(text1);
        JTextField textField1 = new JTextField(20);
        rand1.add(textField1);

        JPanel rand2 = new JPanel();
        JLabel text2 = new JLabel("Parola: ");
        rand2.add(text2);
        JTextField textField2 = new JTextField(20);
        rand2.add(textField2);

        JPanel rand3 = new JPanel();
        JLabel text3 = new JLabel("Depunde o suma in portofelul contului: ");
        rand3.add(text3);
        JTextField textField3 = new JTextField(4);
        rand3.add(textField3);
        
        JPanel rand4 = new JPanel();
        JButton salveaza = new JButton("Salveaza");
         salveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nr = textField3.getText();
                String parola = textField2.getText();
                String nume = textField1.getText();
                try{
                    int Nr = Integer.parseInt(nr);
                    persoana = Utilizator.Init(nume, parola);
                    persoana.setPortofel(Nr);
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(salveaza);
                    currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
                    /// urmatoare fereastra
                }
                catch(NumberFormatException nu){
                    JFrame eroare = new JFrame();
                    eroare.setTitle("eroare");
                    eroare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    eroare.setSize(300, 100);
                    eroare.setLocationRelativeTo(null);
                    JLabel text4 = new JLabel("Adaugati o valoare numerica in campul portofel");
                    eroare.add(text4);
                    eroare.setVisible(true);
                }
            }
        });
        rand4.add(salveaza);


        PanouPrincipal.add(rand1);
        PanouPrincipal.add(rand2);
        PanouPrincipal.add(rand3);
        PanouPrincipal.add(rand4);
        ferestra.add(PanouPrincipal);
        ferestra.setVisible(true);
    }

    private void Urmator() // culori 
    {
        JFrame fereastra = new JFrame();
        fereastra.setTitle("Hotel Firenze: Creeaza cont");
        fereastra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fereastra.setSize(600, 600);
        fereastra.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(2, 1));

        JPanel rand1 = new JPanel();
        JLabel text1 = new JLabel("Depunde o suma in portofelul: ");
        rand1.add(text1);
        JTextField textField1 = new JTextField(4);
        rand1.add(textField1);

        JPanel rand2 = new JPanel();
        JButton salveaza = new JButton("Salveaza");
        salveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nr = textField1.getText();
                try{
                    int Nr = Integer.parseInt(nr);
                    persoana = Utilizator.Init();
                    persoana.setPortofel(Nr);
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(salveaza);
                    currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));

                    // urmatoarea fereastra
                }
                catch(NumberFormatException nu)
                {
                    JFrame eroare = new JFrame();
                    eroare.setTitle("eroare");
                    eroare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    eroare.setSize(300, 100);
                    eroare.setLocationRelativeTo(null);
                    JLabel text4 = new JLabel("Adaugati o valoare numerica in campul portofel");
                    eroare.add(text4);
                    eroare.setVisible(true);
                }  
            }
        });
        rand2.add(salveaza);
        

        PanouPrincipal.add(rand1);
        PanouPrincipal.add(rand2);
        fereastra.add(PanouPrincipal);
        fereastra.setVisible(true);
    }
}
