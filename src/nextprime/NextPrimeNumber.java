package nextprime;

import java.util.Scanner;

/**
 *
 * @author pikachu
 * 
 * Search next prime number from entered number
 */
public class NextPrimeNumber {

    private  boolean isPrime(long number) {
        boolean primeFlag = false;
        if (number % 2 != 0) {
            primeFlag = true;
            for (long i = 3; i <= Math.sqrt(number); i += 2) {
                if (number % i == 0 && number != i) {
                    primeFlag = false;
                    break;
                } else {
                    primeFlag = true;
                }
            }
        }
        return primeFlag;
    }
    public void start() {
        var runtimeFlag = true;
        var scan = new Scanner(System.in);
        System.out.println("Enter the integer number that equals or greater zero you want to start from: ");
        var number = scan.nextLong();
        number++;
        while (number < 0) {
            System.out.println("You have entered negative number.");
            System.out.print("Try again: ");
            number = scan.nextInt();
        }
        long iterator = number;
        while (runtimeFlag) {
            if (isPrime(iterator)) {
                System.out.println("The next prime number is '" + iterator + "'.");
                System.out.println("One more time (y/n)?");
                var answer = scan.next();
                var answerCorrectFlag = false;
                while (!answerCorrectFlag) {
                    switch (answer) {
                        case "y" :
                            answerCorrectFlag = true;
                            break;
                        case "n" :
                            answerCorrectFlag = true;
                            runtimeFlag = false;
                            break;
                        default : 
                            System.out.println("The answer is incorrect. It should be 'y' or 'n'.");
                            System.out.print("Try again: ");
                            answer = scan.next();
                            break;
                    }
                }
            }
            iterator++;
        }
    }

}
