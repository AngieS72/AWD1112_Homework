package edu.ranken.jpscott.presidents;

import java.util.Comparator;

public class President {
    //  Instance variables
    private int id;
    private String firstName;
    private String lastName;
    private String served;
    private String theImage;

    //  Constructor
    public President(int id,
                     String firstName,
                     String lastName,
                     String served,
                     String theImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.served = served;
        this.theImage = theImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String getTheImage() {
        return theImage;
    }

    public void setTheImage(String theImage) {
        this.theImage = theImage;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", served='" + served + '\'' +
                ", theImage='" + theImage + '\'' +
                '}';
    }

    public static Comparator<President> LastNameAscComparator = new Comparator<President>()
    {
        @Override
        public int compare(President p1, President p2) {
            return p1.getLastName().compareTo((p2.getLastName()));
        }
    };

    public static Comparator<President> LastNameDescComparator = new Comparator<President>()
    {
        @Override
        public int compare(President p1, President p2) {
            return p2.getLastName().compareTo((p1.getLastName()));
        }
    };

    public static Comparator<President> TermAscComparator = new Comparator<President>()
    {
        @Override
        public int compare(President p1, President p2) {
            return p1.getServed().compareTo((p2.getServed()));
        }
    };

    public static Comparator<President> TermDescComparator = new Comparator<President>()
    {
        @Override
        public int compare(President p1, President p2) {
            return p2.getServed().compareTo((p1.getServed()));
        }
    };
}
