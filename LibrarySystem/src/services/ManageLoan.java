package services;
import model.LibraryItem;
import model.Loan;
import model.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageLoan
{
    private List<Loan> listOfLoans;

    public ManageLoan()
    {
        listOfLoans=new ArrayList<>();
    }

    public boolean borrowItem(Member member, LibraryItem item, LocalDate date)
    {
        if(!item.isAvailable())
        {
            return false;
        }
        listOfLoans.add(new Loan(item, member, date));
        return true;
    }

    public boolean returnItem(String title, Member member, LocalDate rDate)
    {
        for(Loan loan : listOfLoans)
        {
            if(loan.getItem().getTitle().equalsIgnoreCase(title) && loan.getBorrowPerson().equals(member) && !loan.isItemReturned())
            {
                loan.returnItem(rDate);
                return true;
            }
        }

        return false;
    }

    public List<Loan> getLoanByMember(Member member)
    {
        List<Loan> rslt=new ArrayList<>();
        for(Loan loan : listOfLoans)
        {
            if(loan.getBorrowPerson().equals(member))
            {
                rslt.add(loan);
            }
        }

        return rslt;
    }

    public void printListOfLoans()
    {
        System.out.println("ALL LOANS: ");
        for(Loan loan : listOfLoans)
        {
            System.out.println(loan);
        }
    }
}