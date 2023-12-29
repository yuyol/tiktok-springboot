package com.yy.user.service.Impl;

import com.yy.user.dto.FollowersDto;
import com.yy.user.dto.UsersDto;
import com.yy.user.entity.Users;
import com.yy.user.exception.ResourceNotFoundException;
import com.yy.user.mapper.UsersMapper;
import com.yy.user.repository.FollowersRepository;
import com.yy.user.repository.UsersRepository;
import com.yy.user.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FollowersRepository followersRepository;
    private final String CHARACTERS = "0123456789abcdefghijqlmnopqrstuvwxyz";
    private final int UNIQUE_ID_LENGTH = 11;


    /**
     * Create User
     *
     * @param usersDto
     */
    @Override
    public void createUser(UsersDto usersDto) {

        Optional<Users> byMobileNumber = usersRepository.findByMobileNumber(usersDto.getMobileNumber());

        if (byMobileNumber.isPresent()) return;

        Users users = UsersMapper.UsersDtoToUsers(usersDto, new Users());

        // 生成随机unique id
        String uniqueId = generateUniqueId();
        Optional<Users> byUniqueId = usersRepository.findByUniqueId(uniqueId.toString());
        while (byUniqueId.isPresent()) uniqueId = generateUniqueId();
        users.setUniqueId(uniqueId);

        usersRepository.save(users);
    }

    public String generateUniqueId() {
        StringBuilder uniqueId = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < UNIQUE_ID_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            uniqueId.append(CHARACTERS.charAt(randomIndex));
        }
        return uniqueId.toString();
    }

    /**
     * Get User by user id
     *
     * @param userId
     * @return
     */
    @Override
    public UsersDto getUserById(long userId) {

        Users user = usersRepository.findByUserId(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "user id", String.valueOf(userId))
        );

        return UsersMapper.UsersToUsersDto(user, new UsersDto());
    }

    /**
     * Get User by mobile number
     *
     * @param mobileNumber
     * @return
     */
    @Override
    public UsersDto getUserByMobileNumber(String mobileNumber) {

        Users user = usersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("用户", "手机号", mobileNumber)
        );
        UsersDto usersDto = UsersMapper.UsersToUsersDto(user, new UsersDto());
        // 获取followersDto
        FollowersDto followersDto = getFollowers(user.getUserId());
        // 填充UsersDto
        usersDto.setFollowersDto(followersDto);
        return usersDto;
    }

    /**
     * 获取FollowersDto
     * 粉丝数，粉丝集合
     * 关注数，关注集合
     *
     * @param userId
     * @return
     */
    @Override
    public FollowersDto getFollowers(long userId) {
        FollowersDto followersDto = new FollowersDto();
        // 获取粉丝集合
        Optional<List<Users>> followerUsers = usersRepository.searchFollowersByUserId(userId);
        List<Users> followers = followerUsers.get();
        // 获取粉丝数
        int followerAmount = followersRepository.followersCount(userId);
        // 获取关注集合
        Optional<List<Users>> followUsers = usersRepository.searchFollowsByUserId(userId);
        List<Users> follows = followUsers.get();
        // 获取关注数
        int followAmount = followersRepository.followsCount(userId);

        // 填充Dto
        followersDto.setFollowers(followers);
        followersDto.setFollowerAmount(followerAmount);
        followersDto.setFollows(follows);
        followersDto.setFollowAmount(followAmount);

        return followersDto;
    }

    /**
     * Get User by unique id
     *
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
     *
     * @param mobileNumber
     */
    @Override
    public void deleteUserByMobileNumber(String mobileNumber) {
        usersRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("User", "mobile number", mobileNumber)
        );
        usersRepository.deleteByMobileNumber(mobileNumber);
    }


}
