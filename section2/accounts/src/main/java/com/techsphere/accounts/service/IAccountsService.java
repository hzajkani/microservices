package com.techsphere.accounts.service;

import com.techsphere.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account based on the provided customer details.
     *
     * @param customerDto The customer details to create the account with.
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Retrieves the account details based on the provided mobile number.
     *
     * @param mobileNumber The mobile number to fetch the account for.
     * @return The account details associated with the given mobile number.
     */
    CustomerDto fetchAccount(String mobileNumber);
}
