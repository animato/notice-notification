package com.example.workerslack;

import lombok.Value;

@Value
public class ApiRequest {
    String channel;
    String text;
}
