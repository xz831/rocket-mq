package com.zx.rocketmq.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

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
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base","Tag1",String.valueOf(i),("hello world " + i).getBytes());
            producer.send(message, (list, message1, o) -> {
                int i1 = Integer.parseInt(String.valueOf(o));
                int i2 = i1 % list.size();
                return list.get(i2);
            },"1");
        }
        producer.shutdown();
    }
}
