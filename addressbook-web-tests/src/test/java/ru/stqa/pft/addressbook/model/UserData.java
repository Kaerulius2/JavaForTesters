package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData {


    private final int id;
    private final String firstname;
    private final String midname;
    private final String lastname;
    private final String address;
    private final String homephone;
    private final String email;
    private final String group;

    public UserData(String firstname, String midname, String lastname, String address, String homephone, String email, String group) {
        this.id = Integer.MAX_VALUE;;
        this.firstname = firstname;
        this.midname = midname;
        this.lastname = lastname;
        this.address = address;
        this.homephone = homephone;
        this.email = email;
        this.group = group;
    }

    public UserData(int id,String firstname, String midname, String lastname, String address, String homephone, String email, String group) {
        this.id=id;
        this.firstname = firstname;
        this.midname = midname;
        this.lastname = lastname;
        this.address = address;
        this.homephone = homephone;
        this.email = email;
        this.group = group;
    }

    public UserData(int id, String firstname, String lastname, String address) {
        this.id=id;
        this.firstname = firstname;
        this.midname = null;
        this.lastname = lastname;
        this.address = address;
        this.homephone = null;
        this.email = null;
        this.group = null;
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidname() {
        return midname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return  Objects.equals(firstname, userData.firstname) &&
                Objects.equals(lastname, userData.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}
