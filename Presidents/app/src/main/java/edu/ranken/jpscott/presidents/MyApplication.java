package edu.ranken.jpscott.presidents;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    //create the list that will hold president id, fn, ln, term, and image url.
    private static List<President> presidentList = new ArrayList<President>();
    //provides the nextId for a newly added personnel member.
    private static int nextId = 46;

    public MyApplication() {
        createPresidentList();
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }

    private void createPresidentList() {
        President p0  = new President (0, "George", 		"Washington", 		"1789 – 1797", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/01_george_washington.jpg");
        President p1  = new President (1, "John", 			"Adams", 			"1797 – 1801", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/02_john_adams.jpg");
        President p2  = new President (2, "Thomas", 		"Jefferson", 		"1801 – 1809", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/03_thomas_jefferson.jpg");
        President p3  = new President (3, "James", 			"Madison", 			"1809 – 1817", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/04_james_madison.jpg");
        President p4  = new President (4, "James", 			"Monroe", 			"1817 – 1825", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/05_james_monroe.jpg");
        President p5  = new President (5, "John Q.", 		"Adams", 			"1825 – 1829", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/06_john_quincy_adams.jpg");
        President p6  = new President (6, "Andrew", 		"Jackson", 			"1829 – 1837", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/07_andrew_jackson.jpg");
        President p7  = new President (7, "Martin", 		"Van Buren", 		"1837 – 1841", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/08_martin_van_buren.jpg");
        President p8  = new President (8, "William H.",		"Harrison", 		"1841", 		"https://www.whitehouse.gov/wp-content/uploads/2021/01/09_william_henry_harrison.jpg");
        President p9  = new President (9, "John", 			"Tyler", 			"1841 – 1845", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/10_john_tyler.jpg");
        President p10 = new President (10, "James", 		"Polk", 			"1845 – 1849", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/11_james_k_polk.jpg");
        President p11 = new President (11, "Zachary", 		"Taylor", 			"1849 – 1850", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/12_zachary_taylor.jpg");
        President p12 = new President (12, "Millard", 		"Fillmore", 		"1850 – 1853", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/13_millard_filmore.jpg");
        President p13 = new President (13, "Franklin", 		"Pierce", 			"1853 – 1857", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/14_franklin_pierce.jpg");
        President p14 = new President (14, "James", 		"Buchanan", 		"1857 – 1861", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/15_james_buchanan.jpg");
        President p15 = new President (15, "Abraham", 		"Lincoln", 			"1861 – 1865", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/16_abraham_lincoln.jpg");
        President p16 = new President (16, "Andrew", 		"Johnson", 			"1865 – 1869", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/17_andrew_johnson.jpg");
        President p17 = new President (17, "Ulysses", 		"Grant", 			"1869 – 1877", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/18_ulysses_s_grant.jpg");
        President p18 = new President (18, "Rutherford",	"Hayes", 			"1877 – 1881", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/19_rutherford_b_hayes.jpg");
        President p19 = new President (19, "James", 		"Garfield", 		"1881", 		"https://www.whitehouse.gov/wp-content/uploads/2021/01/20_james_garfield.jpg");
        President p20 = new President (20, "Chester", 		"Arthur", 			"1881 – 1885", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/21_chester_a_arthur.jpg");
        President p21 = new President (21, "Grover", 		"Cleveland", 		"1885 – 1889", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/22_grover_cleveland.jpg");
        President p22 = new President (22, "Benjamin", 		"Harrison", 		"1889 – 1893", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/23_benjamin_harrison.jpg");
        President p23 = new President (23, "Grover", 		"Cleveland", 		"1893 – 1897", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/22_grover_cleveland.jpg");
        President p24 = new President (24, "William", 		"McKinley", 		"1897 – 1901", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/25_william_mckinley.jpg");
        President p25 = new President (25, "Theodore", 		"Roosevelt", 		"1901 – 1909", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/26_theodore_roosevelt.jpg");
        President p26 = new President (26, "William", 		"Taft",				"1909 – 1913", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/27_william_howard_taft.jpg");
        President p27 = new President (27, "Woodrow", 		"Wilson", 			"1913 – 1921", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/28_woodrow_wilson.jpg");
        President p28 = new President (28, "Warren", 		"Harding", 			"1921 – 1923", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/29_warren_g_harding.jpg");
        President p29 = new President (29, "Calvin", 		"Coolidge", 		"1923 – 1929", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/30_calvin_coolidge.jpg");
        President p30 = new President (30, "Herbert", 		"Hoover", 			"1929 – 1933", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/31_herbert_hoover.jpg");
        President p31 = new President (31, "Franklin", 		"Roosevelt", 		"1933 – 1945", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/32_franklin_d_roosevelt.jpg");
        President p32 = new President (32, "Harry", 		"Truman", 			"1945 – 1953", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/33_harry_s_truman.jpg");
        President p33 = new President (33,"Dwight", 		"Eisenhower", 		"1953 – 1961", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/34_dwight_d_eisenhower.jpg");
        President p34 = new President (34, "John", 			"Kennedy", 			"1961 – 1963", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/35_john_f_kennedy.jpg");
        President p35 = new President (35, "Lyndon", 		"Johnson", 			"1963 – 1969", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/36_lyndon_johnson.jpg");
        President p36 = new President (36, "Richard", 		"Nixon", 			"1969 – 1974", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/37_richard_nixon.jpg");
        President p37 = new President (37, "Gerald", 		"Ford", 			"1974 – 1977", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/38_gerald_ford.jpg");
        President p38 = new President (38, "Jimmy", 		"Carter", 			"1977 – 1981", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/39_jimmy_carter.jpg");
        President p39 = new President (39, "Ronald", 		"Reagan", 			"1981 – 1989", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/40_ronald_reagan.jpg");
        President p40 = new President (40, "George H.W.",	"Bush", 			"1989 – 1993", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/41_george_hw_bush.jpg");
        President p41 = new President (41, "Bill", 			"Clinton", 			"1993 – 2001", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/42_bill_clinton.jpg");
        President p42 = new President (42, "George W.", 	"Bush",				"2001 – 2009", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/43_george_w_bush.jpg");
        President p43 = new President (43, "Barack", 		"Obama",			"2009 – 2017", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/44_barack_obama.jpg");
        President p44 = new President (44, "Donald", 		"Trump",			"2017 – 2021", 	"https://www.whitehouse.gov/wp-content/uploads/2021/01/45_donald_trump.jpg");
        President p45 = new President (45, "Joe", 			"Biden",			"2021 –", 		"https://www.whitehouse.gov/wp-content/uploads/2021/01/joe_hero-2133x1280.jpg");

        presidentList.addAll(Arrays.asList(
                p0, p1, p2, p3, p4, p5, p6, p7, p8, p9,
                p10, p11, p12, p13, p14, p15, p16, p17, p18, p19,
                p20, p21, p22, p23, p24, p25, p26, p27, p28, p29,
                p30, p31, p32, p33, p34, p35, p36, p37, p38, p39,
                p40, p41, p42, p43, p44, p45));
    }
}
