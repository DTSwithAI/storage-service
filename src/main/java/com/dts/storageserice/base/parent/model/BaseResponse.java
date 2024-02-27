package com.dts.storageserice.base.parent.model;


import com.dts.storageserice.base.parent.entity.AbstractAuditingEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseResponse<E extends AbstractAuditingEntity, R extends BaseResponse<E,R> > {

    protected abstract R convertToResponse(E e);

    public R convert(E e) {
        beforeConvert(e);
        R response = convertToResponse(e);
        return afterConvert(e, response);
    }


    public void beforeConvert(E entity) {
        // TODO: 2/27/2024 some logic if necessary 
    }
    public R afterConvert(E entity, R response) {
        // TODO: 2/27/2024 some logic if necessary  
        return response;
    }

}
