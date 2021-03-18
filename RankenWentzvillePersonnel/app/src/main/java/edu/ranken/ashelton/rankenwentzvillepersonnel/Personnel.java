package edu.ranken.ashelton.rankenwentzvillepersonnel;


import java.util.Comparator;

public class Personnel {
    //  Instance variables
    private int id;
    private String firstName;
    private String lastName;
    private String division;
    private String theImage;

    //  Constructor
    public Personnel(int id,
                     String firstName,
                     String lastName,
                     String division,
                     String theImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.division = division;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTheImage() {
        return theImage;
    }

    public void setTheImage(String theImage) {
        this.theImage = theImage;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + division + '\'' +
                ", theImage='" + theImage + '\'' +
                '}';
    }

    public static Comparator<Personnel> LastNameAscComparator = new Comparator<Personnel>() {
        @Override
        public int compare(Personnel p1, Personnel p2) {
            return p1.getLastName().compareTo((p2.getLastName()));
        }
    };

    public static Comparator<Personnel> LastNameDescComparator = new Comparator<Personnel>() {
        @Override
        public int compare(Personnel p1, Personnel p2) {
            return p2.getLastName().compareTo((p1.getLastName()));
        }
    };

    public static Comparator<Personnel> DivisionAscComparator = new Comparator<Personnel>() {
        @Override
        public int compare(Personnel p1, Personnel p2) {
            return p1.getDivision().compareTo((p2.getDivision()));
        }
    };

    public static Comparator<Personnel> DivisionDescComparator = new Comparator<Personnel>() {
        @Override
        public int compare(Personnel p1, Personnel p2) {
            return p2.getDivision().compareTo((p1.getDivision()));
        }
    };
}
