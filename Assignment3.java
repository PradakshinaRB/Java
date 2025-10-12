import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateFormatExample {

    // Step 1: Create a ThreadLocal variable for thread-safe SimpleDateFormat
    private static final ThreadLocal<SimpleDateFormat> formatter =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    // Step 2: Method to format date
    public static String formatDate(Date date) {
        return formatter.get().format(date);
    }

    // Step 3: Method to parse date string
    public static Date parseDate(String dateStr) throws Exception {
        return formatter.get().parse(dateStr);
    }

    public static void main(String[] args) {

        // Step 4: Define a Runnable task that formats and parses date
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                String formatted = formatDate(new Date());
                System.out.println(threadName + " formatted: " + formatted);

                Date parsed = parseDate(formatted);
                System.out.println(threadName + " parsed: " + parsed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Step 5: Create and start multiple threads
        for (int i = 1; i <= 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
