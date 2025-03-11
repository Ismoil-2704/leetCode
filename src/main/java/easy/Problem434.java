package easy;

public class Problem434 {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }

    public static int countSegments(String s) {
        if (s.isEmpty()) return 0;
        String[] split = s.trim().split(" ");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (!s1.isEmpty())
                count++;
        }
        return count;
    }
}
