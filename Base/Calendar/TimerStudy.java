package Base.Calendar;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerStudy extends TimerTask {
    public static void main(String[] args) {
        Timer t = new Timer();

        t.scheduleAtFixedRate(new TimerStudy(), 0, TimeUnit.SECONDS.toMillis(3));
    }

    @Override
    public void run() {
        System.out.println("lalalala");
    }
}
