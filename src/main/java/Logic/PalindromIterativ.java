package Logic;

public class PalindromIterativ implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        wort = wort.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = wort.length() - 1;

        while (left < right) {
            if (wort.charAt(left) != wort.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

