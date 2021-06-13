package me.godlycoder.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public abstract class JsonFile {
    public final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    private final File file;

    public JsonFile(File file) {
        this.file = file;
    }

    public abstract void create();

    public abstract void load();

    public abstract void save();

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

}
