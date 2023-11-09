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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Picked'"
    )
    public void wheneverPicked_DeliveryStart(@Payload Picked picked) {
        Picked event = picked;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + picked + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryStart(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
