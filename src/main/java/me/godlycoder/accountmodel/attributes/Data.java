package me.godlycoder.accountmodel.attributes;

import lombok.Getter;
import lombok.Setter;
import me.godlycoder.encryption.Encryption;

import java.util.UUID;

@Setter @Getter
public class Data {
    private UUID uuid;
    private String address, name, password, rank;
    private double gold, gem, exp;

    public void setPassword(String password) {
        this.password = Encryption.encrypt(password);
    }

    public void setAddress(String address) {
        this.address = Encryption.encrypt(address);
    }

    public String getPassword() {
        return Encryption.decrypt(password);
    }

    public String getAddress() {
        return Encryption.decrypt(address);
    }
}
