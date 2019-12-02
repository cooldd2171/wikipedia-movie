package com.example.my_project.core.service.Impl;

import com.example.my_project.core.covertor.UserConvertor;
import com.example.my_project.core.service.UserService;
import com.example.my_project.entity.User;
import com.example.my_project.helper.error.ApiException;
import com.example.my_project.helper.error.ErrorCode;
import com.example.my_project.model.User.UserDTO;
import com.example.my_project.repository.UserRepository;
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
    public UserDTO createUser(UserDTO userDTO) {

        User user = userConvertor.convertToEntity(userDTO);
        user.setCreated_by(1);
        user.setUpdated_by(1);
        user.setActive(true);
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
