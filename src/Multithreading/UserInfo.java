package Multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfo {
    private static Date dob = null;
    public static void main (String[] args)
    {
        dob = new Date("2024/04/01");
        System.out.println(dateOfBirth());
    }

    public static String dateOfBirth()
    {
        Date date = dob;
        final SimpleDateFormat df = ThreadSafeFormater.dateFormater.get();
        return df.format(date);
    }
}

class ThreadSafeFormater {
    public static ThreadLocal<SimpleDateFormat> dateFormater = ThreadLocal.withInitial(() -> new SimpleDateFormat(
            "yyyy-MM-dd"));
}
