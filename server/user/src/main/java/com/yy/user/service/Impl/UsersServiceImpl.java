package com.yy.user.service.Impl;

import com.yy.user.dto.UsersDto;
import com.yy.user.entity.Users;
import com.yy.user.mapper.UsersMapper;
import com.yy.user.repository.UsersRepository;
import com.yy.user.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;



    @Override
    public void createUser(UsersDto usersDto) {

        Users users = UsersMapper.UsersDtoToUsers(usersDto,new Users());
        usersRepository.save(users);
    }
}
