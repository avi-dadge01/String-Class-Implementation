package com.stringprogramming;

class MyStringIndexOutOfBoundsException extends RuntimeException {

    public MyStringIndexOutOfBoundsException(String description) {
        super(description);
    }

    public MyStringIndexOutOfBoundsException() {
    }
}

public final class MyString {

    private char[] arr;
    private int index;

    /* ================= Constructors ================= */

    public MyString() {
        arr = new char[0];
    }

    public MyString(String str) {
        arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[index++] = str.charAt(i);
        }
    }

    public MyString(StringBuffer sb) {
        this(sb.toString());
    }

    public MyString(StringBuilder sb) {
        this(sb.toString());
    }

    public MyString(char[] arr) {
        this(arr, 0, arr.length);
    }

    public MyString(char[] arr, int offset, int count) {

        if (offset < 0 || count < 0 || offset + count > arr.length) {
            throw new MyStringIndexOutOfBoundsException("out of bounds");
        }

        this.arr = new char[count];
        int idx = 0;

        for (int i = offset; i < offset + count; i++) {
            this.arr[idx++] = arr[i];
        }
    }

    public MyString(byte[] arr) {
        this(arr, 0, arr.length);
    }

    public MyString(byte[] arr, int offset, int count) {

        if (offset < 0 || count < 0 || offset + count > arr.length) {
            throw new MyStringIndexOutOfBoundsException("out of bounds for length");
        }

        this.arr = new char[count];

        for (int i = offset, j = 0; i < offset + count; i++) {
            this.arr[j++] = (char) arr[i];
        }
    }

    public MyString(int[] arr, int offset, int count) {

        if (offset < 0 || count < 0 || offset + count > arr.length) {
            throw new MyStringIndexOutOfBoundsException("out of bounds for length");
        }

        this.arr = new char[count];

        for (int i = offset; i < offset + count; i++) {
            this.arr[index++] = (char) arr[i];
        }
    }

    /* ================= Core Methods ================= */

    @Override
    public String toString() {

        if (arr.length == 0) {
            return "";
        }

        String output = "";

        for (char ele : arr) {
            output += ele;
        }

        return output;
    }

    public int length() {
        return arr.length;
    }

    public char charAt(int index) {

        if (index < 0 || index >= arr.length) {
            throw new MyStringIndexOutOfBoundsException("index out of bounds");
        }

        return arr[index];
    }

    public MyString concat(MyString str) {

        char[] newArr = new char[this.arr.length + str.length()];
        int index = 0;

        for (char ele : this.arr) {
            newArr[index++] = ele;
        }

        for (int i = 0; i < str.length(); i++) {
            newArr[index++] = str.charAt(i);
        }

        return new MyString(newArr);
    }

    public MyString toUpperCase() {

        char[] newArr = new char[arr.length];
        int index = 0;

        for (char ele : arr) {
            newArr[index++] = ele;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] >= 'a' && newArr[i] <= 'z') {
                newArr[i] = (char) (newArr[i] - 32);
            }
        }

        return new MyString(newArr);
    }

    public MyString toLowerCase() {

        char[] newArr = new char[arr.length];
        int index = 0;

        for (char ele : arr) {
            newArr[index++] = ele;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] >= 'A' && newArr[i] <= 'Z') {
                newArr[i] = (char) (newArr[i] + 32);
            }
        }

        return new MyString(newArr);
    }

    public int codePointAt(int index) {

        if (index < 0 || index >= arr.length) {
            throw new MyStringIndexOutOfBoundsException("invalid index");
        }

        return arr[index];
    }

    public int codePointBefore(int index) {

        if (index <= 0 || index > arr.length) {
            throw new MyStringIndexOutOfBoundsException("invalid index");
        }

        return arr[index - 1];
    }

    public boolean isEmpty() {
        return arr.length == 0;
    }

    public char[] toCharArray() {

        char[] newArr = new char[arr.length];
        int index = 0;

        for (char ele : arr) {
            newArr[index++] = ele;
        }

        return newArr;
    }

    /* ================= Comparison Methods ================= */

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MyString)) {
            return false;
        }

        MyString str = (MyString) obj;

        if (str.length() != this.length()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (this.charAt(i) != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean equalsIgnoreCase(MyString comp) {
        return comp.toUpperCase().equals(this.toUpperCase());
    }

    /* ================= Search Methods ================= */

    public boolean startsWith(MyString str) {

        if (str.length() > arr.length) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != arr[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean endsWith(MyString str) {

        if (str.length() > arr.length) {
            return false;
        }

        for (int i = arr.length - str.length(), j = 0; i < arr.length; i++, j++) {
            if (str.charAt(j) != arr[i]) {
                return false;
            }
        }

        return true;
    }

    public int indexOf(int asciiValue) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == asciiValue) {
                return i;
            }
        }

        return -1;
    }

    public int indexOf(int asciiValue, int startIndex) {

        if (startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == asciiValue) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(int asciiValue) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == asciiValue) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(int asciiValue, int startIndex) {

        if (startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        for (int i = startIndex; i >= 0; i--) {
            if (arr[i] == asciiValue) {
                return i;
            }
        }

        return -1;
    }
}

public class MyStringDriver {

    public static void main(String[] args) {
          
        MyString str1 = new MyString("java@122412sdvsadvADCFVG");
        char[] str2 = str1.toCharArray();
        System.out.println(str2);
        
                
    }

}