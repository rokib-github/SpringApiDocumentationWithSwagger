package com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp;

import com.rokib.springApiDocumentationWithSwagger.constants.FieldConstraints;
import com.rokib.springApiDocumentationWithSwagger.validation.rule.NotExistingEmail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpCommand {

    @NotNull(message = "Email must not be null")
    @Email(message = "Must be a valid email")
    @NotExistingEmail
    @Size.List({
            @Size(
                    min = FieldConstraints.ForUser.MIN_EMAIL_LENGTH,
                    message = "Email must have at least {min} characters"),
            @Size(
                    max = FieldConstraints.ForUser.MAX_EMAIL_LENGTH,
                    message = "Email can have at most {max} characters")
    })
    @ApiModelProperty(
            notes =
                    "User's email, which does not exist already,length should be between ["
                            + FieldConstraints.ForUser.MIN_EMAIL_LENGTH
                            + ","
                            + FieldConstraints.ForUser.MAX_EMAIL_LENGTH
                            + "]",
            required = true)
    private String email;
    private String firstName;
    private String lastName;
}
