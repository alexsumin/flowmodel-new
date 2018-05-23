package ru.alexsumin.flowmodel.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alexsumin.flowmodel.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
