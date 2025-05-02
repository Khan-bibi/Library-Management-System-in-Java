package model;
import java.time.LocalDate;

public class Magazine extends LibraryItem //Magazine is the derived class and Library Item is the base class. Magazine is inherited from Library Item
{
    //parameterized constructor
    public Magazine(String title, String author, LocalDate pDate, String category)
    {
        super(title, author, pDate, category); 
    }

    @Override
    public String getItemType()
    {
        return "Magazine";
    }

}