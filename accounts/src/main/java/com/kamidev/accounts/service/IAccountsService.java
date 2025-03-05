package com.kamidev.accounts.service;

import com.kamidev.accounts.dto.CustomerDto;

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

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
