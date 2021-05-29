package CreateCallLog;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import static CreateCallLog.CallLog.Status;

public class CallLogFactoryClass {

    public static CallLog create() {
        int partOfNumber = ThreadLocalRandom.current().nextInt(1000000, 9999999);
        int numCode = ThreadLocalRandom.current().nextInt(38035, 38099);
        String s = String.valueOf(partOfNumber);
        String m = String.valueOf(numCode);
        long duration = ThreadLocalRandom.current().nextLong(0, 10000);
        Status status = Status.values()[new Random().nextInt(Status.values().length)];
        if(status.equals(Status.Missed)){
            duration=0;
        }
        return new CallLog("+" + m + s, 0,duration, status);
    }
}
