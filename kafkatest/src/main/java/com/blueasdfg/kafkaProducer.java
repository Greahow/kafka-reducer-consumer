package com.blueasdfg;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import  kafka.javaapi.producer.Producer;

import java.util.Properties;


public class kafkaProducer {
     public static void main(String[] args) throws Exception{
          Properties props = new Properties();
          props.put("zk.connect","127.0.0.1:2181");
          props.put("metadata.broker.list","127.0.0.1:9092");
          props.put("serializer.class","kafka.serializer.StringEncoder");
          ProducerConfig config = new ProducerConfig(props);
          Producer<String, String> producer = new Producer<String, String>(config);

          for (int i=1; i<=100; i++){
               Thread.sleep(500);
               String msg = "Message Publishing Time - " + i;
               String topic = "test";
               KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, msg);
               producer.send(data);
          }















     }
}
