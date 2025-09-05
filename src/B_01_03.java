import java.util.Locale;

public class B_01_03 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        int mul = 1;


        for (int i = 0; i < args.length; i++){
            try{
                int num = Integer.parseInt(args[i]);
                mul *= num;
            }
            catch (NumberFormatException e){
                System.err.println("Bad argument!");
            }
        }

        System.out.println("Multi = " + mul);
    }
}
