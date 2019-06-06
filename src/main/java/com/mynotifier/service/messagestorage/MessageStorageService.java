package com.mynotifier.service.messagestorage;

import com.mynotifier.dto.Message;

import java.util.List;

public interface MessageStorageService {

    void add(Message message);

    List<Message> loadAll();

    List<Message> loadLast(Integer number);
}
