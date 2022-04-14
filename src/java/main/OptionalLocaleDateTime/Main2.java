package OptionalLocaleDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
    
        builder.registerTypeAdapter(Custom2.class, new CustomConverter2());
        Gson gson = builder.create();
    
        
        Custom2 custom2 = new Custom2(Optional.of(LocalDateTime.of(2022, 4, 13, 15, 20)), new BigInteger("5620"));
        System.out.println(custom2);
        System.out.println(gson.toJson(custom2));
        
        String dateJson = "{\"date\":\"2022.04.13_15:20\",\"bigInteger\":\"5620\"}";
        
        Custom2 customFromJson = gson.fromJson(dateJson, Custom2.class);
        System.out.println(customFromJson);
        Custom2 custom3 = new Custom2(Optional.empty(), new BigInteger("565"));
        System.out.println("optional = " + custom2);
        System.out.println("gson optional.empty = " + gson.toJson(custom3));
        
        String customFromJsonOptional = "{\"date\":\"\",\"bigInteger\":\"565\"}";
        Custom2 custom4 = gson.fromJson(customFromJsonOptional, Custom2.class);
        System.out.println(custom4);
        
    }
}
