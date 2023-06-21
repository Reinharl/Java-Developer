package model;

public class MiaStringa extends IterabileAbstract<Character> implements Sequenza<Character> {

    public String s;

    public MiaStringa() {
        this.s = "";
    }

    public MiaStringa(String s) {
        this.s = s;
    }

    @Override
    public int get(int i) {
        return s.charAt(i);
    }

    @Override
    public boolean contains(Character s) {
        return this.s.contains(String.valueOf(s));
    }

    @Override
    public int size() {
        return s.length();
    }

    @Override
    public void add(Character s) {
        this.s += s;
    }

    @Override
    public void remove(int i) {
        char[] chars = s.toCharArray();
        if (i >= 0 && i < chars.length) {
            System.arraycopy(chars, i + 1, chars, i, chars.length - 1 - i);
            s = new String(chars, 0, chars.length - 1);
        }
    }

    @Override
    public void clear() {
        s = "";
    }

    @Override
    public Character next() {
        if (index < s.length()) {
            return s.charAt(index++);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return index < s.length();
    }
}
