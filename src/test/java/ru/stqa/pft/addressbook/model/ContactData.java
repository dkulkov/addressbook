package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public final class ContactData {
    private final String firstName;
    private final String lastName;
    private final String mobile;
    private final String email;
    private final String group;

    public ContactData(String lastName, String firstName,  String email, String mobile, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String firstName() {return firstName;}

    public String lastName() {return lastName;}

    public String mobile() {return mobile;}

    public String email() {return email;}

    public String group() {return group;}

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactData) obj;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.mobile, that.mobile) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobile, email, group);
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "mobile=" + mobile + ", " +
                "email=" + email + ", " +
                "group=" + group + ']';
    }

}