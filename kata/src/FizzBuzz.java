public class FizzBuzz {

    public String fizz(Integer inputNumber)
    {

        if((inputNumber % 3 == 0) && (inputNumber % 5 == 0))
            return "fizzBuzz";

        else if(inputNumber % 3 == 0)
            return "fizz";

        else if(inputNumber % 5 ==0)
            return "buzz";

        return inputNumber.toString();
    }
}
