package dev.atm;

import dev.atm.Entity.Account;
import dev.atm.Enum.Role;
import dev.atm.Repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestAccountService {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testCheckLogin() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.findByLoginAndPin("user1", 123)).thenReturn(Optional.of(account));
        Account a = accountService.checkLogin("user1", "123");
        assertEquals(a.getLogin(), "user1");
        assertEquals(a.getPin(), 123);
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        Account a = accountService.getAccountById(1);
        assertEquals(a.getId(), 1);
    }

    @Test
    public void testSetBalance() {
        Account account = new Account("user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        when(accountRepository.save(account)).thenReturn(account);
        BigDecimal b = accountService.setBalance(1, "45000", true);
        assertEquals(b, new BigDecimal(48000));
    }

    @Test
    public void testAddNewAccount() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.save(account)).thenReturn(account);
        int id = accountService.addNewAccount(account);
        assertEquals(id, 1);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        int id = accountService.updateAccount(account, 1);
        assertEquals(id, 1);
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));
        boolean b = accountService.deleteAccount(1);
        assertTrue(b);
    }

    @Test
    public void testGetCurrentRole() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        assertEquals(account.getCurrentRole(), Role.Admin);
    }

    @Test
    public void testGetCurrentStatus() {
        Account account = new Account(1,"user1", 123, "User", new BigDecimal(3000), true, true);
        assertEquals(account.getCurrentStatus(), "Active");
    }

}
