package services;
import model.Book;
import model.Magazine;
import model.LibraryItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog 
{
    private List<LibraryItem> listOfItems;

    //default constructor
    public LibraryCatalog()
    {
        this.listOfItems=new ArrayList<>();
    }

    //functions
    public void addBook(String title, String author, LocalDate pDate, String category)
    {
        listOfItems.add(new Book(title, author, pDate, category));
      
    }

    public void addMagazine(String title, String author, LocalDate pDate, String category)
    {
        listOfItems.add(new Magazine(title, author, pDate, category));
    }

    public List<LibraryItem> getListOfItems()
    {
        return listOfItems;
    }

    public LibraryItem findItemByTitle(String title)
    {
        for(LibraryItem item : listOfItems)
        {
            if(item.getTitle().equalsIgnoreCase(title))
            {
                return item;
            }
        }
        return null;
    }

    public boolean removeItem(String title)
    {
        LibraryItem itemToBeRemoved=findItemByTitle(title);
        if(itemToBeRemoved!=null)
        {
            listOfItems.remove(itemToBeRemoved);
            return true; //deletion successful
        }

        return false;
    }

    public void printItems()
    {
        if(listOfItems.isEmpty())
        {
            System.out.println("\nNothing to show! Catalog is empty.");
        }
        else 
        {
            System.out.println("\nItems in Catalog: \n");
            for(LibraryItem item : listOfItems)
            {
                System.out.println(item);
            }
        }
    }

    public boolean editItem(String existingTitle, String newTitle, String newAuthor, LocalDate newPubDate, String newCategory)
    {
        LibraryItem obj=findItemByTitle(existingTitle);

        if(obj!=null)
        {
            obj.setTitle(newTitle);
            obj.setCategory(newCategory);
            obj.setAuthor(newAuthor);
            obj.setPubDate(newPubDate);
            return true;
        }
        return false;
    }
}