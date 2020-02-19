package com.example.salesapp.services.serviceImpl;

import com.example.salesapp.daos.SalesRepository;
import com.example.salesapp.documents.Sales;
import com.example.salesapp.entities.Stock;
import com.example.salesapp.proxy.BookAppProxy;
import com.example.salesapp.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private BookAppProxy bookAppProxy;

    @Override
    public List<Sales> getAll() {
        return salesRepository.findAll();
    }

    @Override
    public List<Sales> getAllByLibraryName(String name) {
        return salesRepository.findAllByLibraryName(name);
    }

    @Override
    public String addSale(Sales sale) {
        List<Stock> stocks = bookAppProxy.getStock(sale.getLibraryName(), sale.getBookName());
        if (!stocks.isEmpty() || stocks == null) {
            for (Stock stock : stocks) {
                if (stock.getQuantity() >= sale.getUnitsSold()) {
                    stock.setQuantity(stock.getQuantity() - sale.getUnitsSold());
                    if (bookAppProxy.updateStock(stock)) {
                        salesRepository.save(sale);
                        return "OK";
                    }
                }
            }
            return "there are not enough books";
        } else {
            return "library or book doesn't exist !!";
        }
        //return "";

    }


}
