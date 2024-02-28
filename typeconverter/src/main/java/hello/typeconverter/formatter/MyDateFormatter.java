package hello.typeconverter.formatter;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyDateFormatter implements Formatter<Date> {

    private String pattern;

    public MyDateFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        if (text.length() == 0) {
            return null;
        }
        return getDateFormat(locale).parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        if (date == null) {
            return "";
        }
        return getDateFormat(locale).format(date);
    }

    protected DateFormat getDateFormat(Locale locale) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}
