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

    /**
     * Sorts students by name in ascending order
     * @return
     */
    public StudentCollection sortByNameAscending() {
        sortByNameIn(0, actualSize - 1, true);
        return this;
    }

    /**
     * Sorts students by name in descending order
     * @return
     */
    public StudentCollection sortByNameDescending() {
        sortByNameIn(0, actualSize - 1, false);
        return this;
    }

    /**
     * Sorts students by grade in ascending order
     * @return
     */
    public StudentCollection sortByGradeAscending() {
        sortByGradeIn(0, actualSize - 1, true);
        return this;
    }

    /**
     * Sorts students by grade in descending order
     * @return
     */
    public StudentCollection sortByGradeDescending() {
        sortByGradeIn(0, actualSize - 1, false);
        return this;
    }

    /**
     * Sorts students array by name in a specific range
     *
     * @param fir       lowest index
     * @param las       highest index
     * @param ascending determines whether
     */
    private void sortByNameIn(int fir, int las, boolean ascending) {
        if (fir >= las)
            return;
        {
            int pivot = averageName(fir, (fir + las) / 2, las);
            swap(las, pivot);
        }
        int lef = fir, rig = las - 1;
        while (true) {
            while (lef < las && (!firstNameLower(students[las].name, students[lef].name) ^ !ascending))
                lef++;
            while (rig > fir && (firstNameLower(students[las].name, students[rig].name) ^ !ascending))
                rig--;
            if (rig <= lef)
                break;
            swap(lef, rig);
        }
        swap(lef, las);
        sortByNameIn(fir, lef - 1, ascending);
        sortByNameIn(lef + 1, las, ascending);
    }

    /**
     * Sorts students array by grade in a specific range
     *
     * @param fir       lowest index
     * @param las       highest index
     * @param ascending determines whether
     */
    private void sortByGradeIn(int fir, int las, boolean ascending) {
        if (fir >= las)
            return;
        {
            // finds the average value out of three and puts it at the end of array
            int pivot = averageGrade(fir, (las + fir) / 2, las);
            swap(las, pivot);
        }
        int lef = fir, rig = las - 1;

        // moves indexers to the other ends and swaps values that are out of order
        while (true) {
            while (lef < las && (students[lef].grade <= students[las].grade ^ !ascending))
                lef++;
            while (rig > fir && (students[rig].grade > students[las].grade ^ !ascending))
                rig--;
            if (rig <= lef)
                break;
            swap(lef, rig);
        }

        swap(lef, las);
        sortByGradeIn(fir, lef - 1, ascending);
        sortByGradeIn(lef + 1, las, ascending);
    }


    /**
     * Swaps objects in students array
     *
     * @param fir
     * @param sec
     */
    private void swap(int fir, int sec) {
        Student s = students[fir];
        students[fir] = students[sec];
        students[sec] = s;
    }

    /**
     * Finds out the index in which the average name is
     *
     * @param fir first index
     * @param sec second index
     * @param las third index
     * @return
     */
    private int averageName(int fir, int sec, int las) {
        if (!firstNameLower(students[fir].name, students[sec].name)) {
            int v = fir;
            fir = sec;
            sec = v;
        }
        if (!firstNameLower(students[sec].name, students[las].name)) {
            int v = sec;
            sec = las;
            las = v;
        }
        if (!firstNameLower(students[fir].name, students[sec].name))
            return fir;
        return sec;
    }

    /**
     * Finds out the index in which the average grade is
     *
     * @param fir first index
     * @param sec second index
     * @param las third index
     * @return
     */
    private int averageGrade(int fir, int sec, int las) {
        if (students[fir].grade >= students[sec].grade) {
            int v = fir;
            fir = sec;
            sec = v;
        }
        if (students[sec].grade >= students[las].grade) {
            int v = sec;
            sec = las;
            las = v;
        }
        if (students[fir].grade >= students[sec].grade)
            return fir;
        return sec;
    }

    // used because "і", "є" is out of order in unicode
    private static final String ORDER = " abcdefghijklmnopqrstuvwxyzабвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    /**
     * Checks whether first String is lower by character indexes
     *
     * @param first
     * @param second
     * @return true if first is lower, false if not
     */
    private boolean firstNameLower(String first, String second) {
        int smallest = Math.min(first.length(), second.length());
        for (int i = 0; i < smallest; i++) {
            int l = ORDER.indexOf(Character.toLowerCase(first.charAt(i)));
            int r = ORDER.indexOf(Character.toLowerCase(second.charAt(i)));
            if (l < r)
                return true;
            else if (l > r)
                return false;
        }
        return first.length() <= second.length();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Student student : students) {
            if (student == null)
                break;
            str.append(" ").append(student);
        }

        return str.toString();
    }
}
