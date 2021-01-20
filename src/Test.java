public class Test
{
    public static void main(String[] args)
    {
        StudentCollection students = Request.askForStudents();

        System.out.println(students);
        System.out.println(students.sortByName());
        System.out.println(students.sortByGrade());
    }
}
