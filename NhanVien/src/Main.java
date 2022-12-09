import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();

        while (true) {
            System.out.println("Quan ly nhân viên");
            System.out.println("1.Thêm nhân viên ");
            System.out.println("2.Sửa nhân viên theo id");
            System.out.println("3.Xoa nhân vien theo id");
            System.out.println("4.Hiển thị nhân viên");
            System.out.println("5.Tìm 3 nhân viên lương cao nhất");
            System.out.println("6.Tìm kiếm nhân viên theo tên");
            System.out.println("7.Hiển thị những nhân viên có sinh nhật theo tháng");
            System.out.println("8.Thoát khỏi chương trình");
            int choice;

            do {
                try {
                    System.out.print("Mời nhập lựa chọn: ");
                    do {
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice < 1 && choice > 8) {
                            System.out.println("Vui lòng nhập lại!");
                        } else {
                            break;
                        }
                    } while (true);
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số!");
                }
            }while (true);

            switch (choice) {
                case 1:
                    NhanVien nhanVien = manager.createNhanVien();
                    manager.add(nhanVien);
                    break;
                case 2:
                    System.out.println("Nhập id  muốn sửa");
                    int id = Integer.parseInt(sc.nextLine());
                    manager.edit(id);
                    break;
                case 3:
                    System.out.println("Nhập id muốn xóa");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    manager.delete(idDelete);
                    break;
                case 4:
                    manager.show();
                    break;

                case 5:
                    System.out.println("Top 3 nhân viên lương cao nhất:");
                    Collections.sort(Manager.nhanViens, new SapXepTheoLuong());
                    System.out.println("Top 1: " +Manager.nhanViens.get(0).toString());
                    System.out.println("Top 2: " +Manager.nhanViens.get(1).toString());
                    System.out.println("Top 3: " +Manager.nhanViens.get(2).toString());
                    break;
                case 6:
                    System.out.println("Nhập tên nhân viên cần tim");
                    String name = sc.nextLine();
                    System.out.println("Thông tin nhân viên:");
                    manager.showByName(name);
                    break;
                case 7:
                    System.out.println("Nhập tháng");
                    String month = sc.nextLine();
                    List<NhanVien> nvsnmonth = manager.nhanVienSinhNhatTheoThang(month,Manager.nhanViens);
                    System.out.println("Nhan viên có sinh nhật tháng " + month + " là:");
                    manager.showBirthday(nvsnmonth);
                    break;
                case 8:
                    System.exit(0);
                    break;


            }
        }
    }
}
