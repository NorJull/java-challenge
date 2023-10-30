package challenge.java8Features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EmployeeFactory factory = new EmployeeFactory();
        List<Employee> employees = factory.getAllEmployee();

        /* List all distinct project in non-ascending order
        employees.stream()
                .flatMap(employee -> {
                           return employee.getProjects().stream().map(project -> project.getName());
                        }
                )
                .distinct()
                .sorted((s1, s2) -> (s1.compareTo(s2)) * -1)
                .forEach(System.out::println);

         */

        /*  Sort employees based on firstName, for same firstName sort by salary.

        employees.stream().sorted((e1, e2) -> {
            if( e1.getFirstName() == e2.getFirstName()) {
                return e1.getSalary() > e2.getSalary() ? 1 : -1;
            }
           return e1.getFirstName().compareTo(e2.getFirstName()) ;

        }).forEach(employee -> {
            System.out.println(employee.getFirstName() + employee.getLastName());
        });



        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getSalary)).forEach(employee -> {
            System.out.println(employee.getFirstName() + employee.getLastName());
        });

         */

        /*
        * 13. Create a map based on this data, they key should be the year of joining,
        *   and value should be list of all the employees who joined the particular year.
        * */

        /*
        Map<String, List<Employee>> r = employees.stream().collect(Collectors.groupingBy(e -> {
            String year = e.getId().substring(0, 4);
            return year;
        }, Collectors.toList()));
        */

        // 10. Count of all projects with Robert Downey Jr as PM.

    /*
        long count = employees.stream().flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager() == "Robert Downey Jr").count();

        System.out.println(count);
    */




      // Encontrar el segundo número más pequeño: Encuentra el segundo número más pequeño en la lista.
        List<Integer> numbers = Arrays.asList(5, 12, 8, 3, 20, 7, 14, 6, 10, 15);
 /*
        numbers.stream()
                .sorted()
                .skip(1)
                .findFirst().ifPresent(integer -> {
            System.out.println(integer);
        });*/

        /*
        * Dividir números en dos listas: pares e impares:
        *  Divide la lista de números en dos listas separadas: una para los números pares y otra para los números impares.
        * */
    /*
        Map<String, List<Integer>> result =
                numbers.stream()
                        .collect(Collectors.groupingBy(number -> number % 2 == 0 ? "PAR" : "IMPAR", Collectors.toList()));
        result.forEach((key, value) -> {
            System.out.println(key + ": " + value);

        });

     */
        /*
        * project manger with more employee
        * */
        /*
        Map<String, Long> mapResult = employees.stream().flatMap(employee -> {

            return employee.getProjects()
                    .stream().collect(Collectors.toMap(project -> project.getProjectManager(), project -> employee,(p1, p2) -> p1 ))
                    .entrySet().stream();


        }).collect(Collectors.groupingBy(entry -> entry.getKey(), Collectors.counting()));

        mapResult.entrySet().stream().sorted((e1, e2) -> e1.getValue() < e2.getValue() ? 1 : -1)
                .findFirst().ifPresent(stringLongEntry -> {
                    System.out.println(stringLongEntry.getKey());
                });
        */

        /*employeeList.stream()
        .flatMap(employee -> employee.getProjects().stream().map(Project::getProjectManager))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .ifPresent(System.out::println);*/

    //projecto con mas dinero

        employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .collect(Collectors.toMap(project -> project.getName(), project -> {
                    return employees.stream()
                            .filter(employee ->
                                    employee.getProjects().stream().anyMatch(p -> p.getName().equals(project.getName())))
                            .mapToInt(employee -> employee.getSalary())
                            .sum();
                }))
                .entrySet()
                .stream().sorted((e1, e2) -> e1.getValue() < e2.getValue() ? 1 : -1)
                .forEach(stringLongEntry -> {
                    System.out.println(stringLongEntry.getKey() + ": " + stringLongEntry.getValue());});

                /*.findFirst().ifPresent(stringLongEntry -> {
                    System.out.println(stringLongEntry.getKey() + ": " + stringLongEntry.getValue());
                });*/
    }
}
