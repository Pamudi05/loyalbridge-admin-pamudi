package com.loyalbridge.LoyalBridge.dto.response.paginate;

import java.util.List;

import com.loyalbridge.LoyalBridge.dto.response.PartnerResponsedto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PartnerResponsePaginate {
    private long dataCount;
    private List<PartnerResponsedto> dataList;
}
