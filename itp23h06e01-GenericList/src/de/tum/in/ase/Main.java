package de.tum.in.ase;

public class Main {
    public static void main(String[] args) {

        ListNode<String> node0 = new ListNode<>("0",null,null);
        ListNode<String> node1 = new ListNode<>("1");

        LinkedList<String> myList = new LinkedList<>();
        System.out.println(myList.size());
        System.out.println(myList.isEmpty());
        System.out.println(myList.indexOf(null));

        myList.setFirst(node0);
        myList.setLast(node0);
        System.out.println(myList);

        myList.add("2");
        System.out.println(myList);

        myList.add(1,"1");
        System.out.println(myList.toString());

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        //System.out.println(myList.get(3));

        System.out.println(myList.indexOf(null));

        myList.add("1");
        System.out.println(myList);
        myList.remove("5");
        myList.remove("1");
        System.out.println(myList);







    }
}
