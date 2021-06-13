package me.godlycoder.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class JsonFile {
    public final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public abstract void create();

    public abstract void load();

    public abstract void save();

    public abstract void createOrLoad();
}
