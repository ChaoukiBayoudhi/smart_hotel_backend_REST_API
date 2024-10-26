package tn.esb.siad.smart_hotel_backend.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import tn.esb.siad.smart_hotel_backend.Enumerations.HotelRating;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length=100,unique = true)
    @NonNull //the name is required
    private String name;
    private HotelRating rating;

}
