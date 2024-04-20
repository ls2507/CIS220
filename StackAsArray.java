import java.util.Scanner;

public class StackAsArray {
    private static int[] stack; 
    private static int top; 
    private static int allocationSize; 

    // Method to resize the stack when it's full
    public static void stackResize() {
        allocationSize *= 2; // Double the allocation size
        int[] newStack = new int[allocationSize]; // Create a new array
        System.arraycopy(stack, 0, newStack, 0, stack.length); // Copy elements from the old stack to the new stack
        stack = newStack; // Update the stack
    }

    // Method to push an item onto the stack
    public static boolean push(int item) {
        if (top == allocationSize) { 
            stackResize(); 
        }
        if (top < allocationSize) { 
            stack[top++] = item; 
            return true; 
        }
        return false; 
    }

    // Method to pop an item from the stack
    public static int pop() {
        if (isEmpty()) {
            return -1; 
        }
        return stack[--top]; 
    }

    // Method to check if the stack is empty
    public static boolean isEmpty() {
        return top == 0; 
    }

    // Method to peek at the top item of the stack
    public static int peek() {
        if (isEmpty()) { 
            return -1; 
        }
        return stack[top - 1]; 
    }

    // Method to print the stack
    public static void printStack() {
        for (int i = top - 1; i >= 0; i--) { 
            System.out.println(stack[i]); // Print each item of the stack
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the allocation size: ");
        allocationSize = scanner.nextInt(); // Input allocation size
        stack = new int[allocationSize]; // Initialize the stack array with the allocation 
        top = 0; 

        System.out.println("Enter the maximum length (Enter -1 for unbounded length): ");
        int maxLength = scanner.nextInt(); // Input for max length

        // Test scenario
        System.out.println("Push item 1 to stack: " + (push(1) ? "Successful" : "Not successful"));
        System.out.println("Push item 2 to stack: " + (push(2) ? "Successful" : "Not successful"));
        System.out.println("The top item in the stack was: " + peek());
        System.out.println("Push item 3 to stack: " + (push(3) ? "Successful" : "Not successful"));
        System.out.println("Stack length: " + top);
        System.out.println("The item popped from the stack was:" + pop());
        System.out.println("The top item in the stack was: " + peek());
        System.out.println("Push item 4 to stack: " + (push(4) ? "Successful" : "Not successful"));
        System.out.println("The stack is the following:");
        printStack();
        System.out.println("Push item 5 to stack: " + (push(5) ? "Successful" : "Not successful"));
        System.out.println("The item popped from the stack was: " + pop());
        System.out.println("Push item 6 to stack: " + (push(6) ? "Successful" : "Not successful"));
        System.out.println("The stack is the following:");
        printStack();
        System.out.println("The item popped from the stack was: " + pop());
        System.out.println("The stack is empty: " + isEmpty());
        System.out.println("The item popped from the stack was: " + pop());
        System.out.println("The item popped from the stack was: " + pop());
        System.out.println("The item popped from the stack was: " + pop());
        System.out.println("The stack is empty: " + isEmpty());
    }
}


