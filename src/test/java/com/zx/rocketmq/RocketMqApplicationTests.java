package com.zx.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketMqApplicationTests {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        rocketMQTemplate.convertAndSend("springboot-rocketmq","hello rocketmq");
    }

}
