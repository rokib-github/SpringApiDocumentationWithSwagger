package com.rokib.springApiDocumentationWithSwagger.rest;

import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.deleteUser.command.deleteUserCommand;
import com.rokib.springApiDocumentationWithSwagger.dto.accountManagement.signUp.SignUpCommand;
import com.rokib.springApiDocumentationWithSwagger.error.EntityNotFoundException;
import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;
import com.rokib.springApiDocumentationWithSwagger.service.contract.AccountService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/rest/auth", produces = {"application/json"}, consumes = {"application/json"})
public class Account {

    @Autowired
    private AccountService accountService;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Successfully created", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request or Validation Failed"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED) // ==> This is define to turn off default response messages
    @PostMapping(path = "/sign-up")
    public ResponseEntity<User> signUp(@Valid @RequestBody SignUpCommand signUpCommand) {
        URI uri = URI.create("==");
        return ResponseEntity.created(uri).body(accountService.createUser(signUpCommand));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User Successfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request or Validation Failed"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT) // ==> This is define to turn off default response messages
    @DeleteMapping(path = "/delete-user")
    public ResponseEntity<?> deleteUser(@Valid @RequestBody deleteUserCommand deleteUserCommand) throws EntityNotFoundException {
        accountService.deleteUser(deleteUserCommand);
        return ResponseEntity.noContent().build();
    }

}
