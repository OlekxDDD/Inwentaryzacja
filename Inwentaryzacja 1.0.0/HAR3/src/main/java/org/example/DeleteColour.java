package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteColour extends JPanel implements ActionListener {


    private final JTextField ID_KField = new JTextField(); //field for ID_K
    private final JTextField NameField = new JTextField(); //field for Name
    private final JButton deleteID_K = new JButton("usun po ID_K");    //initialization JButton
    private final JButton deleteName = new JButton("usun po Name");    //initialization JButton

    private final JButton WhatDoComeBackButton = new JButton("Wroc do Menu");    //initialization JButton
    JPanel inputPanel = new JPanel();   //initialization JPanel
    DeleteColour(){
        Main.view.dispose();    //dispose view in Main

        JLabel ID_KLabel = new JLabel("ID_K: ");     //create Lebel for ID_K
        JLabel nameLabel = new JLabel("Name: ");     //create Lebel for Name

        deleteID_K.addActionListener(this);   //listing button
        deleteName.addActionListener(this);   //listing button

        //create panel for input data
        inputPanel.setLayout(new GridLayout(2,3));  //create grid for input panel

        inputPanel.add(ID_KLabel);
        inputPanel.add(ID_KField);
        inputPanel.add(deleteID_K);
        inputPanel.add(nameLabel);
        inputPanel.add(NameField);
        inputPanel.add(deleteName);

        add(inputPanel);
        setLayout(new GridLayout(2,1)); // set layout for Create Item
        WhatDoComeBackButton.addActionListener(this);   //listing button
        add(WhatDoComeBackButton);  //add What Do Come Back Button
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //get Source
        if(source == WhatDoComeBackButton) { //if click on What Do come back Button
            System.out.println("in what do");
            Main.view = new View("WhatDo"); //back to What Do view
            Action.view.dispose();  //dispose this window
        } else if (source == deleteID_K) {
            System.out.println("in ActionPerformed");
            String ID_K = ID_KField.getText();
            if(Action.isDigitString(ID_K)){
                String sql = "DELETE FROM kolory WHERE ID_K = "+ID_K+";";
                Action.ExecuteQuery(sql);
                ID_KField.setText("");
            }else{
                System.out.println("in what do because ID_K isn't digit");
                Main.view = new View("WhatDo"); //back to What Do view
                Action.view.dispose();  //dispose this window
            }
        } else if (source == deleteName) {
            System.out.println("in ActionPerformed");
            String Name = NameField.getText();
            String sql = "DELETE FROM kolory WHERE Name LIKE \"%"+Name+"%\";";
            Action.ExecuteQuery(sql);
            ID_KField.setText("");
        }


    }
}
