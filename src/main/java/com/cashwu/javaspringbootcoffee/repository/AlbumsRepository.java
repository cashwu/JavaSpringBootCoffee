package com.cashwu.javaspringbootcoffee.repository;

import com.cashwu.javaspringbootcoffee.model.Albums;
import org.springframework.data.repository.CrudRepository;

/**
 * @author cash.wu
 * @since 2024/07/08
 */

public interface AlbumsRepository extends CrudRepository<Albums, String> {
}
