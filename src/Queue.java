import java.io.IOException;
import java.util.*;

public class Queue {

    static java.util.Queue<Integer> queue = new LinkedList<Integer>();

    public static void insertNumber(int i) {    // add numbers to queue from tail
        queue.add(i);
    }

    public static void clearQueue() throws IOException {    // clear queue from head
        queue.clear();
        Main.queueOut.write("After clear:\n");
        Main.queueOut.write("\n");
    }

    public static void checkNumber(int i)throws IOException{    // if given number is even, remove max number in queue and add given number from tail or if given number is  odd, remove max number in queue and add given number from tail
        Main.queueOut.write("After checkNumber " + i + ":\n");
        if(i%2 == 0){
            queue.remove(Collections.max(queue));
            queue.add(i);
            for (Integer x : queue) {
                Main.queueOut.write(String.valueOf(x)+" ");
            }
        }
        else {
            queue.remove(Collections.min(queue));
            queue.add(i);
            for (Integer x : queue) {
                Main.queueOut.write(String.valueOf(x)+" ");
            }
        }
        Main.queueOut.write("\n");
    }

    public static void calculateFib(int i)throws IOException{   //calculate firt given number and insert to queue' tail
        int k=0;
        ArrayList<Integer> fib = new ArrayList<Integer>();
        while(k<i){
            if(k<2){
                fib.add(k);
                queue.add(1);
            }
            else {
                fib.add(fib.get(k-2) + fib.get(k-1));
                queue.add(fib.get(k));
            }
            k++;
        }
        Main.queueOut.write("After calculateFib "+ i+":\n");
        for (Integer y : queue) {
            Main.queueOut.write(String.valueOf(y)+ " ");
        }
        Main.queueOut.write("\n");
    }

    public static void reverse(int i)throws IOException{    // if given number is bigger than 0, reverse first given number from head.if given number is smaller than 0, reverse last given number from tail.
        Main.queueOut.write("After reverse "+i+":\n");
        if (i>0){
            int[] num = new int[i];
            for(int t=0;t<i;t++){
                num[i-1-t] = queue.element();
                queue.remove();
            }
            int[] num1 = new int[queue.size()];
            int y=0;
            for (Integer x : queue) {
                num1[y] = x;
                y++;
            }
            queue.clear();
            int k=0;
            while(k<i){
                queue.add(num[k]);
                k++;
            }
            for (int r=0; r<num1.length;r++){
                queue.add(num1[r]);
            }
        }
        else{
            int[] num = new int[queue.size() +i];
            for(int t=0;t<num.length;t++){
                num[t] = queue.element();
                queue.remove();
            }
            int[] num1 = new int[-i];
            int y=0;
            for (Integer x : queue) {
                num1[y] = x;
                y++;
            }
            queue.clear();
            for (int r=0; r<num.length;r++){
                queue.add(num[r]);
            }
            int k=0;
            while(k<-i){
                queue.add(num1[num1.length-k-1]);
                k++;
            }
        }
        for (Integer z : queue) {
            Main.queueOut.write(String.valueOf(z)+" ");
        }
        Main.queueOut.write("\n");
    }

    public static void isExist(int i)throws IOException{    // Print 1 if queue contains the given number, 0 if not
        if(queue.contains(i)){
            Main.queueOut.write("After isExist "+i+":\n");
            Main.queueOut.write("1");
        }
        else {
            Main.queueOut.write("After isExist "+i+":\n");
            Main.queueOut.write("0");
        }
        Main.queueOut.write("\n");
    }

    public static void sumDistinctElements()throws IOException{ //assign the data from queue to set so we sum all numbers once
        Set<Integer> set1 = new HashSet<Integer>(queue) ;
        int sum = 0;
        for (int i : set1) {
            sum += i;
        }
        Main.queueOut.write("After sumDistinctElements:\n");
        Main.queueOut.write(String.valueOf(sum));
        Main.queueOut.write("\n");
    }

    public static void evenReverse(ArrayList<Integer> xy) throws IOException {  //sort all even numbers in reverse order
        for (Integer integer : xy) {
            queue.add(integer);
        }
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> allList = new ArrayList<Integer>();
        for (Integer integer : queue) {
            if (integer%2 == 0){
                evenList.add(integer);
            }
        }
        int count=0;
        for (Integer integer : queue) {
            if (integer%2 == 0){
               allList.add(evenList.get(evenList.size()-1-count));
                count++;
            }
            else {
                allList.add(integer);
            }
        }
        queue.clear();
        queue.addAll(allList);
        for (Integer integer : queue) {
            Main.queueOut.write(String.valueOf(integer)+" ");
        }
        Main.queueOut.write("\n");
    }
}
