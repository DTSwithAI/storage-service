package com.dts.storageserice.base.parent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/*
 *NOTE: Every repository should implement this repository
 *
 * */
@NoRepositoryBean
public interface BaseRepository<E,ID> extends JpaRepository<E,ID> , JpaSpecificationExecutor<E> {
}
