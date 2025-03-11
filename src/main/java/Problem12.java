import java.util.HashMap;

public class Problem12 {
    public static void main(String[] args) {
        int number = 12;

        HashMap<String, String> rome = new HashMap<>();
        rome.put("1","I");
        rome.put("5","V");
        rome.put("10","X");
        rome.put("50","L");
        rome.put("100","C");
        rome.put("500","D");
        rome.put("1000","M");
        rome.put("4","IV");
        rome.put("9","IX");
        rome.put("40","XL");
        rome.put("90","XC");
        rome.put("400","CD");
        rome.put("900","CM");

        String s = String.valueOf(number);
        String lastNUmber = "";
        String outPut = "";
        int lastAdded = 0;
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            String next  = String.valueOf(s.charAt(i + 1));


        }
    }
}
