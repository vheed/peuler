import ProcessingModel.Arithmetic;
import ProcessingModel.NumberUtils;
import ProcessingModel.StreamUtils;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PageOne {

   /* Problem 1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

    Find the sum of all the multiples of 3 or 5 below 1000.*/
   public void multiplesOf3And5() {
       Integer answer = IntStream.range(1, 1000).parallel().filter(i -> ((i%3)==0) && ((i%5)==0)).sum();
       System.out.println("------------------------" + "\n\n" + "Problem 1" + "\nAnswer -> " + answer + "\n");
   }

    public void evenFibonacciNumbers() {
        //IntStream fiboStream = IntStream.generate(new StreamUtils.FibonnaciProvider());
        //fiboStream.limit(5).forEach(System.out::println);
        //Integer answer = fiboStream.limit(5).parallel().filter(i -> ((i%2)==0)).forEach(System.out::println);
        Long answer = StreamUtils.makeFiboStream().limit(5).filter(i -> (i%2)==0).sum();
        System.out.println("------------------------" + "\n\n" + "Problem 2" + "\nAnswer -> " + answer + "\n");
    }


    public void largestPrimeFactor(long n) {
        Long answer = NumberUtils.makePrimeStreamTill((long) Math.sqrt(n)).parallel().filter(l -> (l%n)==0).max().getAsLong();
        System.out.println("------------------------" + "\n\n" + "Problem 3" + "\nAnswer -> " + answer + "\n");
    }

    public void largestPalindromeProductOf2NumsMultiplication() {
        Long answer = LongStream.range(100, 1000).parallel()
                .flatMap(a -> LongStream.range(a, 1000).parallel().map(b -> b*a)).filter(Arithmetic::isPalindrome).max().getAsLong();
        System.out.println("------------------------" + "\n\n" + "Problem 4" + "\nAnswer -> " + answer + "\n");
    }
}
