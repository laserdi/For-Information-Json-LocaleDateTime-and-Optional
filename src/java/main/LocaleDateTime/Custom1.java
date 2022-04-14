package LocaleDateTime;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Custom1 {
    LocalDateTime dateTime;
    BigInteger integer;
    public Custom1(LocalDateTime date, BigInteger integer) {
        this.dateTime = date;
        this.integer = integer;
    }
    
    @Override
    public String toString() {
        if (dateTime != null) {
            return "date = " + dateTime.format(CustomConverter1.formatter) + " integer = " + integer;
        }
        return "date = " + " integer = " + integer;
    }
}