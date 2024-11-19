package tn.esb.siad.smart_hotel_backend.Models;

import jakarta.persistence.*;
import lombok.*;
import tn.esb.siad.smart_hotel_backend.Enumerations.ServiceStatus;
import tn.esb.siad.smart_hotel_backend.Enumerations.ServiceType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "name")
@Entity
public class RoomService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(unique = true)
    private String name;
    private double price;
    private String description;
    private int rating;
    private ServiceStatus status;
    private ServiceType type;
     //implement the relationship between RoomService and reservation (*-*)
    @ManyToMany
    //create the association table
    @JoinTable(name="Consummation",
            joinColumns = @JoinColumn(name = "room_service_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservationList = new ArrayList<Reservation>();
}
