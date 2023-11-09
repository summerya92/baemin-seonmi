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
    PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cancelled'"
    )
    public void wheneverCancelled_CancelPay(@Payload Cancelled cancelled) {
        Cancelled event = cancelled;
        System.out.println(
            "\n\n##### listener CancelPay : " + cancelled + "\n\n"
        );

        // Sample Logic //
        Pay.cancelPay(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
