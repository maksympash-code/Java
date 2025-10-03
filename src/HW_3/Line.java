package HW_3;

public class Line {
    private final double A;
    private final double B;
    private final double C;

    public Line() { this(0, 1, 0); }

    public Line(double A, double B, double C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Line(Line other){
        this(other.A, other.B, other.C);
    }

    public boolean isParallel(Line other){
        return this.A * other.B == this.B * other.A;
    }

    public double[] getIntersection(Line other){
        double det = this.A * other.B - this.B * other.A;
        if (det == 0) return null;

        double x = (this.B * other.C - other.B * this.C) / det;
        double y = (other.A * this.C - this.A * other.C) / det;
        return new double[]{x, y};
    }

    @Override
    public String toString() {
        return String.format("%.2f x + %.2f y + %.2f = 0", A, B, C);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line other)) return false;
        return this.A == other.A && this.B == other.B && this.C == other.C;
    }


    public static void main(String[] args) {
        Line[] lines = {
                new Line(1, -1, 0),
                new Line(2, -2, 3),
                new Line(0, 1, -4),
                new Line(1, 1, -5)
        };

        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[i].isParallel(lines[j])) {
                    System.out.println(lines[i] + " || " + lines[j]);
                }
            }
        }

        double[] p = lines[0].getIntersection(lines[2]);
        if (p != null) {
            System.out.println("Точка перетину: (" + p[0] + ", " + p[1] + ")");
        } else {
            System.out.println("Прямі паралельні");
        }
    }
}
