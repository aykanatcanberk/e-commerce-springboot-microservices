package mapper;

import customer.Customer;
import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequestDto request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
