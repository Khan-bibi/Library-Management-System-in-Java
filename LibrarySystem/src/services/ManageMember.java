package services;
import model.User;
import model.Member;
import model.Staff;
import java.util.ArrayList;
import java.util.List;

public class ManageMember 
{
    private List<User> listOfUsers;

    //default constructor
    public ManageMember()
    {
        listOfUsers=new ArrayList<>();
    }

    //functions
    public void addMember(Member member)
    {
        listOfUsers.add(member);
    }

    public void addStaff(Staff staff)
    {
        listOfUsers.add(staff);
    }

    public User authenticateUser(String username, String password)
    {
        for(User user : listOfUsers)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers()
    {
        return listOfUsers;
    }

    public Member getMemberByID(int id)
    {
        for(User user : listOfUsers)
        {
            if(user instanceof Member && ((Member) user).getMembershipID()==id)
            {
                return (Member) user;
            }
        }
        return null;
    }

    public boolean editMember(int id, String newName, String newContact)
    {
        Member obj=getMemberByID(id);
        if(obj!=null)
        {
            obj.setName(newName);
            obj.setContactInfo(newContact);
            return true;
        }
        return false;
    }
}