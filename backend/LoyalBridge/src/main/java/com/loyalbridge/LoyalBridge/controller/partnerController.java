package com.loyalbridge.LoyalBridge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loyalbridge.LoyalBridge.dto.request.PartnerRequestDto;
import com.loyalbridge.LoyalBridge.services.PartnerService;
import com.loyalbridge.LoyalBridge.util.StandardResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/partners")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> savePartner(@RequestBody PartnerRequestDto dto){
        partnerService.partnerSave(dto);
        return new ResponseEntity<>(
            StandardResponseDto.builder()
            .code(201)
            .message("Partner Saved")
            .data(null)
            .build(),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseDto> getPartner(@PathVariable("id") String partnerId){
        return new ResponseEntity<>(
            StandardResponseDto.builder()
            .code(200)
            .message("Partner Data!")
            .data(partnerService.partnerFindById(partnerId))
            .build(),
            HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> updatePartner(
        @PathVariable("id") String partnerId,
        @RequestBody PartnerRequestDto dto){
            partnerService.partnerUpdate(dto, partnerId);
            return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("Partner Updated!")
                .data(null)
                .build(),
                HttpStatus.CREATED
            );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> deletePartner(@PathVariable("id") String partnerId){
        partnerService.partnerDeleteById(partnerId);
        return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("Partner Deleted!")
                .data(null)
                .build(),
                HttpStatus.OK
            );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponseDto> getAllPartner(
        @RequestParam String searchText, 
        @RequestParam int page, 
        @RequestParam int size){
            return new ResponseEntity<>(
                StandardResponseDto.builder()
                .code(201)
                .message("Partner List!")
                .data(partnerService.partnerFindAll(searchText, page, size))
                .build(),
                HttpStatus.OK
            );
    }
}
