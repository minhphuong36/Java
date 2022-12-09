public class NhanVien {
    private String name;
    private int age;
    private String gender;
    private Double salary;
    private String birthday;
    private int id;
    private static int idTemp = 1;


    public NhanVien(){

    }


    public NhanVien(String name, int age, String gender, double salary, String birthday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.birthday = birthday;
        this.id = idTemp++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = idTemp++;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", birthday='" + birthday + '\'' +
                ", id=" + id +
                '}';
    }
}
