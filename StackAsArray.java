import java.util.Arrays;
import java.util.Scanner;

public class StackAsArray {
    private static int[] stack; 
    private static int top; 
    private static int size; 

    // Initialize the stack with the initial size
    public static void initializeStack(int initialSize) {
        size = initialSize;
        stack = new int[size];
        top = -1; // Stack is empty
    }

    // Method to resize the stack when full
    public static void stackResize() {
        size *= 2; 
        stack = Arrays.copyOf(stack, size); 
    }

    // Push an item onto the stack
    public static boolean push(int item) {
        if (top == size - 1) { 
            stackResize(); 
        }
        stack[++top] = item; 
        return true; 
    }

   
    public static int pop() {
        if (top == -1) {
            return Integer.MIN_VALUE; //return minimum integer value as an indicator
        }
        return stack[top--]; // Return the top item and -1 top
    }

    
    public static boolean isEmpty() {
        return top == -1; // If top is -1 stack is empty
    }

    
    public static int peek() {
        if (top == -1) {
            return Integer.MIN_VALUE; 
        }
        return stack[top]; // Return top item
    }

    
    public static void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]); // Print stack top to bottom
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the allocation size of the stack: ");
        int allocationSize = scanner.nextInt();
        initializeStack(allocationSize); // Initialize the stack 

        // Test 
        System.out.println();
        System.out.println("Item 1 was pushed " + (push(1) ? "successfully" : "unsuccessfully"));
        System.out.println("Item 2 was pushed " + (push(2) ? "successfully" : "unsuccessfully"));
        System.out.println("The top item on the stack is: " + peek());
        System.out.println("Item 3 was pushed " + (push(3) ? "successfully" : "unsuccessfully"));
        System.out.println("The length of the stack is: " + (top + 1));
        System.out.println();
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("The top item on the stack is: " + peek());
        System.out.println("Item 4 was pushed " + (push(4) ? "successfully" : "unsuccessfully"));
        System.out.println();
        System.out.println("The stack contents are:");
        printStack();
        System.out.println("Item 5 was pushed " + (push(5) ? "successfully" : "unsuccessfully"));
        System.out.println();
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("Item 6 was pushed " + (push(6) ? "successfully" : "unsuccessfully"));
        System.out.println();
        System.out.println("The stack contents are the following:");
        printStack();
        System.out.println();
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("The stack is empty: " + isEmpty());
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("The item popped from the stack was " + pop());
        System.out.println("The stack is empty: " + isEmpty());

        scanner.close();
    }
}
