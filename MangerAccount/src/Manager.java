import java.util.Date;
import java.util.Scanner;

public class Manager {
    Account[] accounts = new Account[0];
    Scanner scanner = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].toString());

        }
    }

    public void add(Account account) {
        Account[] newArr = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++) {
            newArr[i] = accounts[i];
        }
        newArr[newArr.length - 1] = account;
        accounts = newArr;

    }

    public Account createAccount() {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập userName");
        String userName = scanner.nextLine();
        System.out.println("Nhập passWord");
        String passWord = scanner.nextLine();
        System.out.println("Nhập só phone");
        String phone = scanner.nextLine();
        System.out.println("Nhập BirthDay");
        String birthDay = scanner.nextLine();

        return new Account(id, userName, passWord, phone, birthDay);
    }

    public int findIndexByUserName(String userName) {
        for (int i = 0; i < accounts.length; i++) {
            if (userName.equals(accounts[i].getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public void edit(String userName) {
        int index = findIndexByUserName(userName);
        if (index != -1) {
            System.out.println("Nhập password mới");
            accounts[index].setPassWord(scanner.nextLine());
        }
    }

    public void delete(String userName) {
        int index = findIndexByUserName(userName);
        if(index != -1){
            Account[] newArr = new Account[accounts.length - 1];
            int j = 0;
            for (int i = 0; i < accounts.length; i++) {
                if (index != i) {
                    newArr[j] = accounts[i];
                    j++;

                }
            }
            accounts = newArr;
        }
    }


    public void findAccount(String nameFind) {
        int index = findIndexByUserName(nameFind);
        if (index != -1) {
            System.out.println("Account muốn tim là:");
            for (int i = 0; i < accounts.length; i++) {
                if(index == i){
                    System.out.println(accounts[i].toString());
                }
            }
        }
    }
}
