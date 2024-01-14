package org.example;

import javax.swing.*;   //import librabry
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WhatDo extends JPanel implements ActionListener {
    private final JButton seeAllItems;  //declare button
    private final JButton seeAllColours;  //declare button
    private final JButton createItem;  //declare button
    private final JButton craeteColour;  //declare button
    private final JButton deleteItem;  //declare button
    private final JButton DeleteColour;  //declare button
    private final JButton Exit;  //declare button


    public WhatDo(String typeOfUser){
        JLabel label = new JLabel("Wybierz co chcesz zrobic");  //create Label

        add(label); // add Label to WhatDo

        seeAllItems = new JButton("Zobacz wszystkie Itemy");    //initialization button
        seeAllColours = new JButton("Zobacz wszystkie Kolory");    //initialization button
        createItem = new JButton("dodac Item");    //initialization button
        craeteColour = new JButton("dodac Kolor");    //initialization button
        deleteItem = new JButton("usun Item");    //initialization button
        DeleteColour = new JButton("usun Kolor");    //initialization button
        Exit = new JButton("Wyjdz");    //initialization button

        seeAllItems.addActionListener(this);    //add listing to button
        seeAllColours.addActionListener(this);    //add listing to button
        createItem.addActionListener(this);    //add listing to button
        craeteColour.addActionListener(this);    //add listing to button
        deleteItem.addActionListener(this);    //add listing to button
        DeleteColour.addActionListener(this);    //add listing to button
        Exit.addActionListener(this);    //add listing to button

        if(typeOfUser.equals("User")){
            add(seeAllItems);   //add Button
            add(seeAllColours);   //add Button
            add(Exit);   //add Button
            setLayout(new GridLayout(4,1)); //set Layout
        } else if (typeOfUser.equals("Admin")){
            add(seeAllItems);   //add Button
            add(seeAllColours);   //add Button
            add(createItem);   //add Button
            add(craeteColour);   //add Button
            add(deleteItem);   //add Button
            add(DeleteColour);   //add Button
            add(Exit);   //add Button
            setLayout(new GridLayout(8,1)); //set Layout
        }else if (typeOfUser.equals("Root")){
            add(seeAllItems);   //add Button
            add(seeAllColours);   //add Button
            add(createItem);   //add Button
            add(craeteColour);   //add Button
            add(deleteItem);   //add Button
            add(DeleteColour);   //add Button
            add(Exit);   //add Button
            setLayout(new GridLayout(8,1)); //set Layout
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //crete object from source

        if(source == seeAllItems) { //if source equal seeAllItems
            Action.seeAllItem();    //go to seeAllItem
        } else if(source == seeAllColours) { //if source equal seeAllColours
            Action.seeAllColours(); //go to seeAllColours
        } else if(source == createItem) { //if source equal createItem
            Action.view = new View("CreateItem");   //create view CreateItem
        } else if(source == craeteColour){ //if source equal createColour
            Action.view = new View("CreateColour"); //create view Create Colour
        } else if (source == deleteItem) { //if source equal deleteItem
            Action.view = new View("DeleteItem");
        } else if (source == DeleteColour) { //if source equal DeleteColour
            Action.view = new View("DeleteColour");
        } else {
            System.exit(0); //exit with status
        }
    }
}
