public class tacks {
    public static void main(String[] args) {
        String s = "string";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') stringBuilder.reverse();
            else stringBuilder.append(s.charAt(i));
        }
        System.out.println(stringBuilder);
    }

}