import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Tom","Morison", 19,3,11.3);
        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println(json);

        Student student1 = gson.fromJson(json,Student.class);
        System.out.println("name : " + student1.name);
    }
}
