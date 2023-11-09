package baeminseonmi.domain;

import baeminseonmi.domain.*;
import baeminseonmi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String userId;
    private Long restaurantId;
    private String restaurantName;
    private Long menuId;
    private String menuName;
    private Integer qty;
    private Date orderDt;
    private String userAddress;

    public OrderRejected(Order aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}
//>>> DDD / Domain Event
