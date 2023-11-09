package baeminseonmi.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "OrderList_table")
@Data
public class OrderList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
