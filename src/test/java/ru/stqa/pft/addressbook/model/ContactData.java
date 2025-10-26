package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public final class ContactData {
    private  String firstname;
    private  String lastname;
    private  String mobile;
    private  String email;
    private  String group;

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }




    @Override
    public String toString() {
        return "ContactData{" +
                " firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }


    public String firstname() {
        return firstname;
    }

    public String lastname() {
        return lastname;
    }

    public String mobile() {
        return mobile;
    }

    public String email() {
        return email;
    }

    public String group() {
        return group;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData
                ) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

}