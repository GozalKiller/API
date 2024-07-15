package org.example;

import javax.swing.*;

public class Window extends JFrame { // חלון חייב  לירוש מ-JFrame




    public Window(){ // בנאי
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// לאפשר את האיקס לסגירה
        this.setSize(1920, 1080); // גודל המסך
        this.setResizable(false);// TODO
        this.setLocationRelativeTo(null); // חלון יפתח במרכז המסך
        this.setVisible(true); // ייצוג חלון פעיל
        this.add(new Panel(0,0,1920,1080));
        this.setTitle("Test");// אפשרות לתת כותרת לחלון

    }
}
