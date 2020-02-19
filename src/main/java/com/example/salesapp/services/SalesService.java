package com.example.salesapp.services;

import com.example.salesapp.documents.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getAll();

    List<Sales> getAllByLibraryName(String name);

    String addSale(Sales sale);

}
