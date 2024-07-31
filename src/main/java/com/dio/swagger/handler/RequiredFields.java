package com.dio.swagger.handler;

public class RequiredFields extends BusinessException{

    public RequiredFields(String field) {
        super("Field %s is required", field);
    }
}
