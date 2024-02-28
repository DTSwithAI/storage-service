package com.dts.storageserice.base.parent.model;


import com.dts.storageserice.base.parent.entity.AbstractAuditingEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

/*
 *NOTE: Every create and update request should extend this BaseRequest class
 * and must override create and update method
 *
 * */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseRequest<T extends AbstractAuditingEntity> {
    protected abstract T update(T entity);

    protected abstract T create();

    public T save(@Nullable T entity) {

        if (entity == null) {
            return create();
        }

        return update(entity);

    }
}
