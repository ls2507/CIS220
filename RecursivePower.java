import java.util.Scanner;
//Luis Miranda
//Chpt 2PA
public class RecursivePower{
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
// ask for base and exponent
System.out.print("Enter base: ");
int base = scanner.nextInt();
System.out.print("Enter Exponent: ");
int exponent = scanner.nextInt();
// calculate and display
int result = power(base, exponent);
System.out.println("Value is: " + result);
scanner.close();
   }
//recursive method to calculate power
   public static int power(int base, int exponent){
if(exponent == 1){

    return base;
}
else {

    return base * power(base, exponent - 1);
}
   }




}