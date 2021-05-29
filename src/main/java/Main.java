import CreateCallLog.CallLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static CreateCallLog.CallLogFactoryClass.create;

public class Main {
    private static final int DEFAULT_COUNT = 5;

    public static void main(String[] args) {
        int count = DEFAULT_COUNT;
        if (args.length > 0) {
            try {
                count = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignore) {
                System.err.println("Wrong usage");
            }
        }
        System.out.println(count);

//        Create project using Gradle as build system
//        Connect the library “org.apache.commons: commons-collections4” to the project. Use 2-3 classes from this library, for example BidiMap.
//        Connect the “com.google.code.gson: gson” library to the project. Use it to convert CallLog instances to JSON and back.
//        Create a JAR archive and demonstrate its execution from the command line.
//        Implement a method for creating an instance of CallLog with random data.
//        Create a Collection <CallLog> and fill it with random instances up to a specific size, passed as the only command line argument. Handle missing arguments with a default value.
//        Using gson, convert the generated Collection <CallLog> to JSON and back.

        BidiMap<Integer, String> bidiMap = new DualHashBidiMap<>();
        bidiMap.put(1, "Tom");
        bidiMap.put(2, "Chelsy");
        bidiMap.put(3, "Harry");
        bidiMap.put(4, "Nils");
        bidiMap.put(5, "David");
        bidiMap.put(6, "Carrol");
//        assertEquals(bidiMap.size(), 6);
        System.out.println(bidiMap.getKey("Harry"));
        BidiMap<String, Integer> inverseBidiMap = bidiMap.inverseBidiMap();
//        assertTrue(inverseBidiMap.containsKey("Chelsy") && inverseBidiMap.containsKey("David"));
        System.out.println(inverseBidiMap.getKey(4));


        List<String> stringList = Arrays.asList("1", "2", "3");
        List<Integer> integerList = (List<Integer>) CollectionUtils.collect(
                stringList, new Transformer<String, Integer>() {
                    @Override
                    public Integer transform(String input) {
                        return Integer.parseInt(input);
                    }
                });
        int test = integerList.get(0) + integerList.get(1);
        System.out.println(integerList + " " + test);


        Collection<CallLog> callLogs = Arrays.asList(
                new CallLog("+380985869432", 0, 10, CallLog.Status.Incoming),
                new CallLog("+380985869432", 0, 0, CallLog.Status.Missed),
                new CallLog("+380985869432", 0, 36, CallLog.Status.Outgoing),
                new CallLog("+380987676788", 0, 232, CallLog.Status.Incoming),
                new CallLog("+380987676788", 0, 34, CallLog.Status.Incoming),
                new CallLog("+08005675675676", 0, 45, CallLog.Status.Outgoing),
                new CallLog("+380987676788", 0, 234, CallLog.Status.Outgoing),
                new CallLog("+380978654675", 0, 166, CallLog.Status.Incoming));


        Gson gson = new Gson();
        String json = null;
        for (CallLog callLog : callLogs) {
            json = gson.toJson(callLog);
            System.out.println(json);
            CallLog callLog1 = gson.fromJson(json, CallLog.class);
            System.out.println("phoneNumber : " + callLog1.phoneNumber);
        }

        String jsonToArray = gson.toJson(callLogs);
        Type collectionType = new TypeToken<Collection<CallLog>>() {
        }.getType();
        Collection<CallLog> callLogs1 = gson.fromJson(jsonToArray, collectionType);
        System.out.println(callLogs1.size());


        CallLog callLog2 = new CallLog("+380985869432", 0, 10, CallLog.Status.Incoming);
        Gson gson1 = new Gson();
        String json1 = gson1.toJson(callLog2);
        System.out.println(json1 + "----------------------------------------");

        CallLog callLog3 = gson1.fromJson(json1, CallLog.class);
        System.out.println("phoneNumber : " + callLog3.phoneNumber + "___________________________");

        CallLog callLogNew = create();
        System.out.println(callLogNew.phoneNumber + ", " + callLogNew.timestamp + ", " + callLogNew.duration + ", " + callLogNew.status);


        Collection<CallLog> argCallLog = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            argCallLog.add(create());
        }
        for (CallLog callLog : argCallLog) {
            System.out.println(callLog.phoneNumber + " " + callLog.duration + " " + callLog.timestamp + " " + callLog.status);
        }
    }
}