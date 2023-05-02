package com.etiya.ecommerceDemo.business.concretes;

import com.etiya.ecommerceDemo.business.abstracts.UserService;
import com.etiya.ecommerceDemo.business.dtos.requests.user.AddUserRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.user.UpdateUserRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.user.AddUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.ListUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UpdateUserResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.user.UserDetailResponse;
import com.etiya.ecommerceDemo.core.exceptions.types.BusinessException;
import com.etiya.ecommerceDemo.core.utils.mapper.ModelMapperService;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import com.etiya.ecommerceDemo.core.utils.result.ErrorDataResult;
import com.etiya.ecommerceDemo.core.utils.result.SuccessDataResult;
import com.etiya.ecommerceDemo.entities.concretes.User;
import com.etiya.ecommerceDemo.repositories.abstracts.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserDao userDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<ListUserResponse>> getAll() {
        return new SuccessDataResult<>(userDao.getAll(), messageSource.getMessage("successListUser", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UserDetailResponse> getById(Long id) {
        if (userDao.getUserById(id) == null) {
            return new ErrorDataResult<>(userDao.getUserById(id), messageSource.getMessage("errorOneUser", null, LocaleContextHolder.getLocale()));
        }
        return new SuccessDataResult<>(userDao.getUserById(id), messageSource.getMessage("successOneUser", null, LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<AddUserResponse> addUser(AddUserRequest addUserRequest) {

        if (userDao.existsUserByEmail(addUserRequest.getEmail())) {
            throw new BusinessException(messageSource.getMessage("existsEmail", null, LocaleContextHolder.getLocale()));
        }

        User user = modelMapperService.getMapper().map(addUserRequest, User.class);

        userDao.save(user);
        AddUserResponse addUserResponse = this.modelMapperService.getMapper().map(user, AddUserResponse.class);

        return new SuccessDataResult<>(addUserResponse, messageSource.getMessage("successAddUser", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest, Long id) {
        if (!userDao.existsById(id)) {
            throw new BusinessException(messageSource.getMessage("errorOneUser", null, LocaleContextHolder.getLocale()));
        }

        User user = this.modelMapperService.getMapper().map(updateUserRequest, User.class);
        user.setId(id);
        userDao.save(user);

        UpdateUserResponse updateUserResponse = this.modelMapperService.getMapper().map(user, UpdateUserResponse.class);

        return new SuccessDataResult<>(updateUserResponse, messageSource.getMessage("successUpdateUser", null, LocaleContextHolder.getLocale()));
    }
}
