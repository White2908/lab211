package model;

public class Student {
    private String studentID;
    private String name;
    private String number;
    private String email;
    private String mountainCode;
    private double tuitionFee = 6000000;

    public Student() {
    }

    public Student(String studentID, String name, String number, String email, String mountainCode, double tuitionFee) {
        this.studentID = studentID;
        this.name = name;
        this.number = number;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        return studentID + " | " + name + " | " + number + " | " + mountainCode + " | " + tuitionFee + "\n";
    }

}
