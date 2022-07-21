package az.spring.rest.demo.springrestdemo.rest.model.response;

import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder //mapping uchun
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private List<EmployeeDto>employees;
}
