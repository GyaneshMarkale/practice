package DesignPatterns.ObserverPattern.StoreNotification;

public class UserInfo {
    String firstName;
    String lastName;
    String phone;
    String EmailId;

    public UserInfo(String firstName, String lastName, String phone, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        EmailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", EmailId='" + EmailId + '\'' +
                '}';
    }
}
