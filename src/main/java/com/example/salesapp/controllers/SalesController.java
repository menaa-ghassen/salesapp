package com.example.salesapp.controllers;

import com.example.salesapp.documents.Sales;
import com.example.salesapp.proxy.BookAppProxy;
import com.example.salesapp.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/sales")
    public List<Sales> getAllSales() {
        return salesService.getAll();
    }


    @GetMapping("/sales/{libraryName}")
    public List<Sales> getSalesByLibraryName(@PathVariable("libraryName") String name) {
        return salesService.getAllByLibraryName(name);
    }

    @PostMapping("/sales/add")
    public String addSale(@RequestBody Sales sale) {
        return salesService.addSale(sale);
    }
    
    /*@PostMapping("/sales/add-fake-data")
    public void addAll(@RequestBody List<Sales> sales){

        for (Sales s: sales) {
            addSale(s);
        }
    }*/
}
