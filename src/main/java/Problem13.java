import java.util.HashMap;

public class Problem13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        HashMap<String, Integer> rome = new HashMap<>();
        rome.put("I", 1);
        rome.put("V", 5);
        rome.put("X", 10);
        rome.put("L", 50);
        rome.put("C", 100);
        rome.put("D", 500);
        rome.put("M", 1000);
        rome.put("IV", 4);
        rome.put("IX",9);
        rome.put("XL", 40);
        rome.put("XC", 90);
        rome.put("CD", 400);
        rome.put("CM", 900);

        StringBuilder last = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            if (!last.toString().equals(c) && !last.isEmpty()) {
                String n = last.toString();
                last.append(c);
                Integer exist = rome.get(last.toString());
                if (exist != null) {
                    sum -= rome.get(n);
                    sum += exist;
                }else {
                    sum += rome.get(c);
                }
            }else {
                sum += rome.get(c);
            }
            last = new StringBuilder(c);
        }
        System.out.println(sum);

    }
}
