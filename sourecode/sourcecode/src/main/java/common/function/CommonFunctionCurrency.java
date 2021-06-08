package common.function;

import java.text.NumberFormat;
import java.util.Locale;

public class CommonFunctionCurrency {
    public static String getCurrencyFormat(int num) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietnam);
        return defaultFormat.format(num);
    }
}
