package HW_12;

public class TeachNaturalVisitor implements StudentVisitor {

    private final int credits;

    public TeachNaturalVisitor(int credits) {
        this.credits = credits;
    }

    @Override
    public void visit(HumanitarianStudent s) {
        // природничий викладач не може навчати гуманітарного студента
    }

    @Override
    public void visit(NaturalStudent s) {
        s.addCredits(credits);
    }

    @Override
    public void visit(MixedStudent s) {
        s.addCredits(credits);
    }
}