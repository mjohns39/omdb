package com.fourthwall.omdb.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "movie_showtimes", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MovieShowtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "dayOfWeek")
    private Integer dayOfWeek;

    @Column(name = "minuteOfDay")
    private Integer minuteOfDay;

    @Column(name = "price")
    private BigDecimal price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="movieId", insertable=false, updatable = false)
    private Movie movie;

}
