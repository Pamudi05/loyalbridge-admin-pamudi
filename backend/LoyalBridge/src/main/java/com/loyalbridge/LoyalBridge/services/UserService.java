package com.loyalbridge.LoyalBridge.services;

import com.loyalbridge.LoyalBridge.dto.request.UserRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.UserResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.UserResponsePaginate;

public interface UserService {
    public void userSave(UserRequestDto dto);
    public void userUpdate(UserRequestDto dto, String id);
    public UserResponsedto userFindById(String id);
    public void userDeleteById(String id);
    public UserResponsePaginate userFindAll(String searchText, int page, int size);
}
