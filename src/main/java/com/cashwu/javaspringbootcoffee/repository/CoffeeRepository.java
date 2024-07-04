package com.cashwu.javaspringbootcoffee.repository;

import com.cashwu.javaspringbootcoffee.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author cash.wu
 * @since 2024/07/04
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
