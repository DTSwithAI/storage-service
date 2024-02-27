package com.dts.storageserice.base.parent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseFilter implements Serializable {
    Long id;
    Integer page;
    Integer size;
    String search;
    Date from;
    Date to;

    @JsonIgnore
    public Pageable getPageable(){
        return PageRequest.of(page, size);
    }
}
