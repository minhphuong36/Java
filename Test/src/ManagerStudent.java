import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
   static Scanner sc = new Scanner(System.in);
   public static List<Student> students = new ArrayList<>();

    public static void writeToFileStudent(List<Student> students) {
        try {
            FileWriter fw = new FileWriter("student.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student o : students) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (Exception e) {

        }
    }

    public static List<Student> readFromFileStudent() {
        try {
            FileReader fr = new FileReader("student.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String id = txt[0];
                String name = txt[1];
                int age = Integer.parseInt(txt[2]);
                String gender = txt[3];
                String address = txt[4];
                float mediumScore = Float.parseFloat(txt[5]);

                students.add(new Student(id, name, age, gender, address, mediumScore));

            }
        } catch (Exception e) {
        }
        return students;
    }
    public static void showStudent(){
        System.out.printf("%-25s%-15s%-25s%-15s%-15s%-15s%-15s\n","","id","Name","Age","Gender","Address","MediumScore");
        for (int i = 0; i < students.size(); i++) {
            Student p = students.get(i);
            System.out.printf("%-25s%-15s%-25s%-15d%-15s%-15s%-15f\n","",p.getId(),p.getFullName(),p.getAge(),p.getGender(),p.getAddress(),p.getMediumScore());
        }
    }

    public void addStudent(Student student) {
        students.add(student);

    }
    public Student createStudent(){
        String id = "";
        do{
            System.out.print("Input id: ");
            String id1 = sc.nextLine();
            try{
                int index = findIndexById(id1);
                if(index == -1){
                    id = id1;
                    break;
                }else {
                    System.out.println("Id was exist");
                }

            }catch (Exception e){
                System.out.println("Input again");
            }

        }while (true);




        System.out.print("Input fullname: ");
        String fullName = sc.nextLine();


        int age;
        do {
            try{
                System.out.print("Input age: ");
                age = Integer.parseInt(sc.nextLine());
                if (age <= 120 && age >0){
                    break;
                }else {
                    System.out.println("Age is from 1 to 120");
                }
            }catch (Exception e){
                System.out.println("Input age is not regular");
            }

        }while (true);


        System.out.print("Input gender: ");
        String gender = sc.nextLine();

        System.out.print("Input address: ");
        String address = sc.nextLine();


        float mediumScore;
        do{
            try{
                System.out.print("Input mediumscore: ");
                mediumScore = Float.parseFloat(sc.nextLine());
                if(mediumScore <= 10 && mediumScore >= 0){
                    break;
                }else {
                    System.out.println("Mediumscore is from 0 to 10");
                }

            }catch (Exception e){
                System.out.println("The mediumscore is not regular!");

            }


        }while (true);

        return new Student(id,fullName,age,gender,address,mediumScore);

    }

    public int findIndexById(String id){
        for (int i = 0; i < students.size(); i++) {
            if(id.equals(students.get(i).getId())){
                return i;
            }
        }
        return -1;
    }

    public void deleteStudent(String id){
        int index = findIndexById(id);
        if(index != -1){
            students.remove(index);
        }else {
            System.out.println("Id không tồn tại");
        }

    }
    public void editStudent(String id){
        int index = findIndexById(id);
        if( index != -1){
            students.set(index,createStudent());
        }else {
            System.out.println("Id không tồn tại");
        }
    }




}
