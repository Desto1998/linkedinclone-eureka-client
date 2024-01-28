package com.linkedInclone.postsservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class DeleteException extends Throwable{
    public DeleteException(String message){
        super(message);
    }
}
