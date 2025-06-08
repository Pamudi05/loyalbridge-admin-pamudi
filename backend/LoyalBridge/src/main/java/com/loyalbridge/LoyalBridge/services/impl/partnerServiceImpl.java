package com.loyalbridge.LoyalBridge.services.impl;

import java.util.UUID;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.loyalbridge.LoyalBridge.dto.request.partnerRequestDto;
import com.loyalbridge.LoyalBridge.dto.response.partnerResponsedto;
import com.loyalbridge.LoyalBridge.dto.response.paginate.partnerResponsePaginate;
import com.loyalbridge.LoyalBridge.entity.partner;
import com.loyalbridge.LoyalBridge.repository.partnerRepo;
import com.loyalbridge.LoyalBridge.services.partnerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class partnerServiceImpl implements partnerService{
    
    private final partnerRepo partnerRepo;
    
    @Override
    public void partnerSave(partnerRequestDto dto) {
        partnerRepo.save(toPartner(dto));
    }

    @Override
    public void partnerUpdate(partnerRequestDto dto, String id) {
        partner partner = partnerRepo.findById(id).orElseThrow(()->
            new RuntimeException("Partner Not Found"));

        partner.setName(dto.getName());
        partner.setApiUrl(dto.getApiUrl());
        partner.setAuthMethod(dto.getAuthMethod());
        partner.setConversionRate(dto.getConversionRate());
        partner.setStatus(dto.getStatus());

        partnerRepo.save(partner);
    }

    @Override
    public partnerResponsedto partnerFindById(String id) {
        return toPartnerResponsedto(
            partnerRepo.findById(id)
            .orElseThrow(()->new RuntimeException("Partner Not Found"))
        );  
    }

    @Override
    public void partnerDeleteById(String id) {
        partnerRepo.deleteById(id);
    }

    @Override
    public partnerResponsePaginate partnerFindAll(String searchText, int page, int size) {
        return partnerResponsePaginate.builder()
                .dataCount(partnerRepo.countAllPartners(searchText))
                .dataList(partnerRepo.searchAllPartners(searchText, PageRequest.of(page, size))
                        .stream()
                        .map(this::toPartnerResponsedto)
                        .collect(Collectors.toList()))
                .build();
    }

   
    private partner toPartner(partnerRequestDto dto){
        if (dto == null) throw new RuntimeErrorException(null, "Null");
        return partner.builder()  
        .id(UUID.randomUUID().toString())
        .name(dto.getName())
        .apiUrl(dto.getApiUrl())
        .authMethod(dto.getAuthMethod())
        .conversionRate(dto.getConversionRate())
        .status(dto.getStatus())
        .build();
    }

    private partnerResponsedto toPartnerResponsedto(partner partner){
        if (partner == null) throw new RuntimeErrorException(null, "Null");
        return partnerResponsedto.builder()  
        .id(partner.getId())
        .name(partner.getName())
        .apiUrl(partner.getApiUrl())
        .authMethod(partner.getAuthMethod())
        .conversionRate(partner.getConversionRate())
        .status(partner.getStatus())
        .build();
    }

    

}
