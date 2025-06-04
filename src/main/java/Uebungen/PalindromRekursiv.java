package Uebungen;

public class PalindromRekursiv implements Palindrom {
    @Override
    public boolean istPalindrom(String wort) {
        wort = wort.toLowerCase().replaceAll("[^a-z0-9]", "");
        return istPalindromPrv(wort, 0, wort.length() - 1);
    }

    private boolean istPalindromPrv(String wort, int left, int right) {
        if (left >= right) return true;
        if (wort.charAt(left) != wort.charAt(right)) return false;
        return istPalindromPrv(wort, left + 1, right - 1);
    }
}

