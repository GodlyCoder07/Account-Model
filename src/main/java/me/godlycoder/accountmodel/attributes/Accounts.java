package me.godlycoder.accountmodel.attributes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Accounts {
    private final List<Account> accounts = new ArrayList<>();
}
