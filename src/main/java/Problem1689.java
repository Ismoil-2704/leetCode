public class Problem1689 {
    public static void main(String[] args) {
        String n = "32";
        int max = Integer.MIN_VALUE;
        char charr[] = n.toCharArray();
        for(int i=0; i<charr.length; i++){
            char c = charr[i];
            int i1 = c - '0';
            if(max < charr[i]-'0')  max = charr[i]-'0';
        }
        System.out.println(max);
    }
}
