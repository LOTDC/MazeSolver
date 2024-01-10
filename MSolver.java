import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MSolver {

    //-----------------------------------------------------
    // Title: Map Solver Class
    // Author: Kaan Budak
    // Description: Apart from the stack and node class in this class, its main purpose is to have a method for solving the maze.
    // -----------------------------------------------------

    public static class Stack {
        // Title: Stack Class
        // Description: It is used to store the read elements.

        int s = 0; // Represents the number of elements in the stack

        public class Node {
            // Title: Node Class
            // Description: Node class prepared to use stack
            String data;
            Node next;

            Node(String d) {
                // Constructor for the node
                data = d;
                next = null;
            }
        }

        // Global top reference
        Node top;

        public Stack() {

            this.top = null;
        }

        public void push(String a) {
            // Summary: Utility function to add an element x in the stack
            // Precondition: Takes a string value named a
            // Postcondition: The received value is stored in the stack

            Node temp = new Node(a);

            if (temp == null) {
                System.out.println("Null Variable");
            }

            temp.next = top;
            top = temp;
            s++;
        }

        public String pop() {
            // Summary: Function to pop top element from the stack
            // Precondition: No precondition
            // Postcondition: The last element added to the stack is removed

            String a = top.data;
            top = top.next;

            return a;
        }

        public int size(){
            // Summary: Shows stack size
            // Precondition: No precondition
            // Postcondition: Stack size is returned

            return s;
        }

    }
    //Used to store reachable paths.
    static Stack sc = new Stack();
    static Stack sc2 = new Stack();

    public static void print(Stack a){
        // Summary: Arranges the mixed order elements of the received stack according to their size
        // Precondition: Takes a stack value named a
        // Postcondition: Arranges and print stack elements according to their size

        String [] d = new String[a.size()];

        for(int i = 0; i<a.size();i++){
            d [i] = a.pop();
        }

        String temp ="";
        // Sorts the paths in the stack from largest to smallest
        for(int i = 0; i<a.size();i++){
            for(int j = i+1; j<a.size();j++){
                if(d[i].length() < d[j].length()){
                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
        //Fills the second created stack
        for(int i =0; i<sc.size();i++){
            sc2.push(d[i]);
        }
        //Check if there is a reachable path.
        if(sc2.size() > 0) {
            // Prints from small to large
            for (int i = 0; i < sc.size(); i++) {
                System.out.println(i + 1 + ") " + sc2.pop());
            }
        }


    }

    public static void ms(char[][] m ,boolean[][] cp ,String mp ,int a ,int b ,int c ,int d) {
        // Summary: It is a recursive method that tries to reach the result by repeating the values it received at first.
        // Precondition: m(maze) is a two-dimensional char, cp is a two-dimensional boolean, a,b,c and d are integer.
        // Postcondition: Finds all reachable treasure paths.


        if (a == 1 && b == 0) {
            //  This statement controls the entrance
        }
        else if (a <= 0 || b <= 0 || a >= c - 1 || b >= d - 1 || cp[a][b] == true|| m[a][b] == '|' || m[a][b] == '-' || m[a][b] == '+'){
            return;
        }
        // cp (checked path) marks the paths traveled so that paths traveled are not taken again.
        cp[a][b] = true;

        // If the algorithm finds a way, it stores it on the stack
        if (m[a][b] == 'E'){
            mp = mp + m[a][b];
            sc.push(mp);
        }

        // The recursive method tries to find treasures by navigating around the maze.
        // In the control stages, it is checked whether the length of the map is exceeded and whether there are ways to go.
        if (a <= 0 || b <= 0 || a >= c - 1 || b >= d - 1 || cp[a][b] == true|| m[a][b] == '|' || m[a][b] == '-' || m[a][b] == '+'){
            ms(m, cp, mp + m[a][b], a - 1, b, c, d); // moving for upwards
            ms(m, cp, mp + m[a][b], a + 1, b, c, d); // moving for downwards
            ms(m, cp, mp + m[a][b], a, b + 1, c, d); // moving for right
            ms(m, cp, mp + m[a][b], a, b - 1, c, d); // moving for left
        }

        cp[a][b] = false;
    }


    public static void main(String[] args) {
        String temp ="",temp2 ="";
        char m [][];
        int v = 0;
        int a = 0;
        int b = 0;

        // Gets the filename from the user.
         Scanner scn = new Scanner(System.in);
         String txt = scn.nextLine();
        //String txt =  "C:\\Users\\LOTDC\\Desktop\\Mazes\\maze2.txt"; // You can also read the txt file this way

         // The existence of the txt file we receive from the user is checked. If true, the file is read and written into an empty string.
        try {
            Scanner scanner = new Scanner(new FileReader(txt));
            while(scanner.hasNextLine()){
                temp = temp.concat(scanner.nextLine());
                a++; // a represents the number of rows
            }

        }
        //If the filename is not correct, an error message is returned.
        catch (FileNotFoundException e) {
            System.out.println("Please enter the file name correctly.");
        }

        // b represents the number of columns
        b = (temp.length()/a);

        //A two-dimensional maze is created based on the number of rows and columns.
        m = new char[a][b];

        // A two-dimensional control maze is created based on the number of rows and columns.
        boolean[][] checked = new boolean[a][b];


        // The read map is transferred to the maze.
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <b; j++) {
                m [i][j] = temp.charAt(v);
                v++; //v serves to take each character of the read file and transfer it to maze in order.
            }
        }

        // All generated values are sent into ms (maze solver).
        ms(m, checked, temp2, 1, 0 ,a ,b);

        System.out.println(sc.size()+" treasures are found.");

        // Checks if a reachable element exists.
        if(sc.size() > 0) {
            System.out.println("Paths are:");
        }
        // All reachable paths are printed.
        print(sc);


    }

}
