import java.util.Scanner;
import java.util.NoSuchElementException;

public class DecimalToBinary {
    public static int inputNumber(Scanner in, String message)
    throws IllegalStateException, NoSuchElementException
    {
        int number;
        boolean valid;
        number = 0; // Compiler
        do
        {
            valid = true;
            try
            {
                System.out.println(message);
                number = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e)
            {
                valid = false;
            }
        } while (!valid);
        return number;
    }

    public static void convertDecimalToBinary(int decimal, Stack binary)
    {
        
    }

    public static void printBinaryResult(Stack binary)
    {

    }

    public static void main(String[] args) {
        int decimal;
        Stack stack;
        decimal = 0; // Compiler
        try (Scanner in = new Scanner(System.in);) {
            decimal = inputNumber(in, "Inserisci il numero da convertire");
        } catch (IllegalStateException e)
        {
            System.err.println("Impossibile leggere dati dalla console");
            System.exit(-1);
        } catch (NoSuchElementException e)
        {
            System.err.println("Il flusso dati è stato interrotto troppo presto, riprova");
            System.exit(-1);
        }

        stack = new Stack(32);

        convertDecimalToBinary(decimal, stack);

        printBinaryResult(stack);
    }
}