public class A_01_03 {
    public static void main(String[] args){

        double sum = 0.0;

        for (int i = 0; i < args.length; i++){
            try{
                sum += Double.parseDouble(args[i]);
            }
            catch (NumberFormatException e){
                System.err.println("Bad argument!");
            }
        }

        System.out.printf("Sum = %.4f", sum);
    }
}
