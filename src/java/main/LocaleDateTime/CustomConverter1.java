package LocaleDateTime;

import LocaleDateTime.Custom1;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomConverter1 implements JsonSerializer<Custom1>, JsonDeserializer<Custom1> {
    public final static String PATTERN = "yyyy.MM.dd_HH:mm";
    
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    
    public JsonElement serialize(Custom1 src, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        String dateFromPattern = "";
        if (src.dateTime != null) {
            dateFromPattern = src.dateTime.format(formatter);
        }
        /*String dateS = src.date.getYear() + "." + src.date.getMonth().getValue() + "." +src.date.getDayOfMonth()
                + "_" + src.date.getHour() + ":" + src.date.getMinute();*/
        object.addProperty("date", dateFromPattern);
        object.addProperty("bigInteger", src.integer.toString());
        return object;
    }
    
    public Custom1 deserialize(JsonElement json, Type type,
                               JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        String dateStr = object.get("date").getAsString();
        LocalDateTime resultDate = null;
        if (!dateStr.isEmpty()) {
            resultDate = LocalDateTime.parse(dateStr, formatter);
        }
        BigInteger integer = new BigInteger(object.get("bigInteger").getAsString());
        return new Custom1(resultDate, integer);
    }
}