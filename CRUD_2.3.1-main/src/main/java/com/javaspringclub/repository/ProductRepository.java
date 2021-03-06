package com.javaspringclub.repository;

import com.javaspringclub.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends CrudRepository<Product, Long> {  // Spring Data предоставляет абстракцию CrudRepository,
                                                                      // которая типизируется целевой сущностью
                                                                     // и её id. CrudRepository имеет набор базовых методов для работы
                                                                     // с сущностью, названия которых говорят сами за себя:

}