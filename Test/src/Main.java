import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ManagerStudent managerStudent = new ManagerStudent();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            int choice;
            do {
                try {
                    System.out.print("Enter number from 1 to 8! ");
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Enter the number, please!");
                }

            } while (true);
            switch (choice) {
                case 1:
                    managerStudent.showStudent();
                    break;
                case 2:
                    Student student = managerStudent.createStudent();
                    managerStudent.addStudent(student);
                    break;
                case 3:
                    System.out.println("Input id");
                    String id = sc.nextLine();
                    managerStudent.editStudent(id);
                    break;
                case 4:
                    System.out.println("Input id");
                    String idDelete = sc.nextLine();
                    managerStudent.deleteStudent(idDelete);
                    break;
                case 5:
                    while (true) {
                        System.out.println("SẮP XẾP SINH VIÊN THEO ĐIỂM TRUNG BÌNH");
                        System.out.println("1. Sắp xếp sinh viên theo diểm tăng dần");
                        System.out.println("2. Sắp xếp sinh viên theo diểm giảm dần");
                        System.out.println("3. Thoát");
                        int choicechoice;
                        do {
                            try {
                                System.out.print("Enter number from 1 to 3! ");
                                choicechoice = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (InputMismatchException | NumberFormatException e) {
                                System.out.println("Enter the number, please!");
                            }
                        } while (true);
                        switch (choicechoice) {
                            case 1:
                                Collections.sort(ManagerStudent.students,new SortUpMediumScore());
                                ManagerStudent.showStudent();
                                break;
                            case 2:
                                Collections.sort(ManagerStudent.students,new SortDownMediumScore());
                                ManagerStudent.showStudent();
                                break;
                            case 3:
                                return;
                        }
                        break;

                    }
                    break;
                case 6:
                    ManagerStudent.readFromFileStudent();
                    break;
                case 7:
                    ManagerStudent.writeToFileStudent(ManagerStudent.students);
                    break;
                case 8:
                    System.exit(0);
                    break;


            }


        }
    }
}
