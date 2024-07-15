package org.example;

import javax.swing.*;

public class Panel extends JPanel { //ציור על הפאנל לתת אותם מידות כמו החלון
    private JButton button; //שדה ללחצן
    public JButton button2;
    private String text; // מחרוזת של טקסט
    private JLabel result; // הצגת טקסט על ה-JFrame
    public ApiManager apiManager;  //public??
    private JButton[] jButtons;
    private JButton[] jButtonsCategory;



    public Panel(int x, int y, int width, int height) { // בנאי המכיל את המידות
        this.setBounds(x, y, width, height);// לתת לו את הערכים של המידות
        this.setLayout(null); // TODO
        this.apiManager = new ApiManager(); //אובייקט
        this.jButtons = new JButton[4]; // 4 כפתורים
        this.jButtonsCategory = new JButton[3];
        setOption();
        setButton(); // נזמן פונקציה בשביל הכפתור
        setLabel(); // נזמן פונקציה של הטקסט
        setButtonTwo();
        setJokeOption();


    }

    private void setButtonTwo() {
        this.button2 = new JButton("Math");
        this.button2.setBounds(20, 150, 100, 50); // ערכים של הכפתור השני ולא של הפאנל
        this.add(this.button2); //הוספת כפתור לפאנל
        this.button2.addActionListener(event -> {
            for (int i = 0; i < jButtons.length; i++) {
                this.jButtons[i].setVisible(true);
            }
            //this.text = apiManager.getMathApi("trivia");
            //this.result.setText(text);
        });
        this.setVisible(true); //ייצוג פעיל

    }

    private void setLabel() { // מיקום הטקסט
        this.result = new JLabel(); //משכנו את הטקסט של טקסט לפונציה
        this.result.setBounds(35, 70, 600, 50);// מיקום הטקסט
        this.add(this.result); // הוספת הטקסט לחלון
        this.result.setVisible(true);// לאפשר לראות את הטקסט
    }

    private void setButton() { // מיקום הכפתור
        this.button = new JButton("Click Me"); // מה יהיה כתוב על הלחצן
        this.button.setBounds(20, 20, 100, 50);// מיקום הלחצן חייב שהיה setLayout
        //this.button.setOpaque(false);// TODO // משהו על שקיפות
        this.add(this.button); //הוספת הלחצן? TODO
        this.setVisible(true);// ייצוג של לחצן פעיל
        this.button.addActionListener(event -> {   //  לראות את הבלוק, מאפשר לנו פעולה על הלחצן
            //System.out.print("check"); //בדיקה לאחר לחיצה על הלחצן לקבל פלט של ההדפסה
            //this.text= "Can you see me?"; //טקסט שנציג לאחר לחיצה על הכפתור
            //this.text = this.apiManager.getTextByApi("Pun"); // קריאה למתודה ב- ApiManager
            for (int i = 0; i < this.jButtons.length; i++) {
                this.jButtons[i].setVisible(true); //ברגע שלוחצים על click me הוא יציג את שאר הכפתורים שיש במערך,הטרויה, שנה וכו..

            }
            for (int i = 0; i < jButtonsCategory.length; i++) {
                this.jButtonsCategory[i].setVisible(true);

            }
            //this.result.setText(this.text); //הכנסת הטקסט ל-JLable


        }); // סוגרים עגולי
    }

    public void setOption() {
        String[] array = {"trivia", "year", "date", "math"}; //בחירת קטגוריות
        int x = 700, y = 100;
        for (int i = 0; i < array.length; i++) { // יצירת כפתור על כל מה שנתון במערך
            JButton jButton = new JButton(array[i]); // יוצר כפתור על מה שנמצא בכל המערך
            jButton.setBounds(x, y, 400, 50); // גודל ומיקום הכפתורים
            y += jButton.getHeight() + 10; //הוספת עוד לגובה
            this.add(jButton);
            jButton.setVisible(false); // במצב שקר כדי שרק שנלחץ על הכפתור הראשי הם יופיעו מה שבמערך
            this.jButtons[i] = jButton; //הוספנו את ה-4 כפתורים למערך של Button
            jButton.addActionListener(event -> {
                this.text = apiManager.getMathApi(jButton.getText());// שיוך קטגוריה לכל לחצן על ידי זימון הפונקציה של getMathApi
                this.result.setText(text);
            });
        }
    }













    private  void setJokeOption(){
        String [] category = {"programming", "Misc", "Dark"}; // שיוך שמות לכפתורים
        int x= 20, y= 700;
        for (int i = 0; i < category.length; i++) {
            JButton jButton = new JButton(category[i]); // יצירת כפתור
            jButton.setBounds(x,y,100, 30);// יצירת כפתור
            y+= jButton.getHeight() + 20; // יצירת כפתור
            this.add(jButton); // יצירת כפתור- הוספת הכפתור לפאנל
            jButton.setVisible(false); // יצירת כפתור
            this.jButtonsCategory[i] = jButton;
            jButton.addActionListener(event ->{
                this.text = this.apiManager.getMathApi(jButton.getText());
                this.result.setText(text);
            });




        }





    }

}

