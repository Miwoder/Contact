package fio.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
    @NotBlank(message="Name is required")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String firstName;

    private String lastName;
    private String street;
    private String city;
    @Digits(integer=6, fraction=0, message="Invalid zip code")
    private String zip;
    private String email;

    private String birthday;
}

