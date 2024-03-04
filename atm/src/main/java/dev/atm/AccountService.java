package dev.atm;

import dev.atm.Entity.Account;
import dev.atm.Repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = true)
    public Account checkLogin(String login, String pin) {
        if (!login.isEmpty() && !pin.isEmpty() && pin.matches("\\d+")) {
            Optional<Account> acc = accountRepository.findByLoginAndPin(login, Integer.parseInt(pin));
            if (acc.isPresent())
                return acc.get();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Account getAccountById(int id) {
        Optional<Account> acc = accountRepository.findById(id);
        return acc.orElse(null);
    }

    @Transactional
    public BigDecimal setBalance(int id, String amount, boolean add) {
        if (amount.matches("\\d{1,8}(\\.\\d{1,2})?")) {
            BigDecimal am = new BigDecimal(amount);
            Account acc = getAccountById(id);
            if (acc != null) {
                if (!add) { // subtracting balance
                    BigDecimal difAmount = acc.getBalance().subtract(am);
                    if (difAmount.compareTo(new BigDecimal(0)) >= 0)
                        acc.setBalance(difAmount);
                }
                else if (am.compareTo(new BigDecimal(0)) > 0) // adding balance
                    acc.setBalance(acc.getBalance().add(am));
                try {
                    return accountRepository.save(acc).getBalance();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }



}
