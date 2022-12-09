import java.util.Comparator;

public class SortDownMediumScore implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o2.getMediumScore()>o1.getMediumScore()) return 1;
        else if (o2.getMediumScore()<o1.getMediumScore()) return -1;
        else return 0;
    }
}
