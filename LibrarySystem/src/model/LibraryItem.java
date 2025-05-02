package model;
import java.time.LocalDate;

//keeping this class as abstract (abstraction) because Book and Magazine classes are derived from it.
//we do not need LibraryItem functionalities solely itself, we have kept it as a general item
//and then we have further catagorized it as Book or magazine. We do not have to create direct Objects of LibraryItem
//and it also supports one of the main principles of OOP i.e Abstraction

public abstract class LibraryItem 
{
    
    //data members/attributes
    private String title;
    private String author;
    private LocalDate pDate;   //publication date
    private String category;
    private boolean flag;      //for availability status of book


    //parameterized constructor
    public LibraryItem(String title, String author, LocalDate pDate, String category)
    {
        this.title=title;
        this.author=author;
        this.pDate=pDate;
        this.category=category;
        this.flag=true;
    }

    public abstract String getItemType(); //this function will be overriden by Book and Magazine classes

    //getters
    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getCategory()
    {
        return category;
    }

    public LocalDate getPdate()
    {
        return pDate;
    }

    public boolean isAvailable()
    {
        return flag;
    }

    //setters
    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }

    public void setCategory(String category)
    {
        this.category=category;
    }

    public void setPubDate(LocalDate pDate)
    {
        this.pDate=pDate;
    }

    public void setFlag(boolean available)
    {
        flag=available;
    }
    
    public String toString()
    {
        return String.format("[%s] %s by %s (%s) | Category: %s | %s", getItemType(), title, author, pDate, category, flag ? "Available" : "Checked Out");
    }

}