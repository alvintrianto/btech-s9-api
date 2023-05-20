package data.kasirAja;

import org.json.simple.JSONObject;

import java.util.Random;

public class login {
    public static JSONObject loginData(){
        JSONObject data = new JSONObject();
        data.put("email","sample@ex.com");
        data.put("password","123adsfadf@");
        return data;
    }
}
