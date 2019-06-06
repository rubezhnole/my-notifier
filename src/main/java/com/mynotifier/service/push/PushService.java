package com.mynotifier.service.push;

import com.mynotifier.dto.Message;

public interface PushService {

    void push(Message message);
}
