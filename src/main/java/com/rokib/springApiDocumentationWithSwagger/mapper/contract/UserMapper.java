package com.rokib.springApiDocumentationWithSwagger.mapper.contract;

import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.SignUpCommand;
import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;

public interface UserMapper {
    User createUserFromCommand(SignUpCommand signUpCommand);
}
