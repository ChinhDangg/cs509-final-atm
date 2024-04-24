package dev.atm.Entity;

import dev.atm.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Login", nullable = false)
    private String login;
    @Column(name = "Pin", nullable = false)
    private int pin;
    @Column(name = "HoldersName", nullable = false)
    private String holdersName;
    @Column(name = "Balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;
    @Column(name = "Status", nullable = false)
    private boolean status;
    @Column(name = "Role", nullable = false)
    private boolean role;

    public Account(String login, int pin, String holdersName, BigDecimal balance, boolean status, boolean role) {
        this.login = login;
        this.pin = pin;
        this.holdersName = holdersName;
        this.balance = balance;
        this.status = status;
        this.role = role;
    }

    public Account(String login, int pin, String holdersName, boolean status, boolean role) {
        this.login = login;
        this.pin = pin;
        this.holdersName = holdersName;
        this.status = status;
        this.role = role;
    }

    /**
     * Admin if true else Client
     */
    public Role getCurrentRole() {
        return (role) ? Role.Admin : Role.Client;
    }

    /**
     * Active if true else Disabled
     */
    public String getCurrentStatus() {
        return (status) ? "Active" : "Disabled";
    }
}