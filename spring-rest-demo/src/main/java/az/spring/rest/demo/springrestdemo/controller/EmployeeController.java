package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import az.spring.rest.demo.springrestdemo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees") //resource name
@Tag(name = "Employee services",description = "employee services")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse geAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employee-id}") // path variable
    @Operation(summary = "This gets employee by id")
    public EmployeeDto getEmployee(@PathVariable("employee-id") long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname){

        return employeeService.getEmployeeByNameAndSurname(name,surname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid EmployeeDto employeeDto){
        employeeService.insert(employeeDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id){
        employeeService.update(employeeDto,id);
    }

    @PatchMapping("/{id}")
    public void updateSome(@RequestBody EmployeeDto employeeDto, @PathVariable("id") long id){
        employeeService.updateSome(employeeDto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        employeeService.delete(id);
    }
}
