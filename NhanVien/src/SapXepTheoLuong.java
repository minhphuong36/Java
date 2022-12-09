import java.util.Comparator;

public class SapXepTheoLuong implements Comparator<NhanVien> {


    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }


    
}
