package controller;

import customer.Customer;
import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final HandlerMapping resourceHandlerMapping;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequestDto request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequestDto request
    ){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> findAll(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/exist/{customerId}")
    public ResponseEntity<Boolean> existById(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(service.existById(customerId));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable("customerId") String customerId){
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
