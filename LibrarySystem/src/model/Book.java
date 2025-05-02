package model;
import java.time.LocalDate;

public class Book extends LibraryItem //Book is the derived class and Library Item is the base class. Book is inherited from Library Item
{
    //parameterized constructor
    public Book(String title, String author, LocalDate pDate, String category)
    {
        super(title, author, pDate, category); //super is used in java for accessing members/func of parent class from a derived class
    }

    @Override
    public String getItemType()
    {
        return "Book";
    }
}