package model;

//I am going to make a user class which will contain some common attributes which are to be 
//used by both member and staff hence i will inherit both these classes from user (Inheritance)

public abstract class User
{

    //data members
    private String username;
    private String password;
    protected String name;


    //parameterized constructor
    public User(String username, String password, String name)
    {
        this.username=username;
        this.password=password;
        this.name=name;

    }

    public abstract String getRole(); //either member or staff. This func is overridden by Staff and Member classes

    //getters
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return String.format("%s (%s)", name, getRole());
    }
}