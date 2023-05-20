package data.createUser;

import org.json.simple.JSONObject;

import java.util.Random;

public class createUser {
    static Random rand = new Random();
    static String randomJob = String.valueOf(rand.nextInt(10000));

    public static JSONObject newUser(){
        JSONObject data = new JSONObject();
        data.put("name","morpheus");
        data.put("job",randomJob);
        return data;
    }
}
