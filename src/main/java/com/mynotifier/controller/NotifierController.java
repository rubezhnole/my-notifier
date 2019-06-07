package com.mynotifier.controller;

import com.mynotifier.dto.Message;
import com.mynotifier.service.messagestorage.MessageStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.mynotifier.service.message.MessageService;

import java.util.List;

@Controller
public class NotifierController {

    private final MessageService messageService;
    private final MessageStorageService messageStorageService;

    public NotifierController(MessageService messageService,
                              MessageStorageService messageStorageService) {
        this.messageService = messageService;
        this.messageStorageService = messageStorageService;
    }

    @RequestMapping({"", "index"})
    public String load() {
        return "index";
    }

    @PostMapping("notifyAll")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Message message) {
        messageService.notifyAll(message);
    }

    @GetMapping("notifyAll")
    @ResponseStatus(HttpStatus.OK)
    public void createGet(@RequestParam String text) {
        Message message = new Message();
        message.setTitle("Увага! Будьте обережні!");
        message.setText(text);
        messageService.notifyAll(message);
    }

    @GetMapping("loadLastTwenty")
    @ResponseBody
    public List<Message> loadLastTwenty() {
        return messageStorageService.loadLast(20);
    }
}
