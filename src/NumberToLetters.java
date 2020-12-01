/**
 * @author Niloufar Vafaei
 */
public class NumberToLetters {
    public static void main(String[] args) throws Exception {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(args[0]);
            if (inputNumber < 0) {
                System.out.println("Input argument should be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Input argument is not correct.");
            return;
        }
        Mapper mapper = new Mapper();
        System.out.println(mapper.toLetter(inputNumber));
    }
}