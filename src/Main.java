import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {

    static Scanner inputFile; // for reading commands.txt
    static FileWriter stackOut, queueOut; // output file

    public static void main(String[] args) throws IOException {
        String path = new String(args[0]);

        inputFile = new Scanner(new File(path));
        stackOut = new FileWriter("stackOut.txt");
        queueOut = new FileWriter("queueOut.txt");

        while (inputFile.hasNextLine()) {
            String[] repo = inputFile.nextLine().split(" "); //the array where the data is taken line by line from the input file and stored

            if (repo[0].equals("S")) { //process stack data

                if (repo[1].equals("insertNumbers")) { // call methods insertNumber from stack class and process data
                    int i = 1;
                    stackOut.write("After insertNumbers ");

                    while (i < repo.length - 1) {
                        stackOut.write(" ");
                        stackOut.write(repo[i + 1]);
                        Stack.insertNumber(Integer.parseInt(repo[i + 1]));
                        i++;
                    }
                    stackOut.write(":\n");

                    for (Integer integer : Stack.stack) {
                        stackOut.write(String.valueOf(integer) + " ");
                    }
                    stackOut.write("\n");
                }

                else if (repo[1].equals("clear")) {  // call methods clear from stack class and process data
                    Stack.clearStack();
                }

                else if (repo[1].equals("checkNumber")) {  // call methods checkNumber from stack class and process data
                    Stack.checkNumber(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("reverse")) {    // call methods reverse from stack class and process data
                    Stack.reverse(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("calculateFib")) {   // call methods calculateFib from stack class and process data
                    Stack.calculateFib(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("isExist")) {    // call methods isExist from stack class and process data
                    Stack.isExist(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("sumDistinctElements")) {   // call methods sumDistinctElements from stack class and process data
                    Stack.sumDistinctElements();
                }

                else if (repo[1].equals("evenReverse")) {   // call methods evenReverse from stack class and process data
                    ArrayList<Integer> eRlist = new ArrayList<Integer>();
                    stackOut.write("After evenReverse");
                    int i = 2;

                    while (i < repo.length) {
                        eRlist.add(Integer.parseInt(repo[i]));
                        i++;
                        stackOut.write(" ");
                        stackOut.write(String.valueOf(repo[i - 1]));
                    }
                    stackOut.write(":" + "\n");
                    Stack.evenReverse(eRlist);
                }
            }

            else {                                          //process queue data
                if (repo[1].equals("insertNumbers")) {  // call methods insertNumber from queue class and process data
                    int i = 1;
                   queueOut.write("After insertNumbers ");
                    while (i < repo.length-1){
                        queueOut.write(" ");
                        queueOut.write(repo[i+1]);
                        Queue.insertNumber(Integer.parseInt(repo[i+1]));
                        i++;
                    }
                    queueOut.write(":\n");
                    for (Integer integer : Queue.queue) {
                        queueOut.write(String.valueOf(integer)+" ");
                    }
                    queueOut.write("\n");
                }

                else if(repo[1].equals("clear")){   // call methods clear from queue class and process data
                    Queue.clearQueue();
                }

                else if(repo[1].equals("checkNumber")){ // call methods checkNumber from queue class and process data
                    Queue.checkNumber(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("reverse")){    // call methods reverse from queue class and process data
                   Queue.reverse(Integer.parseInt(repo[2]));
                }

                else if(repo[1].equals("calculateFib")){    // call methods calculateFib from queue class and process data
                    Queue.calculateFib(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("isExist")){    // call methods isExist from queue class and process data
                    Queue.isExist(Integer.parseInt(repo[2]));
                }

                else if (repo[1].equals("sumDistinctElements")){    // call methods sumDistinctElements from queue class and process data
                    Queue.sumDistinctElements();
                }

                else if(repo[1].equals("evenReverse")){ // call methods evenReverse from queue class and process data
                    ArrayList<Integer> eRlist = new ArrayList<Integer>();
                    queueOut.write("After evenReverse");
                   int i=2;
                    while (i<repo.length){
                        eRlist.add(Integer.parseInt(repo[i]));
                        i++;
                        queueOut.write(" ");
                        queueOut.write(String.valueOf(repo[i-1]));
                    }
                    queueOut.write(":"+"\n");
                    Queue.evenReverse(eRlist);
                }
            }
        }
        stackOut.close();
        queueOut.close();
    }
}
