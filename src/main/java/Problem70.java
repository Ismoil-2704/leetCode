public class Problem70 {
    public static void main(String[] args) {
        int num = 6;
        int plus = 1;
        for (int i = 0; i < num; i++) {
            if (i > 1){
                plus = (i-1) + plus;
            }else {
                plus = i + plus;
            }
        }
        System.out.println(plus);
    }
}
