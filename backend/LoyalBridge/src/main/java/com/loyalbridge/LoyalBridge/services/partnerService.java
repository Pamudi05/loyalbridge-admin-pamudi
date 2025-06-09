package com.loyalbridge.LoyalBridge.services;

import com.loyalbridge.LoyalBridge.dto.request.PartnerRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.PartnerResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.PartnerResponsePaginate;

public interface PartnerService {
    public void partnerSave(PartnerRequestDto dto);
    public void partnerUpdate(PartnerRequestDto dto, String id);
    public PartnerResponsedto partnerFindById(String id);
    public void partnerDeleteById(String id);
    public PartnerResponsePaginate partnerFindAll(String searchText, int page, int size);
}
