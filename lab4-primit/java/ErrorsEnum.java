import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }
    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveResult = false;
        E result = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveResult )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                result = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveResult = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return result;
    }
  
    private static Error result2Error(Result r) 
    {
        Result result = null;
        
        switch (e) {
        case A_BIT_DIFFERENT:
            return Error.FP_ROUNDING;
        case INFINITY:
            return Error.FP_OVERFLOW;
        case ZERO:
            return Error.FP_UNDERFLOW;
        case VERY_DIFFERENT:
            return Error.INT_OVERFLOW;
        break;
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        System.out.print("Known errors = ");
        for (Result r : EnumSet.allOf(Result.class)) 
        {
            System.out.print(e + " ");
        }
        System.out.println();
        
        Result r = getEnumElement("Result", Result.class);
        System.out.println(r + " results in: " + result2Error(e));
    }
}
