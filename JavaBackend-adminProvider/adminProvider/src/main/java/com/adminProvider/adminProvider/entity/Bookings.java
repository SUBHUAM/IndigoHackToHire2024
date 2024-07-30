package com.adminProvider.adminProvider.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "passengerDetails")
@TypeDef(name = "jsonb",typeClass = JsonBinaryType.class)
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;

    private String bookingDate;

    private String flightNo;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="passengerDetails",columnDefinition = "jsonb")
    @JsonDeserialize(contentAs = PassengerDetails.class)
    private List<PassengerDetails> passengerDetails;

}
