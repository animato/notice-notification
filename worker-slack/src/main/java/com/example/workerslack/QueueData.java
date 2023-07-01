package com.example.workerslack;

import lombok.Value;

@Value
public class QueueData {
    String token;
    String channel;
    String text;
}
