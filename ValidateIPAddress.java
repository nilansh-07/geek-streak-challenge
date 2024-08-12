public class ValidateIPAddress {
    static boolean isValid(String str) {
        int n = str.length();
        if (n < 7)
            return false;
        int dots = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == '.')
                return false;
            if (str.charAt(i) == '.')
                dots++;
        }
        if (dots != 3)
            return false;

        String num = "";
        for (int i = 0; i <= n; i++) {
            if (i == n || str.charAt(i) == '.') {
                if (num.length() == 0 || (num.charAt(0) == '0' && num.length() > 1) || num.length() > 3)
                    return false;
                int number = Integer.parseInt(num);
                if (number > 255)
                    return false;
                num = "";
            } else {
                num += str.charAt(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "222.111.111.111";

        System.out.print("The IP Address is: " + isValid(str));
    }
}
