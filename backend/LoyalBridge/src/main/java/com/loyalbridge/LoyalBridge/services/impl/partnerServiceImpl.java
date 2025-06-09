package com.loyalbridge.LoyalBridge.services.impl;

import java.util.UUID;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.loyalbridge.LoyalBridge.dto.request.PartnerRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.PartnerResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.PartnerResponsePaginate;
import com.loyalbridge.LoyalBridge.entity.Partner;
import com.loyalbridge.LoyalBridge.exception.EntryNotFoundException;
import com.loyalbridge.LoyalBridge.repository.PartnerRepo;
import com.loyalbridge.LoyalBridge.services.PartnerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
    
    private final PartnerRepo partnerRepo;
    
    @Override
    public void partnerSave(PartnerRequestDto dto) {
        partnerRepo.save(toPartner(dto));
    }

    @Override
    public void partnerUpdate(PartnerRequestDto dto, String id) {
        Partner partner = partnerRepo.findById(id).orElseThrow(()->
            new EntryNotFoundException("Partner Not Found"));

        partner.setName(dto.getName());
        partner.setApiUrl(dto.getApiUrl());
        partner.setAuthMethod(dto.getAuthMethod());
        partner.setConversionRate(dto.getConversionRate());
        partner.setStatus(dto.getStatus());

        partnerRepo.save(partner);
    }

    @Override
    public PartnerResponsedto partnerFindById(String id) {
        return toPartnerResponsedto(
            partnerRepo.findById(id)
            .orElseThrow(()-> new RuntimeException("Partner Not Found"))
        );  
    }

    @Override
    public void partnerDeleteById(String id) {
        partnerRepo.deleteById(id);
    }

    @Override
    public PartnerResponsePaginate partnerFindAll(String searchText, int page, int size) {
        return PartnerResponsePaginate.builder()
                .dataCount(partnerRepo.countAllPartners(searchText))
                .dataList(partnerRepo.searchAllPartners(searchText, PageRequest.of(page, size))
                        .stream()
                        .map(this::toPartnerResponsedto)
                        .collect(Collectors.toList()))
                .build();
    }

   
    private Partner toPartner(PartnerRequestDto dto){
        if (dto == null) throw new RuntimeErrorException(null, "Null");
        return Partner.builder()  
        .id(UUID.randomUUID().toString())
        .name(dto.getName())
        .apiUrl(dto.getApiUrl())
        .authMethod(dto.getAuthMethod())
        .conversionRate(dto.getConversionRate())
        .status(dto.getStatus())
        .build();
    }

    private PartnerResponsedto toPartnerResponsedto(Partner partner){
        if (partner == null) throw new RuntimeErrorException(null, "Null");
        return PartnerResponsedto.builder()  
        .id(partner.getId())
        .name(partner.getName())
        .apiUrl(partner.getApiUrl())
        .authMethod(partner.getAuthMethod())
        .conversionRate(partner.getConversionRate())
        .status(partner.getStatus())
        .build();
    }

    

}
