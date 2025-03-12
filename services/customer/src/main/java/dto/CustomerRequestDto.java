package dto;

import customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CustomerRequestDto {
    private String id;

    @NotNull(message = "This field is required")
    private String firstname;

    @NotNull(message = "This field is required")
    private String lastname;

    @NotNull(message = "This field is required")
    @Email(message = "Customer email is not valid!")
    private String email;

    private Address address;
}