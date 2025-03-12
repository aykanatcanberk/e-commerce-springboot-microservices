package service;

import customer.Customer;
import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.CustomerMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequestDto request) {
        var customer = this.repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequestDto request) {
        var customer = repository.findById(request.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        
        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequestDto request) {
        if(StringUtils.isNotBlank(request.getFirstname())){
            customer.setFirstname(request.getFirstname());
        }
        if(StringUtils.isNotBlank(request.getLastname())){
            customer.setFirstname(request.getLastname());
        }
        if(StringUtils.isNotBlank(request.getEmail())){
            customer.setEmail(request.getEmail());
        }
        if (request.getAddress()!=null){
            customer.setAddress(request.getAddress());
        }
    }

    public List<CustomerResponseDto> getAllCustomers() {

        List<Customer> customers = repository.findAll();

        return customers.stream()
                .map(mapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    public Boolean existById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponseDto findById(String customerId) {
        return mapper.toCustomerResponseDto(repository.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found")));
    }


    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
