package tn.esb.siad.smart_hotel_backend.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "id")
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(precision = 10,scale = 2)
    private BigDecimal amount;
    @Column(length = 150, nullable = true)
    private String description;

    //implement the relationship between expense and Room (*-1)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="room_id", referencedColumnName = "id", nullable = true)
    private Room room;


}
