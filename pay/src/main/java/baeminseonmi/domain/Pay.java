package baeminseonmi.domain;

import baeminseonmi.PayApplication;
import baeminseonmi.domain.Paid;
import baeminseonmi.domain.PayCancelled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pay_table")
@Data
//<<< DDD / Aggregate Root
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Integer price;

    private Long paymentMethodId;

    private String paymentMethodName;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        PayCancelled payCancelled = new PayCancelled(this);
        payCancelled.publishAfterCommit();
    }

    public static PayRepository repository() {
        PayRepository payRepository = PayApplication.applicationContext.getBean(
            PayRepository.class
        );
        return payRepository;
    }

    //<<< Clean Arch / Port Method
    public static void cancelPay(Cancelled cancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        PayCancelled payCancelled = new PayCancelled(pay);
        payCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cancelled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);

            PayCancelled payCancelled = new PayCancelled(pay);
            payCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
