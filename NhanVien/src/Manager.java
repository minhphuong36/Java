import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Manager {
    public static ArrayList<NhanVien> nhanViens = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < nhanViens.size(); i++) {
            System.out.println(nhanViens.get(i).toString());

        }
    }

    public void add(NhanVien nhanVien) {
        nhanViens.add(nhanVien);
    }

    public NhanVien createNhanVien() {
        String name;
        do {
            System.out.println("Nhập tên nhân viên");
            name = sc.nextLine();
            boolean flag = false;
            for (NhanVien a : nhanViens) {
                if (a.getName().equals(name)) {
                    System.out.println("Tên nhân viên đã tồn tại");
                    flag = true;

                }
            }
            if (!flag) {
                break;
            }
        } while (true);


        int age;
        do {
            try {
                System.out.print("Nhập tuổi nhân vien: ");
                do {
                    age = Integer.parseInt(sc.nextLine());
                    if (age < 0) {
                        System.out.println("Tuổi phải là số dương!");
                    } else {
                        break;
                    }
                } while (true);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số!");
            }
        } while (true);

        System.out.println("Nhập giới tính nhân viên");
        String gender = sc.nextLine();

        double salary;
        do {
            try {
                System.out.print("Nhập lương: ");
                do {
                    salary = Double.parseDouble(sc.nextLine());
                    if (salary < 0) {
                        System.out.println("Lương phải là số dương!");
                    } else {
                        break;
                    }
                } while (true);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số!");
            }
        } while (true);


        System.out.println("Nhập ngày sinh nhân viên");
        String birthday = sc.nextLine();

        return new NhanVien(name, age, gender, salary, birthday);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (id == nhanViens.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            nhanViens.remove(index);
        }
    }

    public void edit(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            nhanViens.set(index, createNhanVien());

        }
    }

    public int findIndexByName(String name){
        for (int i = 0; i < nhanViens.size(); i++) {
            if (name.equals(nhanViens.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public void showByName(String name){
        int index = findIndexByName(name);
        if(0 <= index && index < nhanViens.size()){
            System.out.println(nhanViens.get(index).toString());
        } else {
            System.out.println("không timg thấy");
        }

    }

    public List<NhanVien> nhanVienSinhNhatTheoThang(String thang, List<NhanVien> nhanViens){
        List<NhanVien> nvSinhNhat = new ArrayList<>();
        for(NhanVien nv : nhanViens){
            String snThang = nv.getBirthday().split("/")[1];
            if(thang.equals(snThang)){
                nvSinhNhat.add(nv);
            }
        }
        return nvSinhNhat;
    }

    public void showBirthday(List<NhanVien> nhanVien){
        for (NhanVien nvMonth: nhanVien) {
            System.out.println(nvMonth.toString());
        }
    }


}
