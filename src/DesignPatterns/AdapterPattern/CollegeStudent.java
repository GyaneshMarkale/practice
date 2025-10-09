package DesignPatterns.AdapterPattern;

public class CollegeStudent implements Student {

    private String firstname;
    private String Surname;
    private String address;

    public CollegeStudent(String firstname, String surname, String address) {
        this.firstname = firstname;
        Surname = surname;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstname='" + firstname + '\'' +
                ", Surname='" + Surname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
