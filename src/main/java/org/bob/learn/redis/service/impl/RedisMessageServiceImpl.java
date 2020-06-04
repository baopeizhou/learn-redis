package org.bob.learn.redis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bob.learn.redis.common.util.JacksonUtils;
import org.bob.learn.redis.service.RedisMessageService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.util.ByteUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisMessageServiceImpl implements MessageListener, RedisMessageService {

    /**
     * 监听Redis消息，根据通道进行消息分发处理
     * @param message
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        log.info("监听到Redis[{}]通道消息[{}]",fromBytes(message.getChannel()),fromBytes(message.getBody()));
        message.getChannel();
        if(Channel.CONFIG.name().equals(fromBytes(message.getChannel()))){
            this.configMessage(message);
        }

    }


    @Override
    public void configMessage(Message message) {
        log.info(message.getBody().toString());

    }


    private String fromBytes(byte[] bytes){
       return new String(bytes);

    }
}
