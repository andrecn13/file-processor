package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.model.Customer;
import com.andrenunes.fileprocessor.stubs.CustomerStub;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFactoryTest {

    private CustomerFactory customerFactory;

    public CustomerFactoryTest() {
        this.customerFactory = new CustomerFactory();
    }

    @Test
    public void testBuildValidCustomer() {
        Customer customer = (Customer) customerFactory.build("002ç2345675434544345çJose da SilvaçRural");
        Customer customerExpected = CustomerStub.getCustomerStub();

        assertNotNull(customer);
        assertEquals(customerExpected.getBusinessArea(), customer.getBusinessArea());
        assertEquals(customerExpected.getCnpj(), customer.getCnpj());
        assertEquals(customerExpected.getName(), customer.getName());

    }
}
