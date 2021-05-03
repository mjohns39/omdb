package com.fourthwall.omdb.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "movies", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "imdbID")
    private String imdbID;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseDate")
    private ZonedDateTime releaseDate;

    @Column(name = "mpaRating")
    private String mpaRating;

    @Column(name = "runtimeInMinutes")
    private Integer runtimeInMinutes;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "writers")
    private String writers;

    @Column(name = "actors")
    private String actors;

    @Column(name = "plot")
    private String plot;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "awards")
    private String awards;

    @Column(name = "poster")
    private String poster;

    @Column(name = "metascore")
    private Integer metascore;

    @Column(name = "imdbRating")
    private Double imdbRating;

    @Column(name = "imdbVotes")
    private BigInteger imdbVotes;

    @Column(name = "type")
    private String type;

    @Column(name = "dvdReleaseDate")
    private ZonedDateTime dvdReleaseDate;

    @Column(name = "boxOfficeRevenue")
    private Double boxOfficeRevenue;

    @Column(name = "production")
    private String production;

    @Column(name = "website")
    private String website;

    @Column(name = "response")
    private boolean response;

    @OneToMany(mappedBy = "movie")
    private List<MovieShowtime> movieShowtimes;

    @OneToMany(mappedBy = "movie")
    private List<CriticRating> criticRatings;

    @OneToMany(mappedBy = "movie")
    private List<UserRating> userRatings;


    public Integer getYear() {
        return releaseDate.getYear();
    }

    public String getRuntime() {
        return runtimeInMinutes + " min";
    }

    public String getReleaseDate() {
        return releaseDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    public String getDvdReleaseDate() {
        return dvdReleaseDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
}
