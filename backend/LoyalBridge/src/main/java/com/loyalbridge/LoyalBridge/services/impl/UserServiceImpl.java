package com.loyalbridge.LoyalBridge.services.impl;

import java.util.UUID;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.loyalbridge.LoyalBridge.dto.request.UserRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.UserResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.UserResponsePaginate;
import com.loyalbridge.LoyalBridge.entity.User;
import com.loyalbridge.LoyalBridge.exception.EntryNotFoundException;
import com.loyalbridge.LoyalBridge.repository.UserRepo;
import com.loyalbridge.LoyalBridge.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Override
    public void userSave(UserRequestDto dto) {
        userRepo.save(toUser(dto));
    }

    @Override
    public void userUpdate(UserRequestDto dto, String id) {
        User user = userRepo.findById(id).orElseThrow(()->
            new EntryNotFoundException("User Not Found"));

        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setStatus(dto.getStatus());
        user.setHighRisk(dto.getHighRisk());
        user.setVerified(dto.getVerified());
        user.setPoints(dto.getPoints());

        userRepo.save(user);
    }

    @Override
    public UserResponsedto userFindById(String id) {
        return toUserResponsedto(userRepo.findById(id).orElseThrow(()->
             new RuntimeException("Partner Not Found"))
        );
    }

    @Override
    public void userDeleteById(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserResponsePaginate userFindAll(String searchText, int page, int size) {
        return UserResponsePaginate.builder()
            .dataCount(userRepo.countAllUsers(searchText))
            .dataList(userRepo.searchAllUsers(searchText, PageRequest.of(page, size))
                    .stream()
                    .map(this::toUserResponsedto)
                    .collect(Collectors.toList()))
            .build();
    }

    private User toUser(UserRequestDto dto){
        if (dto == null) throw new RuntimeErrorException(null, "Null");
        return User.builder()  
        .id(UUID.randomUUID().toString())
        .name(dto.getName())
        .phoneNumber(dto.getPhoneNumber())
        .status(dto.getStatus())
        .highRisk(dto.getHighRisk())
        .verified(dto.getVerified())
        .points(dto.getPoints())
        .build();
    }

    private UserResponsedto toUserResponsedto(User user){
        if (user == null) throw new RuntimeErrorException(null, "Null");
        return UserResponsedto.builder()  
        .id(UUID.randomUUID().toString())
        .name(user.getName())
        .phoneNumber(user.getPhoneNumber())
        .status(user.getStatus())
        .highRisk(user.getHighRisk())
        .verified(user.getVerified())
        .points(user.getPoints())
        .build();
    }
}
