package hello.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyDateFormatterTest {


    MyDateFormatter formatter  = new MyDateFormatter("2024-02-26");

    @Test
    void parse() throws ParseException {
        Date result = formatter.parse("2024-02-26", Locale.KOREA);
        System.out.println(result);
//        assertThat(result).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result = formatter.print(new Date(), Locale.KOREA);
        System.out.println(result);

//        assertThat(result).isEqualTo("1,000");
    }

}