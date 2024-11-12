package tn.esb.siad.smart_hotel_backend.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "id")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String street;
    private String city;
    @NonNull
    private String state;
    private String country;
    @NonNull
    private String zipCode;

    //implement the 1-1 relationship between Address and Hotel
    @OneToOne
    private Hotel hotel;


}
