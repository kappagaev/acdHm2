public class Test
{
    public static void main(String[] args)
    {
        StudentCollection students = Request.askForStudents();

        System.out.println(students);
        System.out.println("Ascending by name " + students.sortByNameAscending());
        System.out.println("Ascending by grade " + students.sortByGradeAscending());
        System.out.println("Descending by name " + students.sortByNameDescending());
        System.out.println("Descending by grade " + students.sortByGradeDescending());
    }
}
