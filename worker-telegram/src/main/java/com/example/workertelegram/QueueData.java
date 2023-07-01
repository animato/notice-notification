package com.example.workertelegram;

import lombok.Value;

@Value
public class QueueData {
    String token;
    String channel;
    String text;
}
