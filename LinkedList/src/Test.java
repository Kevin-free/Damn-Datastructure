public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFrist(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(2,666);
        System.out.println(linkedList.toString());
        linkedList.set(1,555);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains(555));
        linkedList.remove(2);
        System.out.println(linkedList.toString());
    }
}
