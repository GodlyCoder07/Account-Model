package me.godlycoder.accountmodel;

import me.godlycoder.json.JsonFile;
import me.godlycoder.accountmodel.attributes.Account;
import me.godlycoder.accountmodel.attributes.Accounts;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class AccountModel extends JsonFile {
    private final File file;

    private Accounts accounts;

    public AccountModel(File file) {
        this.file = file;
        this.createOrLoad();
    }

    @Override
    public void create() {
        accounts = new Accounts();
        save();
    }

    @Override
    public void load() {
        try {
            FileReader reader = new FileReader(file);
            accounts = gson.fromJson(reader, Accounts.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            FileWriter writer = new FileWriter(file);
            gson.toJson(accounts, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrLoad() {
        if (file.getParentFile() != null &&
                file.getParentFile().exists()) {
            boolean b = file.getParentFile().mkdir();
        }
        if (!file.exists()) {
            create();
        }
        load();
    }

    public void add(Account account) {
        load();
        accounts.getAccounts().add(account);
        save();
    }

    public Account get(UUID uuid) {
        load();
        return accounts.getAccounts()
                .stream()
                .filter(acc -> acc.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public boolean contains(UUID uuid) {
        load();
        return get(uuid) != null;
    }

    public boolean contains(Account account) {
        load();
        return accounts.getAccounts().contains(account);
    }

}
