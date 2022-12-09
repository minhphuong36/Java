public class Student {
    private String id;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private float mediumScore;

    public Student(){

    }
    public Student(String id, String fullName, int age, String gender, String address, float mediumScore) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return id + ";" + fullName + ";" + age +";"+ gender + ";" + address + ";" +  mediumScore ;
    }
}
