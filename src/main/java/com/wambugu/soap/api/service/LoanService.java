package com.wambugu.soap.api.service;

import com.wambugu.wambugu.soap.api.loaneligibility.CustomerRequest;
import com.wambugu.wambugu.soap.api.loaneligibility.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerResponse response(CustomerRequest customerRequest){
        CustomerResponse response=new CustomerResponse();
        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("456");
        response.setEligible(false);
        response.setRandomId(list);
        CustomerResponse responseq=new CustomerResponse();
        responseq.setEligible(true);
        responseq.setRandomId(list);

      return customerRequest.getSalary()<=40000?response:responseq;



    }
}
