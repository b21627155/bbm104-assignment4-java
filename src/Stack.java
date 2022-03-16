import java.io.IOException;
import java.util.*;

public class Stack {

    static java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

    public static void insertNumber(int i) {    // add numbers to queue from top
        stack.add(0,i);
    }

    public static void clearStack() throws IOException{ // clear stack from top
        stack.clear();
        Main.stackOut.write("After clear:\n");
        Main.stackOut.write("\n");
    }

    public static void checkNumber(int i)throws IOException{    // if given number is even, remove max number in stack and add given number or if given number is  odd, remove max number in stack and add given number
        Main.stackOut.write("After checkNumber " + i + ":\n");
        if(i%2 == 0){
            stack.remove(Collections.max(stack));
            stack.add(0,i);
            for (Integer x : stack) {
                Main.stackOut.write(String.valueOf(x)+" ");
            }
        }
        else {
            stack.remove(Collections.min(stack));
            stack.add(0,i);
            for (Integer x : stack) {
                Main.stackOut.write(String.valueOf(x)+" ");
            }
        }
        Main.stackOut.write("\n");
    }

    public static void calculateFib(int i)throws IOException{  //calculate firt given number and insert to stack

        ArrayList<Integer> reverse = new ArrayList<Integer>(stack);
        int count=0;
        for (int j=0;j<stack.size();j++){
            stack.set(j, reverse.get(reverse.size()-count-1));
            count++;
        }
        int k=0;
        int[] fib = new int[i];
        while(k<i){
            if(k<2){
                fib[k] = 1;
            }
            else {
                fib[k] = fib[k-2] + fib[k-1];
            }
            k++;
        }
        for (Integer r: fib) {
            stack.push(r);
        }
        Main.stackOut.write("After calculateFib "+ i+":\n");
        for (Integer y : stack) {
            Main.stackOut.write(String.valueOf(y)+ " ");
        }
        Main.stackOut.write("\n");
    }

    public static void reverse(int i)throws IOException{     // if given number is bigger than 0, reverse first given number from top.if given number is smaller than 0, reverse last given number from t
        Main.stackOut.write("After reverse "+i+":\n");
        if (i>0){
            int[] num = new int[i];
            for(int t=0;t<i;t++){
                num[t] = stack.get(stack.size()-1);
                stack.pop();
            }
            int k=0;
            while(k<i){
               stack.push(num[k]);
                k++;
            }
        }
        else{
            int[] num = new int[-i];
            for(int t=0;t>i;t--){
                num[-t] = stack.get(0);
                stack.remove(0);
            }
            int k=0;
            while(k<-i){
                stack.add(0,num[k]);
                k++;
            }

        }

        for (Integer z : stack) {
            Main.stackOut.write(String.valueOf(z)+" ");
        }
        Main.stackOut.write("\n");
    }

    public static void isExist(int i)throws IOException{    // Print 1 if stack contains the given number, 0 if not
        if(stack.contains(i)){
            Main.stackOut.write("After isExist "+i+":\n");
            Main.stackOut.write("1");
        }
        else {
            Main.stackOut.write("After isExist "+i+":\n");
            Main.stackOut.write("0");
        }
        Main.stackOut.write("\n");
    }

    public static void sumDistinctElements()throws IOException{ //assign the data from stack to set so we sum all numbers once
        Set<Integer> set1 = new HashSet<Integer>(stack) ;
        int sum = 0;
        for (int i : set1) {
            sum += i;
        }
        Main.stackOut.write("After sumDistinctElements:\n");
        Main.stackOut.write(String.valueOf(sum));
        Main.stackOut.write("\n");
    }

    public static void evenReverse(ArrayList<Integer> xy) throws IOException {  //sort all even numbers in reverse order

        for (Integer integer : xy) {
            stack.add(0, integer);
        }
       ArrayList<Integer> reverseList = new ArrayList<Integer>();
        for (Integer integer : stack) {
            if (integer%2 == 0){
                reverseList.add(integer);
            }
        }
        int count=0;
        for (int i=0;i<stack.size();i++){
            if (stack.get(i)%2 == 0){
                stack.set(i, reverseList.get(reverseList.size()-count-1));
                count++;
            }
        }

        for (Integer integer : stack) {
            Main.stackOut.write(String.valueOf(integer)+" ");
        }
        Main.stackOut.write("\n");
    }
}
