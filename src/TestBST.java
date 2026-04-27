public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(1, "one");
        tree.put(4, "four");
        tree.put(6, "six");
        tree.put(8, "eight");

        System.out.println(tree.get(4));
        System.out.println(tree.get(10));

        System.out.println("Size: " + tree.size());

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(7);

        System.out.println("After delete:");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        System.out.println("Size: " + tree.size());
    }
}