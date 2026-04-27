public class Student {
    private String name;
    private int age;
    private int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int hashCode() {
        int hash = 7;

        for (int i = 0; i < name.length(); i++) {
            hash = hash * 31 + name.charAt(i);
        }

        hash = hash * 31 + age;
        hash = hash * 31 + id;

        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;

        return this.id == other.id &&
                this.age == other.age &&
                this.name.equals(other.name);
    }

    public String toString() {
        return name + " " + age + " " + id;
    }
}