public class Tet {
    static int a = 10;

    static {
        a = 2;
    }

    {
        a = 5;
    }

    public Tet() {
        a = 4;
    }

    public static void main(String[] args) {
        System.out.println(Tet.a);
    }
}
