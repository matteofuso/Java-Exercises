
public class EmptyStackException extends RuntimeException
{
   public EmptyStackException() {}
   
   public EmptyStackException(String causa)
   {
      super(causa);
   }
}