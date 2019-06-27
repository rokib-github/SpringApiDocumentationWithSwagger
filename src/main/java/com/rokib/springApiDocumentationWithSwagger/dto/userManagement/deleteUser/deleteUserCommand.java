package com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.deleteUser.command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class deleteUserCommand {

    @NotNull(message = "User id must not be null or empty")
    private Integer id;
}
