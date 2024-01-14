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
    private final JTextField AmountField = new JTextField(); //field for amount
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
            String ID_KString = ID_KField.getText();    //declare variable for check their value
            String nameString = NameField.getText();
            String descriptionString = DescriptionField.getText();
            String valueString =  ValueField.getText();
            String amountString = AmountField.getText();

            boolean isID_KString = Action.isDigitString(ID_KString);    // checking Strings are with only numbers/int
            boolean isValueString = Action.isDigitString(valueString);
            boolean isAmountString = Action.isDigitString(amountString);

            boolean isLessThanMaxName = Action.isLessThanMaxText(nameString);   // checking Strings are Less than Max text
            boolean isLessThanMaxDescription = Action.isLessThanMaxText(descriptionString);

            boolean isID_KNull = !ID_KString.isEmpty();    //checking ID_k and Name aren't null
            boolean isNameNull = !nameString.isEmpty();


            if(isID_KString && isValueString && isAmountString && isLessThanMaxName && isLessThanMaxDescription && isID_KNull && isNameNull) {
                String ID_K = "\"" + ID_KString + "\""; // add "" to Strings
                String name = "\"" + nameString + "\"";
                String description = "\"" + descriptionString + "\"";
                String value = "\"" + valueString + "\"";
                String amount = "\"" + amountString + "\"";

                Action.addItem(ID_K, name, description, value, amount); //send this input to addItem

                ID_KField.setText(" "); //clear input fields
                NameField.setText(" ");
                DescriptionField.setText(" ");
                ValueField.setText(" ");
                AmountField.setText(" ");
            }else{
                String MessegaToShowInAlert = "";   // declare variable for message
                if(!isID_KString){
                    MessegaToShowInAlert += "ID_K musi zawierac tylko liczby\n";
                }
                if(!isAmountString){
                    MessegaToShowInAlert += "Ilosc musi zawierac tylko liczby\n";
                }
                if(!isValueString){
                    MessegaToShowInAlert += "Wartosc musi zawierac tylko liczby\n";
                }
                if(!isLessThanMaxDescription){
                    MessegaToShowInAlert += "Opis moze zawierac maksymalnie 65 535 znaków\n";
                }
                if(!isLessThanMaxName){
                    MessegaToShowInAlert += "Nazwa moze zawierac maksymalnie 65 535 znaków\n";
                }
                if(!isID_KNull){
                    MessegaToShowInAlert += "ID_K nie moze byc pusty\n";
                }
                if(!isNameNull){
                    MessegaToShowInAlert += "Name nie moze byc pusty\n";
                }
                JOptionPane.showMessageDialog(null, MessegaToShowInAlert);  // show message ot user
            }
        }
    }
}
