import java.io.IOException;

public class Request
{
    public static Student askForStudent() throws IOException {
        System.out.println("Student's name");
        String name = ua.com.glybovets.arrays.DataInput.getString();
        System.out.println("Student's grade");
        int grade = ua.com.glybovets.arrays.DataInput.getInt();

        return new Student(name, grade);
    }

    public static StudentCollection askForStudents()
    {
        Integer studentsCount = askForStudentsCount();
        StudentCollection students = new StudentCollection(studentsCount);
        for (int i = 0; i < studentsCount; i++) {
            try {
                students.addStudent(askForStudent());
            } catch (IOException e) {
                // e.something()
            }
        }
        return students;
    }

    private static Integer askForStudentsCount()
    {
        System.out.println("Students count");
        Integer count = ua.com.glybovets.arrays.DataInput.getInt();

        return count;
    }


}
