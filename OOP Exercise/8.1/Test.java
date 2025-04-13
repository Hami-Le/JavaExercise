
public class Test {
    public static void main(String[] args) {
        MyInStack stack = new MyInStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(12);

        System.out.println("Stack is full? " + stack.isFull());

        System.out.println("Peek top: " + stack.peek()); 

        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println("Popped: " + value);
        }

        System.out.println("Stack is empty? " + stack.isEmpty());
    }
}

