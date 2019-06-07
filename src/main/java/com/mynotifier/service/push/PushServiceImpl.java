package com.mynotifier.service.push;

import com.google.gson.JsonObject;
import com.mynotifier.dto.Message;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

@Component
public class PushServiceImpl implements PushService {

    private final HttpClient httpClient;

    public PushServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void push(Message message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ApiKey", "98c5757ee4cd47d2ac546305e0926d44");
        jsonObject.addProperty("Title", message.getTitle());
        jsonObject.addProperty("Text", message.getText());
        jsonObject.addProperty("ClickUrl", "http://komissar-alert.us-east-2.elasticbeanstalk.com/");

        try {
            StringEntity stringEntity = new StringEntity(jsonObject.toString(), APPLICATION_JSON);

            HttpPost httpPost = new HttpPost("https://push4site.com/interface/send");
            httpPost.setEntity(stringEntity);

            HttpResponse execute = httpClient.execute(httpPost);
            System.out.println(execute.getStatusLine().getStatusCode());
            System.out.println(
                    new BufferedReader(new InputStreamReader(execute.getEntity().getContent()))
                            .lines().collect(Collectors.joining("\n"))
            );
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
