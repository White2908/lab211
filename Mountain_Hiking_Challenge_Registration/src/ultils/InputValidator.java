package ultils;

public class InputValidator {

    public InputValidator() {
    }

    public static final String ID_VALIDATE = "^(SE|HE|DE|QE|CE)\\d{6}$";
    public static final String NAME_VALIDATE = "^[a-zA-Z\\s]{2,20}$";
    public static final String NUMBER_VALIDATE = "(+84|0)\\d{9}$";
    public static final String EMAIL_VALIDATE = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";


    public boolean inputValid(String value, String regex) {
        if (!value.matches(regex)) {
            System.out.println("Invalid!!");
            return false;
        }
        return true;
    }

    public double TUITION_FEE_VALIDATE(String phone, double DEFAULT_FEE) {
        if (phone.startsWith("+84")) {
            phone = "0" + phone.substring(3);
        }
        // Viettel prefixes
        String[] viettel = {"086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038", "039"};
        // VNPT prefixes
        String[] vnpt = {"088", "091", "094", "083", "084", "085", "081", "082"};

        for (String pre : viettel) {
            if (phone.startsWith(pre)) {
                return DEFAULT_FEE * 0.65; //35%
            }
        }

        for (String pre : vnpt) {
            if (phone.startsWith(pre)) {
                return DEFAULT_FEE * 0.65;
            }
        }

        return DEFAULT_FEE;
    }
}



