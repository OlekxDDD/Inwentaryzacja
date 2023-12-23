package org.example;

import com.sun.javafx.binding.OrElseBinding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItem extends JPanel implements ActionListener {

    private final JTextField ID_IField = new JTextField(); //field for ID_I
    private final JTextField ColourNameField = new JTextField(); //field for ID_K
    private final JTextField NameField = new JTextField(); //field for Name
    private final JTextField DescriptionField = new JTextField();    //field for Description
    private final JTextField ValueField = new JTextField();  //field for value
    private final JTextField AmountField = new JTextField(); //field for amount
    private final JButton deleteID_I = new JButton("usun po ID_I");    //initialization JButton
    private final JButton deleteColourName = new JButton("usun po Kolor");    //initialization JButton
    private final JButton deleteName = new JButton("usun po Name");    //initialization JButton
    private final JButton deleteDescription = new JButton("usun po opis");    //initialization JButton
    private final JButton deleteValue = new JButton("usun po wartosc");    //initialization JButton
    private final JButton deleteAmount = new JButton("usun po ilosc");    //initialization JButton
    private final JButton WhatDoComeBackButton = new JButton("Wroc do Menu");    //initialization JButton
    DeleteItem(){
        Main.view.dispose();    //dispose view in Main

        JLabel ID_ILabel = new JLabel("ID_I: ");     //create Lebel for ID_I
        JLabel ColourNameLabel = new JLabel("ID_K: ");     //create Lebel for ID_K
        JLabel nameLabel = new JLabel("Name: ");     //create Lebel for Name
        JLabel descriptionLabel = new JLabel("Opis: ");     //create Lebel for Description
        JLabel valueLabel = new JLabel("wartosc: ");        //create Lebel for Value
        JLabel amountLabel = new JLabel("ilosc");     //create Lebel for Amount

        deleteID_I.addActionListener(this);   //listing button
        deleteAmount.addActionListener(this);   //listing button
        deleteDescription.addActionListener(this);   //listing button
        deleteColourName.addActionListener(this);   //listing button
        deleteName.addActionListener(this);   //listing button
        deleteValue.addActionListener(this);   //listing button

        //create panel for input data
        JPanel inputPanel = new JPanel();   //initialization JPanel
        inputPanel.setLayout(new GridLayout(6,3));  //create grid for input panel

        inputPanel.add(ID_ILabel);
        inputPanel.add(ID_IField);
        inputPanel.add(deleteID_I);

        inputPanel.add(ColourNameLabel);
        inputPanel.add(ColourNameField);
        inputPanel.add(deleteColourName);

        inputPanel.add(nameLabel);
        inputPanel.add(NameField);
        inputPanel.add(deleteName);

        inputPanel.add(descriptionLabel);
        inputPanel.add(DescriptionField);
        inputPanel.add(deleteDescription);

        inputPanel.add(valueLabel);
        inputPanel.add(ValueField);
        inputPanel.add(deleteValue);

        inputPanel.add(amountLabel);
        inputPanel.add(AmountField);
        inputPanel.add(deleteAmount);

        add(inputPanel);

        setLayout(new GridLayout(2,1)); // set layout for Create Item
        WhatDoComeBackButton.addActionListener(this);   //listing buttonc
        add(WhatDoComeBackButton);  //add What Do Come Back Button

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();  //get Source

        if(source == WhatDoComeBackButton) { //if click on What Do come back Button
            Main.view = new View("WhatDo"); //back to What Do view
            Action.view.dispose();  //dispose this window
        }else if(source == deleteID_I){
            String ID_I = ID_IField.getText();
            if (Action.isDigitString(ID_I)) {
                String sql = "DELETE FROM item WHERE ID_I ="+ID_I+";";
                Action.ExecuteQuery(sql);
                System.out.println("IN action");
            }else{
                ID_IField.setText("NIE POPRAWNY ID_I, MUSI BYC TYLKO CYFRA");
            }

        } else if(source == deleteColourName){  //TODO: Delete item by Colour
            String nameKolor = ColourNameField.getText();
            if (Action.isDigitString(nameKolor)) {
                String sql = "DELETE FROM item WHERE  ="+";";
                Action.ExecuteQuery(sql);
                System.out.println("IN action");
            }else{
                ColourNameField.setText(" ");
            }
        }else if(source == deleteName){
            String Name = "\""+NameField.getText()+"\"";
            String sql = "DELETE FROM item WHERE Name LIKE "+Name+";";
            Action.ExecuteQuery(sql);
            NameField.setText(" ");
        }else if(source == deleteDescription){
            String Desc = "\""+DescriptionField.getText()+"\"";
            String sql = "DELETE FROM item WHERE Description LIKE "+Desc+";";
            Action.ExecuteQuery(sql);
            DescriptionField.setText(" ");
        }else if(source == deleteAmount){
            String Amount = AmountField.getText();
            if (Action.isDigitString(Amount)) {
                String sql = "DELETE FROM item WHERE Amount ="+Amount+";";
                Action.ExecuteQuery(sql);
                System.out.println("IN action");
                AmountField.setText(" ");
            }else{
                AmountField.setText("NIE POPRAWNY ILOSC , MUSI BYC TYLKO CYFRA");
            }
        }else if(source == deleteValue){
            String Value = ValueField.getText();
            if (Action.isDigitString(Value)) {
                String sql = "DELETE FROM item WHERE Value ="+Value+";";
                Action.ExecuteQuery(sql);
                System.out.println("IN action");
                ValueField.setText(" ");
            }else{
                ValueField.setText("NIE POPRAWNY WARTOSC, MUSI BYC TYLKO CYFRA");
            }
        }
    }
}
