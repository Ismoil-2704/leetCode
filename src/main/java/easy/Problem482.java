package easy;

public class Problem482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("r", 1));
    }

    public static String licenseKeyFormatting(String s, int k) {
        String strings = s.toUpperCase().replaceAll("[-,\\s+]", "");
        StringBuilder stringBuilder = new StringBuilder();
        int groupSize = 0;
        int lengthed = strings.length();
        int start = lengthed % k;
        for (int i = 0; i < lengthed; i++) {
            char c = strings.charAt(i);
            if (groupSize == k) {
                stringBuilder.append('-');
                groupSize = 0;
            }
            if (start != 0 && i == start) {
                stringBuilder.append('-');
                groupSize = 0;
            }

            stringBuilder.append(c);
            groupSize++;
        }
        return stringBuilder.toString();
    }
}
