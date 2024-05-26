package com.msb.firstjobapp.utils;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Getter
public class Response<T> extends ResponseEntity<ResBody<T>> {
    public Response(@NotNull HttpStatusCode status, @NotNull String message, @Nullable T response) {
        super(new ResBody<>(message, response), status);
    }
}

