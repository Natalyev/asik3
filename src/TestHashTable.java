public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<Student, String> table = new MyHashTable<>(11);

        for (int i = 0; i < 10000; i++) {
            Student student = new Student("Student" + i, 18 + i % 10, i);
            table.put(student, "Value" + i);
        }

        table.printBucketSizes();

        Student s1 = new Student("Ayan", 19, 777);
        table.put(s1, "AITU");

        System.out.println(table.get(s1));
        System.out.println(table.contains("AITU"));
        System.out.println(table.getKey("AITU"));
        System.out.println(table.remove(s1));
        System.out.println(table.contains("AITU"));
    }
}
