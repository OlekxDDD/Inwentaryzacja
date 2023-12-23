package org.example;

import javax.swing.*;   //import library
import java.awt.*;

public class View extends JFrame {
    View(String choice) {
        super("Inwetaryzacja skurczysynu"); //declare title (super)
        if(choice.equals("WhatDo")) {   //if WhatDo
            pack(); //use method pack
            JPanel WhatDo = new WhatDo();   //import JPanel What Do
            add(WhatDo);    //add What Do to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up position
        }else if(choice.equals("ViewIt")){  //if ViewIt
            pack(); //use method pack
            JPanel ViewIt = new ViewIt();   //import JPanel ViewIt
            add(ViewIt);    //add View It to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up position
        }else if(choice.equals("CreateItem")){    //if CreateItem
            pack(); //use method pack
            JPanel CreateItem = new CreateItem();   //import JPanel CreateItem
            add(CreateItem);    //add Create Item to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up corner
        }else if(choice.equals("CreateColour")){
            pack(); //use method pack
            JPanel CreateColour = new CreateColour();   //import JPanel CreateItem
            add(CreateColour);    //add Create Item to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up corner
        }else if(choice.equals("DeleteItem")){
            pack(); //use method pack
            JPanel DeleteItem = new DeleteItem();   //import JPanel CreateItem
            add(DeleteItem);    //add Create Item to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up corner
        } else if (choice.equals("DeleteColour")) {
            pack(); //use method pack
            JPanel DeleteColour = new DeleteColour();   //import JPanel CreateItem
            add(DeleteColour);    //add Create Item to this view
            setVisible(true);   //set visible true
            setBounds(200, 200, 500, 500); //set x,y,high and height
            setDefaultCloseOperation(0);    //don't close window on this red block in right up corner


        }
    }
}
