package OptionalLocaleDateTime;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CustomConverter2 implements JsonSerializer<Custom2>, JsonDeserializer<Custom2> {
    public final static String PATTERN = "yyyy.MM.dd_HH:mm";
    
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    
    public JsonElement serialize(Custom2 src, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        String dateFromPattern = "";
        if (src.dateTimeOptional.isPresent()) {
            dateFromPattern = src.dateTimeOptional.get().format(formatter);
        }
        /*String dateS = src.date.getYear() + "." + src.date.getMonth().getValue() + "." +src.date.getDayOfMonth()
                + "_" + src.date.getHour() + ":" + src.date.getMinute();*/
        object.addProperty("date", dateFromPattern);
        object.addProperty("bigInteger", src.integer.toString());
        return object;
    }
    
    public Custom2 deserialize(JsonElement json, Type type,
                               JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        String dateStr = object.get("date").getAsString();
        Optional<LocalDateTime> resultDate = Optional.empty();
        if (!dateStr.isEmpty()) {
            resultDate = Optional.of(LocalDateTime.parse(dateStr, formatter));
        }
        BigInteger integer = new BigInteger(object.get("bigInteger").getAsString());
        return new Custom2(resultDate, integer);
    }
}