package HW_12;

public abstract class AbstractStudent implements Student {

    protected int credits;
    protected final int requiredCredits;
    protected int money;
    protected boolean expelled;

    protected AbstractStudent(int requiredCredits, int initialMoney) {
        this.requiredCredits = requiredCredits;
        this.money = initialMoney;
        this.credits = 0;
        this.expelled = false;
    }

    @Override
    public void addCredits(int c) {
        if (!expelled) {
            credits += c;
        }
    }

    @Override
    public void addMoney(int amount) {
        if (!expelled) {
            money += amount;
        }
    }

    @Override
    public void pay(int amount) {
        if (expelled) {
            return;
        }
        if (money >= amount) {
            money -= amount;
        } else {
            expelled = true;
        }
    }

    @Override
    public void expel() {
        expelled = true;
    }

    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public int getRequiredCredits() {
        return requiredCredits;
    }

    @Override
    public boolean isExpelled() {
        return expelled;
    }
}