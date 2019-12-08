package com.shourya.demo.core.service.Impl;

import com.shourya.demo.core.covertor.UserConvertor;
import com.shourya.demo.core.service.UserService;
import com.shourya.demo.model.User.UserModel;
import com.shourya.demo.persistance.entity.User;
import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.helper.error.ErrorCode;
import com.shourya.demo.model.User.UserDTO;
import com.shourya.demo.persistance.entity.UserToFlightMap;
import com.shourya.demo.persistance.repository.UserRepository;
import com.shourya.demo.persistance.repository.UserToFlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;
    @Autowired
    private UserToFlightRepository userToFlightRepository;


    public UserDTO getUserDetailsByUserName(String userName) throws ApiException {
        User user = userRepository.findByUserName(userName);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);

        Collection<UserToFlightMap> userToFlightMaps=userToFlightRepository.findByUserId(user.getId());

        log.info("userToFlightMaps=> "+userToFlightMaps);

        return userConvertor.convertToModel(user);

    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) throws ApiException {
        String userName =userDTO.getUserName();
        User exists=userRepository.findByUserName(userName);
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

    public UserModel updateUser(UserModel userModel) throws ApiException {
        User user = userRepository.findByUserName(userModel.getUserName());
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);
         user.setUserName(userModel.getUserName());
         user.setContactNumber(new BigInteger(userModel.getContactNumber()));
         user.setEmail(userModel.getEmail());
         user.setName(userModel.getName());
         user.setCity(userModel.getCity());
         userRepository.save(user);
         return userModel;

    }

    @Override
    public UserDTO deleteUser(String userName) throws ApiException {
        User user = userRepository.findByUserName(userName);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);
        user.setDeleted((byte)1);
        userRepository.save(user);
        return null;
    }

    @Override
    public UserDTO verifyLogin(String userName, String password) throws ApiException {
        User user = userRepository.findByUserNameAndPasswordAndDeleted(userName,password,(byte)0);
        if (Objects.isNull(user))
            throw new ApiException(ErrorCode.USER_NOT_FOUND);
        return null;
    }
}
