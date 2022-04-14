package LocaleDateTime;

import LocaleDateTime.Custom1;
import LocaleDateTime.CustomConverter1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Main1 {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
    
        builder.registerTypeAdapter(Custom1.class, new CustomConverter1());
        Gson gson = builder.create();
    
        
        Custom1 custom1 = new Custom1(LocalDateTime.of(2022, 4, 13, 15, 20), new BigInteger("5620"));
        System.out.println(custom1);
        System.out.println(gson.toJson(custom1));
        
        String dateJson = "{\"date\":\"2022.04.13_15:20\",\"bigInteger\":\"5620\"}";
        
        Custom1 customFromJson = gson.fromJson(dateJson, Custom1.class);
        System.out.println(customFromJson);
        Custom1 custom2 = new Custom1(null, new BigInteger("565"));
        System.out.println("optional = " + custom2);
        System.out.println("gson optional.empty = " + gson.toJson(custom2));
        
        String customFromJsonOptional = "{\"date\":\"\",\"bigInteger\":\"565\"}";
        Custom1 custom3 = gson.fromJson(customFromJsonOptional, Custom1.class);
        System.out.println(custom3);
        
    }
}
