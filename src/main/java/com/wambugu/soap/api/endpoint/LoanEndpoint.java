package com.wambugu.soap.api.endpoint;

import com.wambugu.soap.api.service.LoanService;
import com.wambugu.wambugu.soap.api.loaneligibility.CustomerRequest;
import com.wambugu.wambugu.soap.api.loaneligibility.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEndpoint {

    private  static final String NAMESPACE= "http://www.wambugu.com/wambugu/soap/api/loaneligibility";

    @Autowired
    private LoanService loanService;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE,localPart ="CustomerRequest")
    public CustomerResponse getResponse(@RequestPayload CustomerRequest customerRequest){
        return loanService.response(customerRequest);
    }
}
