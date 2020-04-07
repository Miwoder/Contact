package fio.entity;

import fio.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private String zip;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private Date birthday;

    @Column(name="sex")
    private String sex;
    @Column(name="nationality")
    private String nationality;
    @Column(name="marital_status")
    private String maritalStatus;
    @Column(name="Web_site")
    private String webSite;
    @Column(name="Work")
    private String placeOfWork;
    @Column(name="Country")
    private String country;

    @Column(name="Phone")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "none";
    }

}