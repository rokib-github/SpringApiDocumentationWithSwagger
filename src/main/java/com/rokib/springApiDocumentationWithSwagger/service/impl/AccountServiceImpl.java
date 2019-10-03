package com.rokib.springApiDocumentationWithSwagger.service.impl;

import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.SignUpCommand;
import com.rokib.springApiDocumentationWithSwagger.dto.userManagement.deleteUser.DeleteUserCommand;
import com.rokib.springApiDocumentationWithSwagger.mapper.contract.UserMapper;
import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;
import com.rokib.springApiDocumentationWithSwagger.persistence.repository.UserRepository;
import com.rokib.springApiDocumentationWithSwagger.service.contract.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(SignUpCommand signUpRequest) {
        User user = userMapper.createUserFromCommand(signUpRequest);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(DeleteUserCommand deleteUserCommand) {
        userRepository.deleteById(deleteUserCommand.getId());
    }


}
