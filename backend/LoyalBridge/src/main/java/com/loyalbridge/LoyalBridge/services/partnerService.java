package com.loyalbridge.LoyalBridge.services;

import com.loyalbridge.LoyalBridge.dto.request.partnerRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.partnerResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.partnerResponsePaginate;

public interface partnerService {
    public void partnerSave(partnerRequestDto dto);
    public void partnerUpdate(partnerRequestDto dto, String id);
    public partnerResponsedto partnerFindById(String id);
    public void partnerDeleteById(String id);
    public partnerResponsePaginate partnerFindAll(String searchText, int page, int size);
}
