package com.example.workertelegram;

import lombok.Value;

@Value
public class ApiRequest {
    String channel;
    String text;
}
