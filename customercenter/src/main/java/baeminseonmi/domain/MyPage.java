package baeminseonmi.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private Long orderId;
    private String restaurantName;
    private String menuName;
    private Integer qty;
    private Date orderDt;
    private String status;
    private String price;
}
