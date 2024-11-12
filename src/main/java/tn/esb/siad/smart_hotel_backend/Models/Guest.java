package tn.esb.siad.smart_hotel_backend.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "id")
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=8,nullable = true)
    private String cin;
    @Column(length=10, nullable = true)
    private String passportNumber;
    private String name;
    private String familyName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
