package edu.ranken.ashelton.rankenwentzvillepersonnel;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    //create the list that will hold personnel id, fn, ln, div, and image url.
    private static List<Personnel> PersonnelList = new ArrayList<Personnel>();
    //provides the nextId for a newly added personnel member.
    private static int nextId = 27;

    public MyApplication() {
        createPersonnelList();
    }

    public static List<Personnel> getPersonnelList() {
        return PersonnelList;
    }

    public static void setPersonnelList(List<Personnel> PersonnelList) {
        MyApplication.PersonnelList = PersonnelList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }

    private void createPersonnelList() {
        Personnel p0 = new Personnel(0, "Brandon", "Fann", "Admissions", "https://img.icons8.com/wired/40/000000/checklist.png");
        Personnel p1 = new Personnel(1, "Patrick", "Glynn", "Admissions", "https://img.icons8.com/wired/40/000000/checklist.png");
        Personnel p2 = new Personnel(2, "Timothy", "Chandler", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p3 = new Personnel(3, "Taylor", "Clark", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p4 = new Personnel(4, "Eric", "DeSplinter", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p5 = new Personnel(5, "Tim *AMT", "Michel", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p6 = new Personnel(6, "Lloyd", "Miller", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p7 = new Personnel(7, "Shawn", "Ray", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p8 = new Personnel(8, "Alan", "Townsend", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p9 = new Personnel(9, "Robert", "Vilmure", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p10 = new Personnel(10, "Louis", "Waite", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p11 = new Personnel(11, "Douglas", "Waldon", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p12 = new Personnel(12, "James", "Woods", "Automotive", "https://img.icons8.com/color/40/000000/mechanic.png");
        Personnel p13 = new Personnel(13, "John", "Baldwin", "Construction", "https://img.icons8.com/color/40/000000/toolbox.png");
        Personnel p14 = new Personnel(14, "Daniel", "Stevens", "Construction", "https://img.icons8.com/color/140/000000/toolbox.png");
        Personnel p15 = new Personnel(15, "James", "Gober", "Electrical", "https://img.icons8.com/office/40/000000/electrical.png");
        Personnel p16 = new Personnel(16, "Cory", "Hargett", "Electrical", "https://img.icons8.com/office/40/000000/electrical.png");
        Personnel p17 = new Personnel(17, "Matthew", "Leigh", "Electrical", "https://img.icons8.com/office/40/000000/electrical.png");
        Personnel p18 = new Personnel(18, "Dennis", "Pierce", "Electrical", "https://img.icons8.com/office/40/000000/electrical.png");
        Personnel p19 = new Personnel(19, "Charles", "Corrigan", "Information", "https://img.icons8.com/fluent/40/000000/system-information.png");
        Personnel p20 = new Personnel(20, "Chad", "Groharing", "Information", "https://img.icons8.com/fluent/40/000000/system-information.png");
        Personnel p21 = new Personnel(21, "Paul", "Knott", "Information", "https://img.icons8.com/fluent/40/000000/system-information");
        Personnel p22 = new Personnel(22, "Jeff", "Scott", "Information", "https://img.icons8.com/fluent/40/000000/system-information");
        Personnel p23 = new Personnel(23, "Brad", "Elbert", "Manufacturing", "https://img.icons8.com/officel/40/000000/cnc-machine.png");
        Personnel p24 = new Personnel(24, "Joseph", "Puglisi", "Manufacturing", "https://img.icons8.com/officel/40/000000/cnc-machine.png");
        Personnel p25 = new Personnel(25, "Shannon", "Brueggemann", "Education Office", "https://img.icons8.com/dotty/40/000000/education.png");
        Personnel p26 = new Personnel(26, "Justin", "Barnes", "Public Safety", "https://img.icons8.com/ios/40/000000/public-safety.png");

        PersonnelList.addAll(Arrays.asList(
                p0, p1, p2, p3, p4, p5, p6, p7, p8, p9,
                p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
                p20, p21, p22, p23, p24, p25, p26));
    }
}
