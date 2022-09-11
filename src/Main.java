import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people;
        people = initPersonList();
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age: ");
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getWeight));
        System.out.println("Sorted by weight: ");
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getHeight));
        System.out.println("Sorted by height: ");
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getWeight).thenComparing(Person::getHeight));
        System.out.println("Sorted by weight and height");
        System.out.println(people);
        System.out.println(countUnique(people));
    }

    static List<Pair<Integer, Integer>> countUnique(List<Person> people) {
        people.sort(Comparator.comparing(Person::getWeight).thenComparing(Person::getHeight));
        List<Pair<Integer, Integer>> resultList = new ArrayList<>();
        if (people.size() > 0) {
            Person temp = people.get(0);
            int count = 1;
            for (Person person: people) {
                if (person.getWeight() == temp.getWeight()) {
                    if (person.getHeight() != temp.getHeight()) {
                        count++;
                    }
                } else {
                    resultList.add(new Pair<>(temp.getWeight(), count));
                    count = 1;
                }
                temp = person;
            }
            resultList.add(new Pair<>(temp.getWeight(), count));
        }
        return resultList;
    }
    static List<Person> initPersonList() {
        return new ArrayList<>(List.of(
                new Person(170, 50, 21),
                new Person(146, 60, 11),
                new Person(170, 50, 44),
                new Person(154, 70, 54),
                new Person(170, 50, 53),
                new Person(178, 40, 76),
                new Person(189, 70, 35),
                new Person(145, 50, 21),
                new Person(123, 23, 42),
                new Person(170, 29, 22),
                new Person(150, 70, 62),
                new Person(177, 40, 33)
        ));
    }

    static class Pair <T, Y> {
        private T first;
        private Y second;

        public Pair(T first, Y second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public Y getSecond() {
            return second;
        }

        public void setSecond(Y second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "\nThere " +
                    second +
                    " unique people of weight " +
                    first;
        }
    }

    static class Person {
        private int height;
        private int weight;
        private int age;

        public Person(int height, int weight, int age) {
            this.height = height;
            this.weight = weight;
            this.age = age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "\nPerson{" +
                    "height=" + height +
                    ", weight=" + weight +
                    ", age=" + age +
                    '}';
        }
    }
}
