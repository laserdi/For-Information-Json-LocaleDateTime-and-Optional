package OptionalLocaleDateTime;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public class Custom2 {
    Optional<LocalDateTime> dateTimeOptional;
    BigInteger integer;
    public Custom2(Optional<LocalDateTime> date, BigInteger integer) {
        this.dateTimeOptional = date;
        this.integer = integer;
    }
    
    @Override
    public String toString() {
        return dateTimeOptional.map(localDateTime -> "date = "
                + localDateTime.format(CustomConverter2.formatter) + " integer = " + integer)
                .orElseGet(() -> "date = " + " integer = " + integer);
    }
}