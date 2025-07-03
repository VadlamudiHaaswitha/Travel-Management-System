package com.gl.tms.utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class Error {
    private List<String> message;

    private String statusCode;

    private LocalDateTime timeStamp;
}
