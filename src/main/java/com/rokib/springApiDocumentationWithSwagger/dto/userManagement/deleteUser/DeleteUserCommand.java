package com.rokib.springApiDocumentationWithSwagger.dto.userManagement.deleteUser;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DeleteUserCommand {

    @NotNull(message = "User id must not be null or empty")
    private Integer id;
}
