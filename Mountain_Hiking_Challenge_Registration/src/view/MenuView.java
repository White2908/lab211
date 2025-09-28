package view;

public class MenuView {
    public static final String MENU =      "-------------------------MENU-------------------------\n";
    public static final String FEATURE_1 = "1.student registration\n";
    public static final String FEATURE_2 = "2.Update Student Information\n";
    public static final String FEATURE_3 = "3.Display Student List\n";
    public static final String FEATURE_4 = "4.Remove Student Information\n";
    public static final String FEATURE_5 = "5.Search Student By Name\n";
    public static final String FEATURE_6 = "6.Filter Data By Campus\n";
    public static final String FEATURE_7 = "7.Statistics Of Registration Numbers By Location:\n";
    public static final String FEATURE_8 = "8.Save Data\n";
    public static final String FEATURE_9 = "9.Exit\n";
    public static final String MENU_END =  "------------------------------------------------------\n";

    public static final String ADD_ID = "Enter student ID: ";
    public static final String ADD_NAME = "Enter student name: ";
    public static final String ADD_NUMBER = "Enter student number: ";
    public static final String ADD_EMAIL = "Enter student email: ";
    public static final String ADD_MOUNTAIN_CODE = "Enter student mountain code: ";
    public static final String ADD_SUCCESS = "Add success!!!\n";
    public static final String UPDATE_SUCCESS = "Update success!!!\n";
    public static final String REMOVE_SUCCESS = "Remove success!!!\n";

    public static void showMenu() {
        System.out.println(MENU);
        System.out.println(FEATURE_1);
        System.out.println(FEATURE_2);
        System.out.println(FEATURE_3);
        System.out.println(FEATURE_4);
        System.out.println(FEATURE_5);
        System.out.println(FEATURE_6);
        System.out.println(FEATURE_7);
        System.out.println(FEATURE_8);
        System.out.println(FEATURE_9);
        System.out.println(MENU_END);
    }


}
