package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("user")
@Entity
@Table(name = "addressbook")
public class UserData {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private  int id = Integer.MAX_VALUE;
    @Expose
    @Column(name="firstname")
    private  String firstname;
    @Column(name="middlename")
    private  String midname;
    @Expose
    @Column(name="lastname")
    private  String lastname;
    @Expose
    @Column(name="address")
    @Type(type = "text")
    private  String address;
    @Column(name="email")
    @Type(type = "text")
    private  String email;
    @Column(name="email2")
    @Type(type = "text")
    private  String email2;
    @Column(name="email3")
    @Type(type = "text")
    private  String email3;
    @Transient
    private  String allemails;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups= new HashSet<GroupData>();

    @Column(name="home")
    @Type(type = "text")
    private  String homePhone;
    @Column(name="work")
    @Type(type = "text")
    private  String workPhone;
    @Column(name="mobile")
    @Type(type = "text")
    private  String mobilePhone;
    @Transient
    private  String allphones;
    @Column(name="photo")
    @Type(type = "text")
    private String photo;

    public UserData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public File getPhoto() {
        return new File(photo);
    }



    public UserData withAllPhones(String allphones) {
        this.allphones = allphones;
        return this;
    }
    public UserData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public UserData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public UserData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserData withMidname(String midname) {
        this.midname = midname;
        return this;
    }

    public UserData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }


    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public UserData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public UserData withallemails(String allemails) {
        this.allemails = allemails;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllemails() {
        return allemails;
    }

    public String getAllphones() {
        return allphones;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
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

    public String getEmail() {
        return email;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }


    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                Objects.equals(firstname, userData.firstname) &&
                Objects.equals(lastname, userData.lastname) &&
                Objects.equals(address, userData.address) &&
                Objects.equals(homePhone, userData.homePhone) &&
                Objects.equals(workPhone, userData.workPhone) &&
                Objects.equals(mobilePhone, userData.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, homePhone, workPhone, mobilePhone);
    }

    public UserData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
