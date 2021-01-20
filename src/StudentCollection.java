public class StudentCollection
{
    private Student[] students;

    private int actualSize = 0;

    public StudentCollection(int size)
    {
        students = new Student[size];
    }

    public void addStudent(Student student)
    {
        students[actualSize++] = student;
    }

    public StudentCollection sortByName()
    {

        return this;
    }

    public StudentCollection sortByGrade()
    {

        return this;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Student student : students) {
            str.append(" ").append(student);
        }

        return str.toString();
    }
}
