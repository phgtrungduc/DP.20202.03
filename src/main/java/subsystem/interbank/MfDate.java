package subsystem.interbank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MfDate extends Date {
    public String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
