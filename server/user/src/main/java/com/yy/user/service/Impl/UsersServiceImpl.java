package com.yy.user.service.Impl;

import com.yy.user.dto.UsersDto;
import com.yy.user.entity.Users;
import com.yy.user.exception.ResourceNotFoundException;
import com.yy.user.mapper.UsersMapper;
import com.yy.user.repository.UsersRepository;
import com.yy.user.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    /**
     * Create User
     * @param usersDto
     */
    @Override
    public void createUser(UsersDto usersDto) {

        Optional<Users> byMobileNumber = usersRepository.findByMobileNumber(usersDto.getMobileNumber());

        if (byMobileNumber.isPresent()) return;

        Users users = UsersMapper.UsersDtoToUsers(usersDto,new Users());
        usersRepository.save(users);
    }

    /**
     * Get User by user id
     * @param userId
     * @return
     */
    @Override
    public UsersDto getUserById(long userId) {

        Users user = usersRepository.findByUserId(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","user id", String.valueOf(userId))
        );

        return UsersMapper.UsersToUsersDto(user, new UsersDto());
    }

    /**
     * Get User by mobile number
     * @param mobileNumber
     * @return
     */
    @Override
    public UsersDto getUserByMobileNumber(String mobileNumber) {

        Users user = usersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("User","Mobile number",mobileNumber)
        );

        return UsersMapper.UsersToUsersDto(user, new UsersDto());
    }
}
