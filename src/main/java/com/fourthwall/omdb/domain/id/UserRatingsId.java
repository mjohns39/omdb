package com.fourthwall.omdb.domain.id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRatingsId implements Serializable {

    @Column(name = "userId")
    private String userId;

    @Column(name = "movieId")
    private Integer movieId;

}
