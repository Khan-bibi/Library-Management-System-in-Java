package userinterface;
import model.*;
import services.*;
import utils.CheckInput;
import java.time.LocalDate;
import java.util.List;

//I HAVE CREATED TWO DIFFERENT MENU VIEWS: ONE FOR STAFF AND ONE FOR MEMBERS 
//AS BOTH SOME DIFFERENT TASKS AND FUNCTIONALITES AND ACCORDING TO REAL-WORLD EXAMPLE, THIS WAS THE SUITED OPTION
//ALSO IMPLEMENTED AUTHENTICATION LIKE STAFF/MEMBERS WILL FIRST HAVE TO LOGIN TO USE THE SYSTEM

public class TextUi
{
    private LibraryCatalog catalog;
    private ManageMember userManager;
    private ManageLoan loanManager;

    public TextUi(LibraryCatalog catalog, ManageMember userManager, ManageLoan loanManager)
    {
        this.catalog=catalog;
        this.userManager=userManager;
        this.loanManager=loanManager;
    }

    public void beginSystem()
    {
        System.out.println("\n\n=== WELCOME TO THE LIBRARY MANAGEMENT SYSTEM ===");

        while(true)
        {
            String username=CheckInput.getInputString("\n\nUserName (or type 'exit' to quit): ");
            if(username.equalsIgnoreCase("exit"))
            {
                System.out.println("System is shutting down. Goodbye!");
                break;
            }

            String password=CheckInput.getInputString("Password: ");

            User userObj=userManager.authenticateUser(username, password);
            if(userObj!=null)
            {
                System.out.println("\nYOUR LOGIN IS SUCCESSFUL! Welcome, " + userObj.getName() + " (" + userObj.getRole() + ")");
                if(userObj instanceof Staff)
                {
                    staffView((Staff) userObj);
                }
                else if(userObj instanceof Member)
                {
                    memberView((Member) userObj);
                }
            }
            else 
            {
                System.out.println("\nSORRY LOGIN FAILED! Try again.\n");
            }
        }
    }

    //STAFF MENU
    private void staffView(Staff staff)
    {
        while(true)
        {
            System.out.println("\n--- STAFF MENU ---\n");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. View Library Catalog");
            System.out.println("4. Remove Item");
            System.out.println("5. Register Member");
            System.out.println("6. View List of Loans");
            System.out.println("7. Edit Member");
            System.out.println("8. Edit Catalog Item");
            System.out.println("0. Logout");

            int ch;
            ch=CheckInput.getInput("\nEnter your choice: ");

            switch(ch)
            {
                case 1 -> addItem(true);
                case 2 -> addItem(false);
                case 3 -> catalog.printItems();
                case 4 -> removeItem();
                case 5 -> registerMember();
                case 6 -> loanManager.printListOfLoans();
                case 7 -> editMember();
                case 8 -> editCatalogItem();
                case 0 -> 
                {
                    System.out.println("\nLogging out..");
                    return;
                }
                default -> System.out.println("\nInvalid choice sorry!");
            }
        }
    }

    //MEMBER VIEW 
    private void memberView(Member member)
    {
        while(true)
        {
            System.out.println("\n--- MEMBER MENU ---\n");
            System.out.println("1. View Library Catalog");
            System.out.println("2. Borrow Item");
            System.out.println("3. Return Item");
            System.out.println("4. View My Loans");
            System.out.println("0. Logout");

            int ch;
            ch=CheckInput.getInput("\nEnter your choice: ");

            switch(ch)
            {
                case 1 -> catalog.printItems();
                case 2 -> borrowItem(member);
                case 3 -> returnItem(member);
                case 4 -> viewLoans(member);
                case 0 -> 
                {
                    System.out.println("\nLogging out..");
                    return;
                }
                default -> System.out.println("\nInvalid choice sorry!\n");
            }
        }
    }

    private void addItem(boolean isBook)
    {
        String title=CheckInput.getInputString("\nTitle: ");
        String author=CheckInput.getInputString("Author: ");
        LocalDate pDate=CheckInput.getInputDate("Publication Date: ");
        String category=CheckInput.getInputString("Category: ");

        if(isBook) //if its a book, add in book section
        {
            catalog.addBook(title, author, pDate, category);
        }
        else //if its a magazine, add in magazine section
        {
            catalog.addMagazine(title, author, pDate, category);
        }
        System.out.println("\nItem Added Successfully!\n");
    }

    private void removeItem()
    {
        String title=CheckInput.getInputString("\nTitle which needs to be removed: ");
        boolean flag=catalog.removeItem(title);
        System.out.println(flag ? "\nItem Removed Successfully!\n" : "\nItem not found!\n");
    }

    private void registerMember()
    {
        String name=CheckInput.getInputString("\nName: ");
        int id=CheckInput.getInput("Membership ID: ");
        String contact=CheckInput.getInputString("Contact Info: ");
        String username=CheckInput.getInputString("Username: ");
        String password=CheckInput.getInputString("Password: ");

        Member newMem=new Member(username, password, name, id, contact);
        userManager.addMember(newMem);
        System.out.println("\nMember Registered Successfully!\n");
    }

    private void borrowItem(Member member)
    {
        String title=CheckInput.getInputString("\nTitle of Item to borrow: ");
        LibraryItem item=catalog.findItemByTitle(title);

        if(item==null)
        {
            System.out.println("\nSorry! Item not found.\n");
        }
        else if(!item.isAvailable())
        {
            System.out.println("\nItem is already borrowed/checked out.\n");
        }
        else
        {
            boolean flag=loanManager.borrowItem(member, item, LocalDate.now());
            System.out.println(flag ? "\nItem Borrowed Successfully!\n" : "\nSorry, Borrow failed\n");
        }
    }

    private void returnItem(Member member)
    {
        String title=CheckInput.getInputString("\nTitle of Item return: ");
        boolean flag=loanManager.returnItem(title, member, LocalDate.now());
        System.out.println(flag ? "\nItem Returned Succesfully\n" : "\nSorry, Return failed. Check title or loan status.\n");
    }

    private void viewLoans(Member member)
    {
        List<Loan> listOfLoans=loanManager.getLoanByMember(member);

        if(listOfLoans.isEmpty())
        {
            System.out.println("\nCurrently there are no loans\n");
        }
        else 
        {
            for(Loan loan : listOfLoans)
            {
                System.out.println(loan);
            }
        }
    }

    private void editMember()
    {
        int id=CheckInput.getInput("\nEnter the id of member to edit: ");
        String newName=CheckInput.getInputString("Enter new name: ");
        String newContact=CheckInput.getInputString("Enter new contact info: ");
        boolean flag=userManager.editMember(id, newName, newContact);
        System.out.println(flag ? "\nMember edited" : "\nMember not found");
    }

    private void editCatalogItem()
    {
        String existingTitle=CheckInput.getInputString("\nEnter the current title of the item: ");
        String newTitle=CheckInput.getInputString("Enter new title: ");
        String newAuthor=CheckInput.getInputString("Enter new author: ");
        LocalDate newPubDate=CheckInput.getInputDate("Enter new publication date: ");
        String newCategory=CheckInput.getInputString("Enter new category: ");
        boolean flag=catalog.editItem(existingTitle, newTitle, newAuthor, newPubDate, newCategory);
        System.out.println(flag ? "\nItem updated successfully!" : "\nItem not found");
    }

}

