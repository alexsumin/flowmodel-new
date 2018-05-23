package ru.alexsumin.flowmodel.services;

import org.springframework.stereotype.Service;
import ru.alexsumin.flowmodel.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean checkAdminPassword(String enteredPassword) {
        String realPassword =  accountRepository.findById(1).get().getPassword();
        return realPassword.equals(enteredPassword);
    }
}
