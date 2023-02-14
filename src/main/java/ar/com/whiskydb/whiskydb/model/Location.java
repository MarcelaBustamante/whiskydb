package ar.com.whiskydb.whiskydb.model;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private String country;
    private String province;
    private String city;
}
