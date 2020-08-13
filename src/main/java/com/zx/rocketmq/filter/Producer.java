package com.zx.rocketmq.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.zx.rocketmq.order
 * @ClassName: Producer
 * @Author: xz
 * @Date: 2020/8/12 17:12
 * @Version: 1.0
 */
public class Producer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("base","Tag1",("hello world ").getBytes()));
        messages.add(new Message("base","Tag2",("nice to meet you ").getBytes()));
        Message message = new Message("base", "Tag3", ("how do you do ").getBytes());
        message.putUserProperty("id","123");
        messages.add(message);
        producer.send(messages);
        producer.shutdown();
    }
}
