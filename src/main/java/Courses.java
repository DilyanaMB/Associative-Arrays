import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Course, String> courses = new LinkedHashMap<>();
        String input = sc.nextLine();
        while(!input.equals("end")){
            List<String> data = Arrays.stream(input.split(":")).toList();

            input = sc.nextLine();
        }

    }

    public static class Course {
        private String name;
        private List<String> students = new ArrayList<>();

        public Course(String name, String student) {
            this.name = name;
            students.add(student);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStudents(String student) {
            students.add(student);
        }

        public String getName() {
            return name;
        }

        public List<String> getStudents() {
            return students;
        }
    }
}
