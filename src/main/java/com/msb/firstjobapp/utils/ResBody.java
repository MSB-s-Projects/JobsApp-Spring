package com.msb.firstjobapp.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResBody<T> {
    private String message;
    private T response;
}
