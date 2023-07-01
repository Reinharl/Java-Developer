package model;

public class MyString {
    private StringBuilder stringBuilder;

    private MyString() {
        stringBuilder = new StringBuilder();
    }

    public static class Builder {
        private MyString myStringBuilder;

        public Builder() {
            myStringBuilder = new MyString();
        }

        public Builder append(String str) {
            myStringBuilder.stringBuilder.append(str);
            return this;
        }

        public String build() {
            return myStringBuilder.stringBuilder.toString();
        }
    }
}

