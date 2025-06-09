package com.loyalbridge.LoyalBridge.dto.response.paginate;

import java.util.List;

import com.loyalbridge.LoyalBridge.dto.response.UserResponsedto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserResponsePaginate {
    private long dataCount;
    private List<UserResponsedto> dataList;
}
