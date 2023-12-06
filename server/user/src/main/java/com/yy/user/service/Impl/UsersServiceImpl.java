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

import java.security.SecureRandom;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    private final String CHARACTERS = "0123456789abcdefghijqlmnopqrstuvwxyz";
    private final int UNIQUE_ID_LENGTH = 11;


    /**
     * Create User
     * @param usersDto
     */
    @Override
    public void createUser(UsersDto usersDto) {

        Optional<Users> byMobileNumber = usersRepository.findByMobileNumber(usersDto.getMobileNumber());

        if (byMobileNumber.isPresent()) return;

        Users users = UsersMapper.UsersDtoToUsers(usersDto,new Users());

        // 生成随机unique id
        String uniqueId = generateUniqueId();
        Optional<Users> byUniqueId = usersRepository.findByUniqueId(uniqueId.toString());
        while(byUniqueId.isPresent()) uniqueId = generateUniqueId();
        users.setUniqueId(uniqueId);

        usersRepository.save(users);
    }

    public String generateUniqueId() {
        StringBuilder uniqueId = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i=0;i<UNIQUE_ID_LENGTH;i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            uniqueId.append(CHARACTERS.charAt(randomIndex));
        }
        return uniqueId.toString();
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

    /**
     * Get User by unique id
     * @param uniqueId
     * @return
     */
    @Override
    public UsersDto getUserByUniqueId(String uniqueId) {

        Users user = usersRepository.findByUniqueId(uniqueId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Unique ID", uniqueId)
        );

        return UsersMapper.UsersToUsersDto(user, new UsersDto());
    }

    /**
     * Delete User by mobile number
     * @param mobileNumber
     */
    @Override
    public void deleteUserByMobileNumber(String mobileNumber) {
        usersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("User","mobile number",mobileNumber)
        );
        usersRepository.deleteByMobileNumber(mobileNumber);
    }
}
