package baeminseonmi.domain;

import baeminseonmi.domain.*;
import baeminseonmi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private Long restaurantId;
    private String restaurantName;
    private Long menuId;
    private String menuName;
    private Integer qty;
    private String status;

    public Picked(Delivery aggregate) {
        super(aggregate);
    }

    public Picked() {
        super();
    }
}
//>>> DDD / Domain Event
