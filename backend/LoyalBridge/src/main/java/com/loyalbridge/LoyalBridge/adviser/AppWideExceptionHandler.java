package com.loyalbridge.LoyalBridge.adviser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loyalbridge.LoyalBridge.exception.BadRequestException;
import com.loyalbridge.LoyalBridge.exception.DuplicateEntryException;
import com.loyalbridge.LoyalBridge.exception.EntryNotFoundException;
import com.loyalbridge.LoyalBridge.exception.UnauthorizedException;
import com.loyalbridge.LoyalBridge.util.StandardResponseDto;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponseDto> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponseDto(404,e.getMessage(),e),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponseDto> handleDuplicateEntryException(DuplicateEntryException e){
        return new ResponseEntity<>(
                new StandardResponseDto(409,e.getMessage(),e),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardResponseDto> handleBadRequestException(BadRequestException e) {

        return new ResponseEntity<StandardResponseDto>(
                new StandardResponseDto( 400,e.getMessage(), e),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardResponseDto> handleUnauthorizedException(UnauthorizedException e) {
        return new ResponseEntity<StandardResponseDto>(
                new StandardResponseDto( 401,e.getMessage(), e),
                HttpStatus.UNAUTHORIZED);
    }

}
