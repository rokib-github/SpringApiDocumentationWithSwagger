package com.rokib.springApiDocumentationWithSwagger.service.contract;

import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.deleteUser.command.deleteUserCommand;
import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.SignUpCommand;
import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;

public interface AccountService {
    User createUser(SignUpCommand signUpCommand);
    void deleteUser(deleteUserCommand deleteUserCommand);
}
