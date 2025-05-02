package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan 
{
    private static final double OVERDUE_FEE=0.25; //keeping a default fee fine if book is returned late

    //data members
    private LibraryItem item;
    private Member borrowPerson;
    private LocalDate cDate;    //checkout date
    private LocalDate dDate;    //due date
    private LocalDate rDate;    //return date


    //parameterized constructor
    public Loan(LibraryItem item, Member borrowPerson, LocalDate cDate)
    {
        this.item=item;
        this.borrowPerson=borrowPerson;
        this.cDate=cDate;
        this.dDate=cDate.plusWeeks(1); //keeping default 1-week loan
        this.rDate=null;
        this.item.setFlag(false); //marking item as checked out
    }

    //getters
    public LibraryItem getItem()
    {
        return item;
    }

    public Member getBorrowPerson()
    {
        return borrowPerson;
    }

    public LocalDate getcDate()
    {
        return cDate;
    }

    public LocalDate getdDate()
    {
        return dDate;
    }

    public LocalDate getrDate()
    {
        return rDate;
    }

    public boolean isItemReturned()
    {
        return rDate!=null;
    }

    //functions
    public void returnItem(LocalDate rDate)
    {
        this.rDate=rDate;
        item.setFlag(true);
    }

    public double calculateOverdueFee()
    {
        if(!isItemReturned())
        {
            return 0.0;
        }

        long days;
        days=ChronoUnit.DAYS.between(dDate, rDate);
        return (days>0) ? days * OVERDUE_FEE : 0.0;
    }

    @Override
    public String toString()
    {
        return String.format("\nLoan of %s to %s | Due: %s | Returned: %s | Fee: £%.2f", item.getTitle(), borrowPerson.getName(), dDate, isItemReturned() ? rDate.toString() : "Not Returned", isItemReturned() ? calculateOverdueFee() : 0.0);
    }
}

