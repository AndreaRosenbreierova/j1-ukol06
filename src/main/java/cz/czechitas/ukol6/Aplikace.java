package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;


    private JSpinner husyField;
    private JSpinner kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    private JButton vypocitatButton;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        husyField = new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        SpinnerNumberModel husyModel = new SpinnerNumberModel();
        husyModel.setStepSize(2);
        husyModel.setValue(2);
        husyModel.setMinimum(0);
        husyModel.setMaximum(20);
        husyField.setModel(husyModel);
        add(husyLabel);
        add(husyField);


        kraliciField = new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        SpinnerNumberModel kraliciModel = new SpinnerNumberModel();
        kraliciModel.setStepSize(2);
        kraliciModel.setValue(2);
        kraliciModel.setMinimum(0);
        kraliciModel.setMaximum(20);
        kraliciField.setModel(kraliciModel);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        add(pocetHlavLabel);
        add(pocetHlavField, "span");


        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('P');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);
    }
    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        vypocitatButton.setHorizontalAlignment(JButton.CENTER);

        return buttonBar;

    }

    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHus = (Integer) husyField.getValue();

        int pocetKraliku = (Integer) kraliciField.getValue();

        int pocetHlav = pocetHus + pocetKraliku;

        int pocetNohou = pocetHus * 2 + pocetKraliku * 4;

        pocetHlavField.setText(String.valueOf(pocetHlav));

        pocetNohouField.setText(String.valueOf(pocetNohou));




    }
}


