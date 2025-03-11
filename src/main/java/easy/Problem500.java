package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem500 {
    public static void main(String[] args) {
        String[] s = {"aadsdfghjkla","qwertyuiadfopq","zxadfazm","asadfaedfghjkala","qadfzwertyuiopq","zxcvbnzzm"};
        System.out.println(Arrays.toString(findWords(s)));
    }

    public static String[] findWords(String[] words) {
        String firstTab = "qwertyuiopQWERTYUIOP[]";
        String secondTab = "asdfghjklASDFGHJKL;'\\";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int selectedTab = 0;
        for (int i = 0; i < words.length; i++) {
            if (!builder.isEmpty()) {
                list.add(builder.toString());
                builder = new StringBuilder();
                selectedTab = 0;
            }
            String word = words[i];
            for (char c : word.toCharArray()) {
                int tab = firstTab.indexOf(c) != -1 ? 1 : secondTab.indexOf(c) != -1 ? 2 : 3;
                if (tab != selectedTab && selectedTab != 0) {
                    builder = new StringBuilder();
                    selectedTab = 0;
                    break;
                }
                builder.append(c);
                selectedTab = tab;
            }
        }
        if (!builder.isEmpty())
            list.add(builder.toString());

        return list.toArray(new String[0]);
    }

}
