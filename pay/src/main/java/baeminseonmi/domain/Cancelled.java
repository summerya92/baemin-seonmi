package baeminseonmi.domain;

import baeminseonmi.domain.*;
import baeminseonmi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cancelled extends AbstractEvent {

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
    private String status;
}
