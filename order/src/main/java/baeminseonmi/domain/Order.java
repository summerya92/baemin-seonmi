package baeminseonmi.domain;

import baeminseonmi.OrderApplication;
import baeminseonmi.domain.Cancelled;
import baeminseonmi.domain.OrderAccepted;
import baeminseonmi.domain.OrderNotified;
import baeminseonmi.domain.OrderRejected;
import baeminseonmi.domain.Ordered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PostPersist
    public void onPostPersist() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        OrderNotified orderNotified = new OrderNotified(this);
        orderNotified.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        Cancelled cancelled = new Cancelled(this);
        cancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyOrder(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderNotified orderNotified = new OrderNotified(order);
        orderNotified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderNotified orderNotified = new OrderNotified(order);
            orderNotified.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
