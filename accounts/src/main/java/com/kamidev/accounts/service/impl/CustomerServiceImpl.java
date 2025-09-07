package com.kamidev.accounts.service.impl;

import com.kamidev.accounts.client.CardsFeignClient;
import com.kamidev.accounts.client.LoansFeignClient;
import com.kamidev.accounts.dto.AccountsDto;
import com.kamidev.accounts.dto.CardsDto;
import com.kamidev.accounts.dto.CustomerDetailsDto;
import com.kamidev.accounts.dto.LoansDto;
import com.kamidev.accounts.entity.Accounts;
import com.kamidev.accounts.entity.Customer;
import com.kamidev.accounts.exception.ResourceNotFoundException;
import com.kamidev.accounts.mapper.AccountsMapper;
import com.kamidev.accounts.mapper.CustomerMapper;
import com.kamidev.accounts.repository.AccountsRepository;
import com.kamidev.accounts.repository.CustomerRepository;
import com.kamidev.accounts.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId", String.valueOf(customer.getCustomerId())));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());


        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
