package com.loyalbridge.LoyalBridge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loyalbridge.LoyalBridge.dto.request.UserRequestDto;
import com.loyalbridge.LoyalBridge.services.UserService;
import com.loyalbridge.LoyalBridge.util.StandardResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> saveUser(@RequestBody UserRequestDto dto){
        userService.userSave(dto);
        return new ResponseEntity<>(
            StandardResponseDto.builder()
            .code(201)
            .message("User Saved")
            .data(null)
            .build(),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseDto> getUser(@PathVariable("id") String userId){
        return new ResponseEntity<>(
            StandardResponseDto.builder()
            .code(200)
            .message("User Data!")
            .data(userService.userFindById(userId))
            .build(),
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> updateUser(
        @PathVariable("id") String userId,
        @RequestBody UserRequestDto dto){
            userService.userUpdate(dto, userId);
            return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("User Updated!")
                .data(null)
                .build(),
                HttpStatus.CREATED
            );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> deleteUser(@PathVariable("id") String userId){
        userService.userDeleteById(userId);
        return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("User Deleted!")
                .data(null)
                .build(),
                HttpStatus.OK
            );
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponseDto> getAllUser(
        @RequestParam String searchText, 
        @RequestParam int page, 
        @RequestParam int size){
            return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("User List!")
                .data(userService.userFindAll(searchText, page, size))
                .build(),
                HttpStatus.OK
            );
    }
}
