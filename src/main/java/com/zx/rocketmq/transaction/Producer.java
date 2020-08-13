package com.zx.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @Package: com.zx.rocketmq.order
 * @ClassName: Producer
 * @Author: xz
 * @Date: 2020/8/12 17:12
 * @Version: 1.0
 */
public class Producer {
    public static void main(String[] args) throws Exception{
        TransactionMQProducer producer = new TransactionMQProducer("group2");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if("Tag1".equals(msg.getTags())){
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if("Tag2".equals(msg.getTags())){
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else{
                    return LocalTransactionState.UNKNOW;
                }
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println(msg);
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        for (int i = 1; i < 4; i++) {
            Message message = new Message("base", "Tag"+i, ("hello world "+i).getBytes());
            producer.sendMessageInTransaction(message,null);
        }
//        producer.shutdown();
    }
}
