package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.interfaces.FileSystemItem;

public class FileSystemBuilder {

    private final FileSystemItem root;
    private Directory currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
        currentDirectory = (Directory)root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        File file = new File(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        Directory directory = new Directory(currentDirectory, name);
        currentDirectory.addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = (Directory)currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
