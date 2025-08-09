import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Course> courses = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.trim().split(":")).toList();
            boolean isCoursePresent = courses.containsKey(data.get(0));
            Course course;
            if (!isCoursePresent) {
                course = new Course();
            } else {
                course = courses.get(data.get(0));
            }
            course.setStudents(data.get(1));
            courses.put(data.get(0), course);
            input = sc.nextLine();
        }
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            System.out.println(entry.getKey().trim() + ": " + entry.getValue().getStudents().size());
            for (int i = 0; i < entry.getValue().getStudents().size(); i++) {
                System.out.println("--" + entry.getValue().getStudents().get(i));
            }
        }
    }

    public static class Course {
        private List<String> students = new ArrayList<>();

        public void setStudents(String student) {
            students.add(student);
        }

        public List<String> getStudents() {
            return students;
        }
    }
}
