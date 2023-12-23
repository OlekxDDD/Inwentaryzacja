package org.example;
                    //import library
import com.google.protobuf.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateItem extends JPanel implements ActionListener {
    private final JTextField ID_KField = new JTextField(); //field for ID_K
    private final JTextField NameField = new JTextField(); //field for Name
    private final JTextField DescriptionField = new JTextField();    //field for Description
    private final JTextField ValueField = new JTextField();  //field for value
    private final JTextField AmountField = new JTextField(); //firld for amount
    private final JButton addButton; //add button
    final JButton WhatDoComeBackButton; //declarate What Do Come Back Button
    CreateItem(){
        Main.view.dispose();    //dispose view in Main

        JLabel ID_KLabel = new JLabel("ID_K: ");     //create Lebel for ID_K
        JLabel nameLabel = new JLabel("Name: ");     //create Lebel for Name
        JLabel descriptionLabel = new JLabel("Opis: ");     //create Lebel for Description
        JLabel valueLabel = new JLabel("wartosc: ");        //create Lebel for Value
        JLabel amountLabel = new JLabel("ilosc");     //create Lebel for Amount

        //create panel for input data
        JPanel inputPanel = new JPanel();   //initialization JPanel
        inputPanel.setLayout(new GridLayout(6,2));  //create grid for input panel
        inputPanel.add(ID_KLabel);
        inputPanel.add(ID_KField);
        inputPanel.add(nameLabel);
        inputPanel.add(NameField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(DescriptionField);
        inputPanel.add(valueLabel);
        inputPanel.add(ValueField);
        inputPanel.add(amountLabel);
        inputPanel.add(AmountField);

        add(inputPanel);    //add input Panel

        addButton = new JButton("Dodaj Item");    //initialization JButton
        addButton.addActionListener(this);    //listing button
        add(addButton);   //add login button

        setLayout(new GridLayout(3,1)); // set layout for Create Item
        WhatDoComeBackButton = new JButton("Wroc do Menu");  //initialization What Do Come Back Button
        WhatDoComeBackButton.addActionListener(this);   //listing button
        add(WhatDoComeBackButton);  //add What Do Come Back Button
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //get Source
        if(source == WhatDoComeBackButton){ //if click on What Do come back Button
            Main.view = new View("WhatDo"); //back to What Do view
            Action.view.dispose();  //dispose this window
        }else if(source == addButton){//if click on Login button
            String ID_K = "\""+ID_KField.getText()+"\"";
            String name = "\""+NameField.getText()+"\"";
            String description = "\""+DescriptionField.getText()+"\"";
            String value = "\""+ ValueField.getText()+"\"";
            String amount = "\""+AmountField.getText()+"\"";

            Action.addItem(ID_K,name,description,value,amount); //send this input to addItem

            ID_KField.setText(" ");
            NameField.setText(" ");
            DescriptionField.setText(" ");
            ValueField.setText(" ");
            AmountField.setText(" ");
        }
    }
}
