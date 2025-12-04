package HW_12;

public interface Student {
    void accept(StudentVisitor visitor);

    void addCredits(int c);

    void addMoney(int amount);

    void pay(int amount);

    void expel();

    int getCredits();

    int getRequiredCredits();

    boolean isExpelled();
}
