package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.services.RepositoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TransactionsController {

    @GetMapping("/transactions")
    public String transactions(ModelMap model){
        RepositoryService repositoryService = new RepositoryService();
        model.put("transactions",repositoryService.getAllTransactions());
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String findById(@PathVariable Integer transactionId,ModelMap model){
        RepositoryService repositoryService = new RepositoryService();
        model.put("transaction",repositoryService.findById(transactionId));
        return "transactionId";
    }
}
