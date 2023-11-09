package baeminseonmi.infra;

import baeminseonmi.config.kafka.KafkaProcessor;
import baeminseonmi.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_NotifyOrder(@Payload Paid paid) {
        Paid event = paid;
        System.out.println("\n\n##### listener NotifyOrder : " + paid + "\n\n");

        // Sample Logic //
        Order.notifyOrder(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
