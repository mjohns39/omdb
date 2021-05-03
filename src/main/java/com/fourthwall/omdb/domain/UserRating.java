package com.fourthwall.omdb.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fourthwall.omdb.domain.id.UserRatingsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_ratings", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRating {


    @EmbeddedId
    private UserRatingsId id;

    @Column(name = "rating")
    private Integer rating;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userId", insertable=false, updatable = false)
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="movieId", insertable=false, updatable = false)
    private Movie movie;



}
