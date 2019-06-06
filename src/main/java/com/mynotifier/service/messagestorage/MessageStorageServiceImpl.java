package com.mynotifier.service.messagestorage;

import com.mynotifier.dto.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageStorageServiceImpl implements MessageStorageService {

    // use linked list with order by date
    private List<Message> messages = new ArrayList<>();

    public void add(Message message) {
        message.setCreateDate(LocalDateTime.now());
        messages.add(message);
    }

    public List<Message> loadAll() {
        return new ArrayList<>(messages);
    }

    public List<Message> loadLast(Integer number) {
        return messages
                .stream()
                .sorted(Comparator.comparing(Message::getCreateDate))
                .limit(number)
                .collect(Collectors.toList());
    }
}
