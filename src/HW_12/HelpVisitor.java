package HW_12;

public class HelpVisitor implements StudentVisitor {

    private final int amount;

    public HelpVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(HumanitarianStudent s) {
        s.addMoney(amount);
    }

    @Override
    public void visit(NaturalStudent s) {
        s.addMoney(amount);
    }

    @Override
    public void visit(MixedStudent s) {
        s.addMoney(amount);
    }
}