package com.eviden.e2e.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eviden.e2e.model.Contract;
import com.eviden.e2e.service.ContractService;
import com.eviden.e2e.util.JsonMap;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
	
    @Autowired
    ContractService contractService;

    @GetMapping
    JsonMap getSoftwareLicenses() {

        return JsonMap.map()
                .set("content", toDto(contractService.findAll()));
    }
 
    @PostMapping
    Contract createSoftwareLicense(@RequestBody Contract data) {
        return toDto(contractService.create(data));
    }

    @GetMapping("/{id}")
    Contract getContract(@PathVariable("id") Long id) throws NotFoundException {
    	Contract contract = contractService.get(id);

        return toDto(contract);
    }
    
    private List<Contract> toDto(List<Contract> contracts) {
    	contracts.forEach(this::toDto);
        return contracts;
    }

    private Contract toDto(Contract contract) {  
        return contract;
    }
}
