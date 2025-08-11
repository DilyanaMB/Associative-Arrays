import java.util.*;
import java.util.stream.Collectors;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentsCount = Integer.parseInt(sc.nextLine());
        Map<String, Student> students = new LinkedHashMap<>();
        while (studentsCount > 0) {
            studentsCount--;
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());
            boolean isStudentExist = students.containsKey(name);
            Student student = null;
            if (!isStudentExist) {
                student = new Student(name, grade);
                students.put(name, student);
            } else {
                student = students.get(name);  // retrieve existing
                student.setGrades(grade);
            }
        }

        LinkedHashMap<String, Student> filteredStudents = students.entrySet()
                .stream().filter(s -> s.getValue().getGrades()
                        .stream().mapToDouble(Double::doubleValue).average().orElse(0.0) >= 4.5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s1, LinkedHashMap::new));

        filteredStudents.forEach((name, student) ->
        {
            double avg = student.getGrades().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().orElse(0.0);
            System.out.printf("%s -> %.2f%n", name, avg);
        });
    }

    public static class Student {
        private List<Double> grades = new ArrayList<>();

        public Student(String name, double grade) {
            grades.add(grade);
        }

        public void setGrades(double grade) {
            grades.add(grade);
        }

        public List<Double> getGrades() {
            return grades;
        }
    }
}