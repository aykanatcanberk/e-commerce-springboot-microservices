package dto;

import customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerResponseDto {

    private String id;
    private String firstname;
    private String lastname;
    private String email;

    private Address address;
}
