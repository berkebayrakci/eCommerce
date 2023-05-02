package com.etiya.ecommerceDemo.api.controllers;

import com.etiya.ecommerceDemo.business.abstracts.UserService;
import com.etiya.ecommerceDemo.business.dtos.requests.user.AddUserRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.user.UpdateUserRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.user.AddUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.ListUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UpdateUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UserDetailResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping
    public DataResult<List<ListUserResponse>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<UserDetailResponse> getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public DataResult<AddUserResponse> addProduct(@RequestBody @Valid AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }

    @PutMapping("/{id}")
    public DataResult<UpdateUserResponse> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest, @PathVariable Long id) {
        return userService.updateUser(updateUserRequest, id);
    }
}
