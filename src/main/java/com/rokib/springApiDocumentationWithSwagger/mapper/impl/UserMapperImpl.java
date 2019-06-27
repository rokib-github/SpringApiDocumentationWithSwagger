package com.rokib.springApiDocumentationWithSwagger.mapper.impl;

import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.SignUpCommand;
import com.rokib.springApiDocumentationWithSwagger.mapper.contract.UserMapper;
import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User createUserFromCommand(SignUpCommand signUpCommand) {
        User user = new User();
        user.setFirstName(signUpCommand.getFirstName());
        user.setLastName(signUpCommand.getLastName());
        user.setEmail(signUpCommand.getEmail());
        return user;
    }
}
