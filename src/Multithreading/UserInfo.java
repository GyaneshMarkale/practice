package Multithreading;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class ThreadSafeFormater {
    public static ThreadLocal<SimpleDateFormat> dateFormater = ThreadLocal.withInitial(() -> new SimpleDateFormat(
            "yyyy-MM-dd"));
}
