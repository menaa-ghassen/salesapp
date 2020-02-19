package com.example.salesapp.daos;

import com.example.salesapp.documents.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SalesRepository extends MongoRepository<Sales, Long> {
    List<Sales> findAll();

    List<Sales> findAllByLibraryName(String name);
}
