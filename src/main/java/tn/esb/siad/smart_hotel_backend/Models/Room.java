package tn.esb.siad.smart_hotel_backend.Models;

import jakarta.persistence.*;
import lombok.*;
import tn.esb.siad.smart_hotel_backend.Enumerations.RoomType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "id")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private RoomType type;

    //implement the relationship between Room and Hotel (*-1)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    //implement the relationship between Room and Expense (1-*)
    @OneToMany(mappedBy = "room")
    private List<Expense> expenseList = new ArrayList<Expense>();

}
