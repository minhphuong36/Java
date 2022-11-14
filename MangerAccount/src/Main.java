import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Quản lý Account");
            System.out.println("1. Hiển thị Account");
            System.out.println("2. Thêm acc mới");
            System.out.println("3. Sửa passWord theo userName");
            System.out.println("4. Xóa acc theo userName");
            System.out.println("5. Tìm acc theo userName");
            System.out.println("6. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.show();
                    break;
                case 2:
                    Account newacc = manager.createAccount();
                    manager.add(newacc);
                    break;
                case 3:
                    System.out.println("Nhập tên muốn sửa password");
                    String nameEdit = scanner.nextLine();
                    manager.edit(nameEdit);
                    break;
                case 4:
                    System.out.println("Nhập tên muốn xóa");
                    String nameDelete = scanner.nextLine();
                    manager.delete(nameDelete);
                    break;
                case 5:
                    System.out.println("Nhập tên muốn tìm acc");
                    String nameFind = scanner.nextLine();
                    manager.findAccount(nameFind);
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }

    }
}
