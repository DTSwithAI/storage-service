package com.dts.storageserice.base.parent.service;

import com.dts.storageserice.base.exception.ExceptionWithStatusCode;
import com.dts.storageserice.base.parent.entity.AbstractAuditingEntity;
import com.dts.storageserice.base.parent.model.BaseFilter;
import com.dts.storageserice.base.parent.model.BaseRequest;
import com.dts.storageserice.base.parent.model.BaseResponse;
import com.dts.storageserice.base.parent.model.MessageKeys;
import com.dts.storageserice.base.parent.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.function.Supplier;

import static com.dts.storageserice.base.parent.model.MessageKeys.*;

public abstract class BaseService<ID, F extends BaseFilter, R extends BaseRepository<E, ID>, E extends AbstractAuditingEntity, RES extends BaseResponse<E, RES>, REQ extends BaseRequest<E>> {
    protected final R repository;

    protected final RES response;

    protected BaseService(R repository, RES response) {
        this.repository = repository;
        this.response = response;
    }

    RES create(REQ request){
        E e = request.save(null);
        return getResponse().convert(e);
    }

    RES update(ID id , REQ req){
        E e = findById(id);

        e =  req.save(e);
        return getResponse().convert(e);
    }

    protected E findById(ID id) {

        return getRepository().findById(id).orElseThrow(notFound());
    }
    public R getRepository() {
        return repository;
    }

    public RES getResponse() {
        return response;
    }

    public RES getById(ID id) {

        E e = findById(id);

        return response.convert(e);
    }

    public RES delete(ID id) {

        E e = findById(id);

        getRepository().delete(e);

        return response.convert(e);
    }

    public Page<RES> findAllByFilter(F filter) {
        return getRepository().findAll(getSpecifications(filter), filter.getPageable()).map(getResponse()::convert);
    }


    public List<RES> findAll() {
        return getRepository().findAll(PageRequest.of(0, 500)).map(getResponse()::convert).getContent();
    }

    public List<RES> getItems(F filter) {
        return getRepository().findAll(getSpecifications(filter), filter.getPageable()).map(getResponse()::convert).getContent();
    }

    protected abstract Specification<E> getSpecifications(F filter);

    protected Supplier<ExceptionWithStatusCode> badRequest(String messageKey) {
        return () -> new ExceptionWithStatusCode(400, messageKey);
    }

    protected Supplier<ExceptionWithStatusCode> badRequest() {
        return () -> new ExceptionWithStatusCode(400, BAD_REQUEST);
    }

    protected Supplier<ExceptionWithStatusCode> notFound() {
        return () -> new ExceptionWithStatusCode(404, NOT_FOUND);
    }

    protected Supplier<ExceptionWithStatusCode> notFound(String messageKey) {
        return () -> new ExceptionWithStatusCode(404, messageKey);
    }
}
