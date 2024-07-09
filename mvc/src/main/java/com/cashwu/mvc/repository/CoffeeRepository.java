package com.cashwu.mvc.repository;

import com.cashwu.mvc.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author cash.wu
 * @since 2024/07/09
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
