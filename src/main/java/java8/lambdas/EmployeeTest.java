package java8.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee1 = new Employee("12345", 50000);
        Employee employee2 = new Employee("sfddst", 65000);

        EmployeeDatabase employeeDatabase = new EmployeeDatabase();

        employeeDatabase.register(employee1);
        employeeDatabase.register(employee2);

        Stream.of("12345", "sfddst").map(employeeDatabase::findById).filter(e -> e.get().getSalary() > 50000).forEach(e -> System.out.println(e.get()));
    }


    private static class Employee {
        private UUID uuid;
        private String id;
        private int salary;

        public Employee(String id, int salary) {
            this.id = id;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static class EmployeeDatabase {

        private List<Employee> employeeList = new ArrayList<>();

        public void register(Employee e) {
            employeeList.add(e);
        }

        public Optional<Employee> findById(String id) {
            return employeeList.stream().filter(e -> e.getId().equals(id)).findFirst();
        }

        public List<Employee> getAll() {
            return employeeList;
        }
    }
}
