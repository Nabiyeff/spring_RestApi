package az.spring.rest.demo.springrestdemo.repository;

import az.spring.rest.demo.springrestdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee>findByNameAndSurname(String name, String surname);
}
