package model;

public class Member extends User //inheritance (Member inherits User class)
{
    //data members
    private int mID; //membershipID
    private String contactInfo;

    //parameterized constructor
    public Member(String username, String password, String name, int mID, String contactInfo)
    {
        super(username, password, name);
        this.mID=mID;
        this.contactInfo=contactInfo;
    }

    //getters
    public int getMembershipID()
    {
        return mID;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    //setters
    public void setName(String name)
    {
        this.name=name;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo=contactInfo;
    }

    @Override
    public String getRole()
    {
        return "Member";
    }
}