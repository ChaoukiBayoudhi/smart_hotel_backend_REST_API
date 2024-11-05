package tn.esb.siad.smart_hotel_backend.Models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Objects;

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

}
