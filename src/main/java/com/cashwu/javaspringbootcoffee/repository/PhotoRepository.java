package com.cashwu.javaspringbootcoffee.repository;

import com.cashwu.javaspringbootcoffee.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cash.wu
 * @since 2024/07/08
 */
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
