
package evenfib;



public class EvenFib {

    public static void main(String[] args) {
        int maxNum = 400;
        int prevNum = 0;
        int nextNum = 1;
        int totalAmount= 0;
        Integer fibArr[] = new Integer[maxNum];

        for (int i = 0; i < fibArr.length; i++) {
            //System.out.println(prevNum + " ");

            int sum = prevNum + nextNum;
            prevNum = nextNum;
            nextNum = sum;
            

            if (fibArr[i] == null) {
                fibArr[i] = sum;

            }

        }
        System.out.print("The list of fib numbers: \n");
        for (int i = 0; i < fibArr.length; i++) {
            System.out.println(fibArr[i] + " ");

        }

        System.out.println("\nThe numbers divisble by 2");
        for (int i = 0; i < fibArr.length; i++) {
            if (fibArr[i] % 2 == 0) {
                System.out.println(fibArr[i] + " ");
                totalAmount = totalAmount + fibArr[i];
            }
        }
        System.out.println("Final Total");
        System.out.println("\n\n" +totalAmount);
    }

}
