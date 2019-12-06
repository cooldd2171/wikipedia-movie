package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.covertor.UserConvertor;
import com.shourya.demo.core.service.UserService;
import com.shourya.demo.persistance.entity.User;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.helper.error.ErrorCode;
import com.shourya.demo.model.User.UserDTO;
import com.shourya.demo.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;


    public UserDTO getUserDetailsById(Integer id) throws ApiException {
        User user = userRepository.findByIdAndDeleted(id,(byte)0);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        return userConvertor.convertToModel(user);

    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) throws ApiException {
        String userName =userDTO.getUserName();
        User exists=userRepository.findByUserNameAndDeleted(userName,(byte)0);
        if(Objects.nonNull(exists)){
            throw new ApiException("400","UserName Already Exists");
        }
        User user = userConvertor.convertToEntity(userDTO);
        user.setCreatedBy(1);
        user.setUpdatedBy(1);
        user.setDeleted((byte)0);
        user = userRepository.save(user);
        return userConvertor.convertToModel(user);

    }

    public UserDTO updateUser(UserDTO userDTO) throws ApiException {
        User user = userRepository.findById(userDTO.getId()).orElse(null);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        return null;
    }


}
