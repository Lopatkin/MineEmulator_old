package com.company.vizor101;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Administrator on 26.01.17.
 */
public class SimpleGUI extends JFrame {

    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input: ");
    private JRadioButton radio1 = new JRadioButton("Select this: ");
    private JRadioButton radio2 = new JRadioButton("Select that: ");
    private JCheckBox check = new JCheckBox("Check", false);


    class ButtonActionListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            String message = "";
            message += "Button was pressed\n";
            message += "Text input" + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio #1": "Radio #2") + "is selected!\n";
            message += "Checkbox is selected" + ((check.isSelected()) ? " checked" : " unchecked");

            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public SimpleGUI(){
        super("Simple example");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);

        button.addActionListener(new ButtonActionListener());

        container.add(button);
    }

}
