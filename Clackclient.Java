<@!650842150463995904> import java.util.*;


public class thingforhwyes {

    public static void printList(List<String> lt) {
        for (int i = 0; i < lt.size(); ++i) {
            System.out.println((i+1) + ": " + lt.get(i));
        }
        System.out.println("----");
    }

    public static void addList(List<String> lt, String item) {
        // ADD IMPLEMENTATION HERE
        lt.add(item);
        System.out.println("Added [" + item + "] to the TODO list");
        
    }

    public static void removeList(List<String> lt, int num) {
        //System.out.println(num);
        lt.remove(num-1);
        System.out.println("Removed item #" + num + " from the TODO list");
        // ADD IMPLEMENTATION HERE
    }
    
    public static void listItem(List<String> lt, int item) {
        System.out.println("Item Number " + item  + ": " + lt.get(item-1));
    }
        
    public static void moveItem(List<String> lt, int index1, int index2) {
        String temp = lt.get(index1-1);
        lt.set(index1-1, lt.get(index2-1));
        lt.set(index2-1, temp);
        printList(lt);
    }
    
    public static void updateItem(List<String> lt, int index, String value) {
        lt.set(index-1, value);
        printList(lt);
    }
    
    public static void main(String[] args) {
        List<String> todo = new LinkedList<String>();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String cmd = scan.nextLine();

            if ("quit".equals(cmd)) {
                System.out.println("Thank you for using the TODO list application");
                break;
            } else if ("list".equals(cmd)) {
                printList(todo);
            } else if(cmd.startsWith("list") && cmd.length() > 4) { 
                int index = Integer.parseInt(cmd.substring(5));
                if( index > todo.size() || index <1 ) {
                    System.out.print("Index is out of range, please try again");
                } else {
                    listItem(todo, index);
                }
            } else if(cmd.startsWith("move") && cmd.length() > 4) {
                String[] cmdlist = cmd.split(" ");
                int index1 = Integer.parseInt(cmdlist[1]);
                int index2 = Integer.parseInt(cmdlist[2]);
                if( index1 > todo.size() || index1 <1 ) {
                    System.out.print("Index 1 is out of range, please try again");
                    continue;
                } 
                if( index2 > todo.size() || index2 <1 ) {
                    System.out.print("Index 2 is out of range, please try again");
                    continue;
                } 
                moveItem(todo, index1, index2);
                } else if(cmd.startsWith("update") && cmd.length() > 6) {
                String[] cmdlist = cmd.split(" ");
                int index = Integer.parseInt(cmdlist[1]);
                String value = cmdlist[2];
                if( index > todo.size() || index <1 ) {
                    System.out.print("Index is out of range, please try again");
                    continue;
                }
                updateItem(todo, index, value);
            } else if(cmd.startsWith("randomize")) {
                Collections.shuffle(todo);
                printList(todo);
            } else if (cmd.startsWith("add")) {
                addList(todo, cmd.substring(4));
            } else if (cmd.startsWith("remove")) {
                int num = Integer.parseInt(cmd.substring(7));
                //System.out.println(num);
                if ( num >= 1 && num <= todo.size()) {
                    removeList(todo, num);
                } else {
                    System.out.println("Item #" + num + " not found.");
                }
            } else {
                System.out.println("Command [" + cmd + "] not found.");
                
