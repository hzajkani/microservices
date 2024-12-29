package com.techsphere.accounts.service.impl;

import com.techsphere.accounts.constants.AccountsConstants;
import com.techsphere.accounts.dto.CustomerDto;
import com.techsphere.accounts.entity.Accounts;
import com.techsphere.accounts.entity.Customer;
import com.techsphere.accounts.exception.CustomerAlreadyExistsException;
import com.techsphere.accounts.mapper.CustomerMapper;
import com.techsphere.accounts.repository.AccountsRepository;
import com.techsphere.accounts.repository.CustomerRepository;
import com.techsphere.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    /**
     * Creates a new account based on the provided customer details.
     *
     * @param customerDto The customer details to create the account with.
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber " + customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
