package model;

public class Staff extends User  //inheritance (Staff inherits User class)
{
    //parameterized constructor
    public Staff(String username, String password, String name)
    {
        super(username, password, name);
    }

    @Override
    public String getRole()
    {
        return "Staff";
    }

}