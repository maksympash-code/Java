package HW_12;

public class MixedStudent extends AbstractStudent {

    public MixedStudent(int requiredCredits, int initialMoney) {
        super(requiredCredits, initialMoney);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}