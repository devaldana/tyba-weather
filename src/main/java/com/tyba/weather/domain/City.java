package com.tyba.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Data
@Entity
public class City extends BaseEntity {
    private String name;
    private LocalDateTime queryDate = LocalDateTime.now();
    @JsonIgnore @ManyToOne private User user;
}
