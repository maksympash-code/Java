package HW_12;

public class ScholarshipVisitor implements StudentVisitor {

    private final int amount;

    public ScholarshipVisitor(int amount) {
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