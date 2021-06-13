package me.godlycoder.accountmodel.attributes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Account {
    private UUID uuid;
    private Data data = new Data();
    private Media media = new Media();
    private Social social = new Social();
}
