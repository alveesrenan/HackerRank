import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

enum EventType {
    ENTER, SERVED;
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public static Student builder() {
        return new Student();
    }

    public Student id(int id) {
        this.id = id;
        return this;
    }

    public Student name(String name) {
        this.name = name;
        return this;
    }

    public Student cgpa(double cgpa) {
        this.cgpa = cgpa;
        return this;
    }

    public Student build() {
        return this;
    }
}

interface Priority {
    List<Student> getStudents(List<String> events);

    default Student buildStudentByPriority(String event) {
        String[] line = event.split(" ");
        return Student.builder()
                .id(Integer.parseInt(line[3]))
                .cgpa(Double.parseDouble(line[2]))
                .name(line[1])
                .build();
    }
}

class Priorities implements Priority {

    private Queue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId)
    );

    @Override
    public List<Student> getStudents(List<String> events) {
        events.forEach(event -> {
            if (event.contains(EventType.ENTER.name())) {
                queue.add(buildStudentByPriority(event));
                return;
            }
            queue.poll();
        });

        int size = queue.size();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            students.add(queue.poll());
        }
        return students;
    }
}

