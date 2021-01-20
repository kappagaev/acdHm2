public class Student
{
    public String name;

    public double grade;

    public Student(String name, double grade)
    {
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {

        return "Студент " + name + " з середнім балом " + grade;
    }
}
