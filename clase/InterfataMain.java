package clase;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class InterfataMain {
    private String selectie;
    private JFrame FereastraDeDeschidere;
    private Utilizator persoana;
    private String imagine = "false-2061131_1280.png";
    private ArrayList list = new ArrayList<Camere>();

    public InterfataMain(){ 
        FereastraDeDeschidere = new JFrame();
        ImageIcon iconita = new ImageIcon("Desktop - 20.png");
        FereastraDeDeschidere.setIconImage(iconita.getImage());
        FereastraDeDeschidere.setTitle("Hotel Firenze: Pagina de Deschidere");
        FereastraDeDeschidere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FereastraDeDeschidere.setSize(700, 300);
        FereastraDeDeschidere.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(4, 1, 0, 0));
        PanouPrincipal.setBackground(new Color(255,230,145));
        
        JPanel rand1 = new JPanel();
        rand1.setBackground(new Color(255,230,145));
        JLabel text1 = new JLabel("Bun venit la Hotel Firenze");
        Font font = new Font("Cambria", Font.BOLD, 30);
        text1.setFont(font);
        rand1.add(text1);

        JPanel rand2 = new JPanel();
        rand2.setBackground(new Color(255,230,145));
        JLabel text2 = new JLabel("<html>Daca doriti sa va cazati apasa butonul <b>CREEAZA</b></html>");
        Font font1 = new Font("Cambria", Font.PLAIN, 20);
        text2.setFont(font1);
        rand2.add(text2);

        JPanel rand3 = new JPanel();
        rand3.setBackground(new Color(255,230,145));
        JLabel text3 = new JLabel("<html>Daca doriti sa mergeti doar la restaurant apasa butonul <b>URMATOR</b></html>");
        Font font2 = new Font("Cambria", Font.PLAIN,20);
        text3.setFont(font2);
        rand3.add(text3);

        JPanel rand4 = new JPanel();
        rand4.setBackground(new Color(255,230,145));
        JButton creeaza = new JButton("Creeaza");
        creeaza.setBackground(new Color(54,53,53));
        creeaza.setForeground(Color.WHITE);
        creeaza.setFont(new Font("Cambria", Font.BOLD,20));
        creeaza.setPreferredSize(new Dimension(130,50));
        creeaza.setFocusPainted(false);
        creeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(creeaza);
                ImageIcon iconita2 = new ImageIcon("Desktop - 20.png");
                currentFrame.setIconImage(iconita2.getImage());
                currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
                FereastraCreeazaCont();
            }
        });
        rand4.add(creeaza);
        JButton urmator = new JButton("Urmator");
        urmator.setBackground(new Color(54,53,53));
        urmator.setForeground(Color.WHITE);
        urmator.setFont(new Font("Cambria", Font.BOLD,20));
        urmator.setPreferredSize(new Dimension(130,50));
        urmator.setFocusPainted(false);
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


    private void FereastraCreeazaCont() 
    {

        JFrame ferestra = new JFrame();
        ferestra.setTitle("Hotel Firenze: Creeaza cont");
        ferestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ferestra.setSize(400, 300);
        ferestra.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(5, 1));
        SchimbareCuloare(PanouPrincipal);


        JPanel rand1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand1);
        JLabel text1 = new JLabel("Nume: ");
        setText(text1);
        rand1.add(text1);
        JTextField textField1 = new JTextField(20);
        rand1.add(textField1);

        JPanel rand2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand2);
        JLabel text2 = new JLabel("Parola: ");
        setText(text2);
        rand2.add(text2);
        JTextField textField2 = new JTextField(20);
        rand2.add(textField2);

        JPanel rand3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand3);
        JLabel text3 = new JLabel("Depunde o suma in portofelul contului: ");
        setText(text3);
        rand3.add(text3);
        JTextField textField3 = new JTextField(4);
        rand3.add(textField3);
        
        JPanel rand5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand5);
        JLabel text5 = new JLabel("Numarul de persoane:");
        setText(text5);
        rand5.add(text5);
        JTextField textField4 = new JTextField(2);
        textField4.setLayout(new FlowLayout(FlowLayout.LEFT));
        rand5.add(textField4);

        JPanel rand4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand4);
        JButton salveaza = new JButton("Salveaza");
        setButon(salveaza);
        salveaza.setLayout(new FlowLayout(FlowLayout.LEFT));
        salveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nr = textField3.getText();
                String parola = textField2.getText();
                String nume = textField1.getText();
                String nrP = textField4.getText();
                try{
                    int Nr = Integer.parseInt(nr);
                    int NrP = Integer.parseInt(nrP);

                    // fereastra modala
                    JFrame continuare = new JFrame("Continuare");
                    continuare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    continuare.setSize(300, 200);
                    continuare.setLocationRelativeTo(null);

                    JPanel panouMare = new JPanel(new GridLayout(2, 1));

                    JPanel panel1 = new JPanel();
                    SchimbareCuloare(panel1);
                    JLabel apas = new JLabel("Doriti sa continuati?");
                    apas.setFont(new Font("Cambria", Font.BOLD, 20));
                    panel1.add(apas);

                    JPanel panel2 = new JPanel();
                    SchimbareCuloare(panel2);
                    
                    JButton daButton = new JButton("Da");
                    setButon(daButton);
                    daButton.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e){
                            persoana = Utilizator.Init(nume, parola);
                            persoana.setPortofel(Nr);
                            persoana.setNrPersoane(NrP);
                            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(daButton);
                            currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
                            ferestra.dispose();
                            AdaugareCamere();
                            
                         }
                    });
                    panel2.add(daButton);

                    JButton nuButton = new JButton("Nu");
                    setButon(nuButton);
                    nuButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e)
                        {
                            continuare.dispose();
                        }
            
                    });
                    panel2.add(nuButton);

                    panouMare.add(panel1);
                    panouMare.add(panel2);
                    continuare.add(panouMare);
                    continuare.setVisible(true);
                }
                catch(NumberFormatException nu){
                    Eroare();
                }
            }
        });
        rand4.add(salveaza);


        PanouPrincipal.add(rand1);
        PanouPrincipal.add(rand2);
        PanouPrincipal.add(rand3);
        PanouPrincipal.add(rand5);
        PanouPrincipal.add(rand4);
        ferestra.add(PanouPrincipal);
        ferestra.setVisible(true);
    }

    private void Urmator() 
    {
        JFrame fereastra = new JFrame();
        fereastra.setTitle("Hotel Firenze: Selectie");
        fereastra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fereastra.setSize(300, 200);
        fereastra.setLocationRelativeTo(null);

        JPanel PanouPrincipal = new JPanel(new GridLayout(3, 1));
        SchimbareCuloare(PanouPrincipal);

        JPanel rand1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand1);
        JLabel text1 = new JLabel("Depunde o suma in portofelul: ");
        setText(text1);
        rand1.add(text1);
        JTextField textField1 = new JTextField(4);
        rand1.add(textField1);

        JPanel rand3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand3);
        JLabel text3 = new JLabel("Numarul de persoane");
        setText(text3);
        rand3.add(text3);
        JTextField textField3 = new JTextField(2);
        rand3.add(textField3);

        JPanel rand2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SchimbareCuloare(rand2);
        JButton salveaza = new JButton("Salveaza");
        setButon(salveaza);
        salveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nr = textField1.getText();
                String nrP = textField3.getText();
                try{
                    int Nr = Integer.parseInt(nr);
                    int NrP = Integer.parseInt(nrP);
                    //Fereastra modala

                    JFrame continuare = new JFrame("Continuare");
                    continuare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    continuare.setSize(300, 200);
                    continuare.setLocationRelativeTo(null);

                    JPanel panouMare = new JPanel(new GridLayout(2, 1));
                    SchimbareCuloare(panouMare);

                    JPanel panel1 = new JPanel();
                    SchimbareCuloare(panel1);
                    JLabel apas = new JLabel("Doriti sa continuati?");
                    apas.setFont(new Font("Cambria", Font.BOLD, 20));
                    panel1.add(apas);

                    JPanel panel2 = new JPanel();
                    SchimbareCuloare(panel2);

                    JButton daButton = new JButton("Da");
                    setButon(daButton);
                    daButton.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e){
                            persoana = Utilizator.Init();
                            persoana.setPortofel(Nr);
                            persoana.setNrPersoane(NrP);
                            fereastra.dispose();
                            continuare.dispose();
                            //urmatoarea ferestra
                         }
                    });
                    panel2.add(daButton);

                    JButton nuButton = new JButton("Nu");
                    setButon(nuButton);
                    nuButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e)
                        {
                            continuare.dispose();
                        }
            
                    });
                    panel2.add(nuButton);

                    panouMare.add(panel1);
                    panouMare.add(panel2);
                    continuare.add(panouMare);
                    continuare.setVisible(true);

                    
                }
                catch(NumberFormatException nu)
                {
                    Eroare();
                }  
            }
        });
        rand2.add(salveaza);
        

        PanouPrincipal.add(rand1);
        PanouPrincipal.add(rand3);
        PanouPrincipal.add(rand2);
        fereastra.add(PanouPrincipal);
        fereastra.setVisible(true);
    }

    private void AdaugareCamere() // adugare un rand nou in care sa spunem cat costa ficare timp de camera pe persoana max 5 pers in camera 
    {
        JFrame frame = new JFrame("Selectare");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridLayout(5,1));
        SchimbareCuloare(panelPrincipal);

        JPanel panel5 = new JPanel();
        SchimbareCuloare(panel5);
        JLabel label2 = new JLabel( "Nivelele de confort ale camerelor:");
        label2.setFont(new Font("Cambria", Font.BOLD, 25));
        panel5.add(label2);

        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

        String[] optiuni2 = {"Standard / 100 per persoana", "Mediu / 150 per persoana", "Ridicat / 300 per persoana"};

        for (int i = 0; i < optiuni2.length; i++)
        {
            String optiune = optiuni2[i];
            JLabel label5 = new JLabel(optiune);
            setText(label5);
            JPanel eticheta = new JPanel();
            SchimbareCuloare(eticheta);
            eticheta.add(label5);
            eticheta.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel5.add(eticheta);
        }



        JPanel panel1 = new JPanel();
        SchimbareCuloare(panel1);
        JLabel text1 = new JLabel("Numarul de persoane : " + persoana.getNrPersoane());
        setText(text1);
        panel1.add(text1);
        JLabel text2 = new JLabel("     Portofelul contului : " + persoana.getPortofel());
        setText(text2);
        panel1.add(text2);

        JPanel panel2 = new JPanel();
        SchimbareCuloare(panel2);
        String[] optiuni = {"Standard", "Mediu", "Ridicat"};
        JComboBox<String> box = new JComboBox<>(optiuni);
        Font fontCurent = box.getFont();
        Font font = new Font(fontCurent.getName(), fontCurent.getStyle(), 15);
        box.setFont(font);
        box.setPreferredSize(new Dimension(200,50));
        box.setSize(20, 5);
        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String da = (String) box.getSelectedItem();
                selectie = da;
                JOptionPane.showMessageDialog(null, "Optiune selectata " + selectie);
            }

        });
        panel2.add(box);


        JPanel panel3 = new JPanel();
        SchimbareCuloare(panel3);
        JLabel label = new JLabel ("Numarul de persoane cazate in camera : ");
        setText(label);
        panel3.add(label);
        JTextField text = new JTextField(3);
        panel3.add(text);

        JPanel panel4 = new JPanel();
        SchimbareCuloare(panel4);
        JButton salveaza = new JButton("Salveaza");
        setButon(salveaza);
        salveaza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String nrP = text.getText();
                try{
                    int NrP = Integer.parseInt(nrP);
                    if (NrP > 5)
                    {
                        JOptionPane.showMessageDialog(null, "Nu poti avea mai mult de 5 persoane in camera");
                    }
                    else if (NrP > persoana.getNrPersoane()){
                        JOptionPane.showMessageDialog(null, "Numarul de persoane selectate in aceasta camera este mai mare decat persoanele ce trebuie cazate");
                    }
                    else{
                        
                        int suma = NrP * Camere.pret(selectie);
                        if (suma > persoana.getPortofel())
                        {
                            //fereastra eroare ca nu avem destul bani si posbilitatea de a mai adauga bani se inchde ferestra si se reapleaza functia
                        }
                        else{
                            //fereastra modala
                            list.add(new Camere(selectie, NrP));
                            persoana.ScaderePersoane(NrP);
                            persoana.scaderePortfel(suma);
                            frame.dispose();
                            if(persoana.getNrPersoane() == 0)
                            {
                            //mergem mai departe
                            }
                            else{
                                AdaugareCamere();
                            }
                        }
                    }
                }
                catch(NumberFormatException nu){
                    JOptionPane.showMessageDialog(null, "Nu ai introdus numar");
                }
            }
        });
        panel4.add(salveaza);


        panelPrincipal.add(panel5);
        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        panelPrincipal.add(panel4);
        frame.add(panelPrincipal);
        frame.setVisible(true);

    }

    public void Eroare()
    {           
        JPanel panelMare = new JPanel();
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JFrame eroare = new JFrame();
        eroare.setTitle("eroare");
        eroare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        eroare.setSize(300, 100);
        eroare.setLocationRelativeTo(null);

        JLabel text4 = new JLabel("Adaugati o valoare numerica");
        setText(text4);
        panel1.add(text4);

        try{
            ImageIcon imagine2 = new ImageIcon(imagine);
            Image imagineRedimensionata = imagine2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon imagineNoua = new ImageIcon(imagineRedimensionata);
            JLabel label = new JLabel(imagineNoua);
            panelMare.add(label, BorderLayout.WEST); 
            panelMare.add(text4, BorderLayout.CENTER);

            eroare.add(panelMare);
            eroare.setVisible(true);
            eroare.setVisible(true);
        } catch(java.awt.image.ImagingOpException ex)
        {
            ex.printStackTrace();
        }
    }

    public void SchimbareCuloare(JPanel panel)
    {
        panel.setBackground(new Color(250,230,145));
    }

    public void setButon(JButton buton)
    {
        buton.setBackground(new Color(54,53,53));
        buton.setForeground(Color.WHITE);
        buton.setFont(new Font("Cambria", Font.BOLD,20));
        //buton.setPreferredSize(new Dimension(130,50));
        buton.setFocusPainted(false);
    }

    public void setText(JLabel label)
    {
        label.setFont(new Font("Cambria", Font.BOLD, 15));
    }
}

