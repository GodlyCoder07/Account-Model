package me.godlycoder.accountmodel.attributes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter @Getter
public class Social {
    List<UUID> friends = new ArrayList<>();
}
