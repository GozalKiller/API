package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // עושים @ ועושים את זה כדי לקבל מחלקה שתקבל את הגייסון, רוטציה

@JsonIgnoreProperties(ignoreUnknown = true) //לאפשר להחסיר את השדות
public class CatFact2 {
    private String fact;
    private String length;



    //public CatFact2(){ //בנאי
    //}
    public void setFact(String fact){
        this.fact= fact;
    }

    public String getFact(){
        return fact;
    }

    @Override
    public String toString() {
        return "CatFact2{" +
                "fact='" + fact + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
