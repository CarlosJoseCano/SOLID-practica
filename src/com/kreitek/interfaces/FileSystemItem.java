package com.kreitek.interfaces;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    String getFullPath();
    int getSize();
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);


}
