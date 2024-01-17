package com.example.first_java_project.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.example.first_java_project.DAO.domain.User;
import com.example.first_java_project.DAO.repository.UserRepo;
import com.example.first_java_project.data.request.DTO.userCreateRqDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    // 모든 사용자에 대한 정보를 불러옴. ## 그냥 편이상 userCreateRqDto로 구현했으므로, UserRespDto로 다시 구현해야 함.
    @Override
    public List<userCreateRqDto> getAllUser(){
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, userCreateRqDto.class))
                .collect(Collectors.toList());
    }
    // 사용자를 저장함.
    @Override
    public userCreateRqDto createUser(userCreateRqDto userCreateRqDto) {
        // DTO에서 엔티티로 맵핑
        User newUser = modelMapper.map(userCreateRqDto, User.class);
        newUser.setRegistrationDate(LocalDateTime.now());
        User savedUser = userRepo.save(newUser);
        return modelMapper.map(savedUser, userCreateRqDto.class);
    }
    // 사용자를 삭제함.
    @Override
    public void deleteUser(Long userId){
        userRepo.deleteByUserid(userId);
    }
    // 사용자를 이름을 통해서 찾음.
    @Override
    public User getUserByUserName(String userName){
        return userRepo.findByUserName(userName).orElse(null);
    }


}
