package com.scm.forms;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Username is required")
    @Size( min = 3 ,message = "Min 3 characters is required")
    private String name;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;
    private String Password;
    @NotBlank(message = "About is not blank")
    private  String about;
    @Size(min =8 , max=12, message = "Invalid Phone number")
    private  String phoneNumber;


}
