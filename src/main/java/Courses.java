import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Course> courses = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(":")).toList();
            boolean isCoursePresent=courses.containsKey(data.get(0));
            if(!isCoursePresent){

            }else{
                Course currentCourse = courses.get(data.get(0));
                currentCourse.setStudents(data.get(1));
                courses.put(data.get(0),currentCourse);
            }
            input = sc.nextLine();
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
