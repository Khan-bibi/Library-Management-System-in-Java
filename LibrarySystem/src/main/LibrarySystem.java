package main;
import model.*;
import services.*;
import userinterface.TextUi;

//THIS IS THE INITIATOR/DRIVER CLASS THAT WILL CREATE OBJECTS AND RUN THE PROGRAM

public class LibrarySystem
{
    public static void main(String[] args)
    {
        //creating objects of these classes
        LibraryCatalog catalog=new LibraryCatalog();
        ManageMember userManager=new ManageMember();
        ManageLoan loanManager=new ManageLoan();

        //created these staff/members for default testing, can also be removed
        if(userManager.getUsers().isEmpty())
        {
            userManager.addStaff(new Staff("admin", "admin123", "Librarian"));
            userManager.addMember(new Member("Member1", "member123", "Elizabeth", 1001, "Elizabeth@gmail.com"));
        }

        TextUi obj=new TextUi(catalog, userManager, loanManager);
        obj.beginSystem();
    }
}