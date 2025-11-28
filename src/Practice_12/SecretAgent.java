package Practice_12;

public class SecretAgent implements Spy {

    public String name;
    public String info;

    public SecretAgent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ". " + info;
    }

    @Override
    public void visit(GeneralStaff generalStaff) {
        info = "Stolen: " +
                generalStaff.secretPapers + " secret papers.";

        generalStaff.secretPapers = 0;
        info = "Collected information: " + generalStaff;
    }

    @Override
    public void visit(MilitaryBase militaryBase) {
        info = "Collected information: " + militaryBase;
    }
}
