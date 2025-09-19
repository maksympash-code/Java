package Practice_3;

import java.util.Arrays;

public class A03_01_Fraction {
    public static void main(String[] args) {
        int size = 4;
        Fraction[] array = new Fraction[size];
        for (int i = 0; i < size; i++) {
            array[i] = Fraction.random();
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Fraction.sum(array));
    }
}

/*
[A]03.01. Описати клас Дріб у вигляді пари чисел m та n.
Реалізувати методи додавання, віднімання, множення та ділення дробів.
Ввести масив із k дробів і передати його в метод,
який повертає їх суму як новий об’єкт класу Дріб.
 */
class Fraction {

    protected int m;
    protected int n;

    public Fraction(int m, int n) {
        if (n <= 0)
            throw new RuntimeException("Negative denominator");
        this.m = m;
        this.n = n;
        reduce();
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction(Fraction f) {
        this(f.m, f.n);
    }

    @Override
    public String toString() {
        return m + "/" + n;
    }

    public boolean equals(Fraction other) {
        return m == other.m && n == other.n;
    }

    public Fraction add(Fraction other) {
        int m = this.m * other.n + other.m * this.n;
        int n = this.n * other.n;
        return new Fraction(m, n);
    }

    private void reduce() {
        int d = gcd(Math.abs(m), n);
        m /= d;
        n /= d;
    }

    public static Fraction sum(Fraction[] array) {
        Fraction res = new Fraction();
        for (Fraction item: array)
            res = res.add(item);
        return res;
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static Fraction random() {
        int m = (int) (Math.random() * 200 - 100);
        int n = (int) (Math.random() * 100 + 1);
        return new Fraction(m, n);
    }
}