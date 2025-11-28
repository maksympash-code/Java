package Practice_12;

public class Main {

    public static void main(String[] args) {
        var alpha = new GeneralStaff("alpha", 100, 200);
        var pyatirochka = new MilitaryBase("pyatirochka", 1000, 50);

        System.out.println(alpha);
        System.out.println(pyatirochka);

        var saboteur = new Saboteur("Alyosha Arestovych");
        var secretAgent = new SecretAgent("Dima Gordon");

        alpha.accept(secretAgent);
        System.out.println(secretAgent);

        pyatirochka.accept(secretAgent);
        System.out.println(secretAgent);

        alpha.accept(saboteur);
        System.out.println(saboteur);
        pyatirochka.accept(saboteur);
        System.out.println(saboteur);
    }

}
