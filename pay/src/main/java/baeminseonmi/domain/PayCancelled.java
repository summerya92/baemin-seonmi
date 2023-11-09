package baeminseonmi.domain;

import baeminseonmi.domain.*;
import baeminseonmi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PayCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer price;
    private Long paymentMethodId;
    private String paymentMethodName;

    public PayCancelled(Pay aggregate) {
        super(aggregate);
    }

    public PayCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
