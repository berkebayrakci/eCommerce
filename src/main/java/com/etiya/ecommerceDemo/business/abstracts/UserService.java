package com.etiya.ecommerceDemo.business.abstracts;

import com.etiya.ecommerceDemo.business.dtos.requests.user.AddUserRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.user.UpdateUserRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.user.AddUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.ListUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UpdateUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UserDetailResponse;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<ListUserResponse>> getAll();

    DataResult<UserDetailResponse> getById(Long id);

    DataResult<AddUserResponse> addUser(AddUserRequest addUserRequest);

    DataResult<UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest, Long id);
}
