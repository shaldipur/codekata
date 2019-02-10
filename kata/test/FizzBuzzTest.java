import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class FizzBuzzTest {
    @Test
    public void whenFizzBuzzIsPassedANumberItReturnsThatNumber()
    {
       FizzBuzz fizzBuzz = new FizzBuzz();
       assertEquals("1", fizzBuzz.fizz(1));
    }


    @Test
    public void whenFizzBuzzIsPassedATwoItReturnsATwo()
    {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("2", fizzBuzz.fizz(2));
    }

    @Test
    public void whenFizzBuzzIsPassedAMultipleOfThreeItReturnsFizz()
    {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("fizz", fizzBuzz.fizz(3));
        assertEquals("fizz", fizzBuzz.fizz(6));
    }
}
