package repository;

import customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
