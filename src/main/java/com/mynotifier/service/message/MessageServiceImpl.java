package com.mynotifier.service.message;

import com.mynotifier.dto.Message;
import com.mynotifier.service.messagestorage.MessageStorageService;
import com.mynotifier.service.push.PushService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private PushService pushService;
    private MessageStorageService messageStorageService;

    public MessageServiceImpl(PushService pushService,
                              MessageStorageService messageStorageService) {
        this.pushService = pushService;
        this.messageStorageService = messageStorageService;
    }

    public void notifyAll(Message message) {
        messageStorageService.add(message);
        pushService.push(message);
    }
}
