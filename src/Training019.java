import java.util.Stack;

class Training019{
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// 用两个栈实现队列
class MyQueue{
    private Stack<Integer> stackA =new Stack<Integer>();
    private Stack<Integer> stackB =new Stack<Integer>();
    public void enQueue(int element){
        stackA.push(element);
    }
    public Integer deQueue(int element){
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }
    public void transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
}