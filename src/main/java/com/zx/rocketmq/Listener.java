package com.zx.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import static org.apache.rocketmq.spring.annotation.MessageModel.BROADCASTING;

/**
 * @Package: com.zx.rocketmq
 * @ClassName: linstener
 * @Author: xz
 * @Date: 2020/8/13 15:27
 * @Version: 1.0
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "springboot-rocketmq",consumerGroup = "springboot-rocketmq-consumer-1")
public class Listener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info(s);
    }
}
