package baeminseonmi.infra;

import baeminseonmi.config.kafka.KafkaProcessor;
import baeminseonmi.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeliveryListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeliveryListRepository deliveryListRepository;
    //>>> DDD / CQRS
}
