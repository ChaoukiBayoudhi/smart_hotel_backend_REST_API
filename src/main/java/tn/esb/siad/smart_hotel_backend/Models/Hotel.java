package tn.esb.siad.smart_hotel_backend.Models;


import jakarta.persistence.*;
import lombok.*;
import tn.esb.siad.smart_hotel_backend.Enumerations.HotelRating;

import java.util.HashSet;
import java.util.Set;

@Getter //generates all getters methods for private or protected fields
@Setter //generates all setters methods for private or protected fields
@AllArgsConstructor //generates a constructor with all fields as arguments
@RequiredArgsConstructor //generates a constructor with only required fields as arguments (fields annotated with NonNull)
@NoArgsConstructor  //generates a constructor without parameters
@ToString //generates redefinition of toString() method (returns value of all fields)
//@EqualsAndHashCode //generates redefinition of equals and hashCode methods using all fields
//@EqualsAndHashCode(onlyExplicitlyIncluded = true) //only fields annotated with @EqualsAndHashCode.Include are used to compare objects
@EqualsAndHashCode(of="name") //compare Hotel objects by name
@Entity
public class Hotel {
    @Id //primary key
    //id is auto-generated
    //IDENTITY to say that the first inserted Hotel has the id = 1, the second has id=2, ...
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //@EqualsAndHashCode.Include
    @Column(length=100,unique = true)
    @NonNull //the name is required
    private String name;
    @Enumerated(EnumType.STRING)
    private HotelRating rating;

    //implement the 1-1 relationship between Hotel and Address
    @OneToOne(mappedBy = "hotel", cascade=CascadeType.ALL)
    //in SQL address_id foreign key references Address(id)
    @JoinColumn(name="address_id", referencedColumnName="id", nullable=false)
    private Address address;

    //implement the relationship between Hotel and Room (1-*)
    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms = new HashSet<>();
}
