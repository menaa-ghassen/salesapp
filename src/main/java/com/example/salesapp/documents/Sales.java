package com.example.salesapp.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "sales")
public class Sales implements Serializable {
    @Id
    private ObjectId _id;
    private String libraryName;
    private String bookName;
    private double bookPrice;
    private int unitsSold;

    public Sales() {
    }

    public Sales(String libraryName, String bookName, double bookPrice, int unitsSold) {
        this.libraryName = libraryName;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.unitsSold = unitsSold;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }


    @Override
    public String toString() {
        return "Sales{" +
                "_id=" + _id +
                ", libraryName='" + libraryName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", unitsSold=" + unitsSold +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Double.compare(sales.bookPrice, bookPrice) == 0 &&
                unitsSold == sales.unitsSold &&
                Objects.equals(_id, sales._id) &&
                Objects.equals(libraryName, sales.libraryName) &&
                Objects.equals(bookName, sales.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, libraryName, bookName, bookPrice, unitsSold);
    }
}
