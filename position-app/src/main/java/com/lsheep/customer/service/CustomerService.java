package com.lsheep.customer.service;

import com.lsheep.customer.dto.CustomerDTO;
import com.lsheep.customer.dto.QueryCustomer;

public interface CustomerService {

	CustomerDTO detail(QueryCustomer queryCustomer);

}
