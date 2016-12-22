package com.mytest.cloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by jinwen on 2016/12/18.
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class StreamdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamdemoApplication.class, args);
    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT)
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>(new SimpleDateFormat().format(new Date()));
    }

}
