public class Test
{
    public static void main(String[] args)
    {
        StudentCollection students = Request.askForStudents();

        System.out.println(students);
        System.out.println(students.sortByNameAscending());
        System.out.println(students.sortByGradeAscending());
        System.out.println(students.sortByNameDescending());
        System.out.println(students.sortByGradeDescending());
    }
}
