package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import java.io.ObjectInputStream;

public class ApiManager {
    public String getMathApi (String category){
        try {
            GetRequest getRequest = Unirest.get("http://numberapi.com/random/" + category);//קבלת מידע לפי ה-GET
            HttpResponse<String> response = getRequest.asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }


    public String getTextByApi(String category) { // פונקציה שמקבלת את המחרוזת כדי לענות על השאלה שיש ב-PANEL
        try {
            GetRequest getRequset = Unirest.get("https://v2.jokeapi.dev/joke/" + category + "?format=txt"); // משיכת URL- בקשת API
            HttpResponse<String> response = getRequset.asString();// לוקחים את התגובה לתוך האובייקט של httpRespones
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        //return "test"; //לאחר לחיצה על click me יוצג ה-test
    }

   /* public String getFactApi() {
        try {
            GetRequest getRequset = Unirest.get("https://catfact.ninja/fact");
            HttpResponse<String> response = getRequset.asString();
            String json = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();  //למפות את הדייסון שקיבלנו לתוך המחלקה של CATFACT2
            CatFact2 catFact2 = objectMapper.readValue(json, CatFact2.class);
            return catFact2.getFact();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    */
}


