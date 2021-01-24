import ua.com.glybovets.arrays.DataInput;

import java.io.IOException;

public class Request {
    
    public static Student askForStudent() throws IOException {
        String name = DataInput.getString("Student's name, nothing to stop\n");
        if (name.equals(""))
            return new Student(null, 0);
        Double grade;
        while (true) {
            grade = DataInput.getDouble("Student's grade\n");
            if (grade <= 100 && grade >= 0)
                break;
            System.out.println("Grade is out of bounds");
        }
        return new Student(name, grade);
    }

    public static StudentCollection askForStudents() {
        Integer studentsCount;
        while (true) {
            studentsCount = askForStudentsCount();
            if(studentsCount > 0)
                break;
            System.out.println("Number is too low");
        }
        StudentCollection students = new StudentCollection(studentsCount);
        for (int i = 0; i < studentsCount; i++) {
            try {
                Student student = askForStudent();
                if (student.name == null)
                    break;
                students.addStudent(student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    private static Integer askForStudentsCount() {
        return DataInput.getInt("Students count\n");
    }


}
