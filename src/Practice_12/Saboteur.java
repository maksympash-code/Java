package Practice_12;

public class Saboteur implements  Spy {

    public String name;
    public String info = "";

    public Saboteur(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ". " + info;
    }

    @Override
    public void visit(GeneralStaff generalStaff) {
        info = "Destroyed: " +
        generalStaff.generals + " generals and " +
        generalStaff.secretPapers + " secretPapers.";

        generalStaff.generals = 0;
        generalStaff.secretPapers = 0;
    }

    @Override
    public void visit(MilitaryBase militaryBase) {
        info = "Destroyed: " +
                militaryBase.soldiers + " soldiers and " +
                militaryBase.tanks + " tanks.";
        militaryBase.soldiers = 0;
        militaryBase.tanks = 0;
    }
}
