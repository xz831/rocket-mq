package com.zx.rocketmq.base;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * @Package: com.zx.rocketmq.base
 * @ClassName: SyncProducer
 * @Author: xz
 * @Date: 2020/8/12 15:14
 * @Version: 1.0
 */
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base","Tag1",("hello world " + i).getBytes());
            SendResult send = producer.send(message);
            System.out.println(send.getSendStatus());
            System.out.println(send.getMsgId());
            System.out.println(send.getMessageQueue().getQueueId());
            TimeUnit.SECONDS.sleep(1);
        }
        producer.shutdown();
    }
}
