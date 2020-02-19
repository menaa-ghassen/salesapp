package com.example.salesapp.proxy;

import com.example.salesapp.entities.Book;
import com.example.salesapp.entities.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bookapp", url = "localhost:8080")//book-app-container
public interface BookAppProxy {
    @GetMapping(value = "/books/{libName}")
    List<Book> getLib(@PathVariable(value = "libName") String name);

    @GetMapping(value = "/stock/{libName}&{bookName}")
    List<Stock> getStock(@PathVariable(value = "libName") String libName, @PathVariable(value = "bookName") String bookName);

    @PutMapping(value = "/stock/update")
    boolean updateStock(@RequestBody Stock stock);
}
