package fio.dto;

import fio.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long personId;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private String email;
    private Date birthday;
    private String sex;

    private String nationality;
    private String maritalStatus;
    private String webSite;
    private String placeOfWork;
    private String country;

    private String phone;

    private User author;

}
