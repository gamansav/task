package com.yamman.xml.validator.service.controller.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RestApiError {

    @JsonProperty("message")
    private final String message;

    @JsonProperty("time")
    private final LocalDateTime localDateTime;

    public RestApiError(String message) {
        this(message, LocalDateTime.now());
    }

    public RestApiError(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }
}

