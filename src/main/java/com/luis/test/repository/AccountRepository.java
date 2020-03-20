package com.luis.test.repository;

import com.luis.test.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Object findByIdNumber(Class Account, Integer idNumber);
}
