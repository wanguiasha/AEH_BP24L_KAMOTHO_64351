public class mySeventhapp1 {

        public static void main(String[] args) {
            Person person1 = new Person();
            person1.hiToAll();

            person1.forename = "John";
            person1.surname = "Doe";
            person1.age = 24;
            person1.address = "123 Main St";
            person1.year_of_birth = 2001;
            person1.hiToAll();

            Person person2 = new Person("Alice", "Hart", 42);
            person2.address = "456 Elm St";
            person2.year_of_birth = 1983;
            person2.hiToAll();

            person1.growOld(5); // age +5
            for (int i = 0; i < 3; i++) {
                person2.beYounger(); // age -1 three times
            }

            person1.hiToAll();
            person2.hiToAll();

            System.out.println(person1.getName());
            person1.setName("Lolo");
            System.out.println(person1.getName());
            person1.hiToAll();
        }
    }

    // Add the Person class inside the same file (non-public)
    class Person {
        public String forename;
        public String surname;
        public int age;
        public String address;
        public int year_of_birth;

        public Person() {}

        public Person(String forename, String surname, int age) {
            this.forename = forename;
            this.surname = surname;
            this.age = age;
        }

        public void hiToAll() {
            System.out.println("Hi! I'm " + forename + " " + surname + ", age " + age +
                    (address != null ? ", address: " + address : "") +
                    (year_of_birth != 0 ? ", born in: " + year_of_birth : ""));
        }

        public void growOld(int years) {
            age += years;
        }

        public void beYounger() {
            age -= 1;
        }

        public String getName() {
            return forename;
        }

        public void setName(String forename) {
            this.forename = forename;
        }
    }

