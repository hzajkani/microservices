package com.techsphere.accounts.service;

import com.techsphere.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account based on the provided customer details.
     *
     * @param customerDto The customer details to create the account with.
     */
    void createAccount(CustomerDto customerDto);
}
