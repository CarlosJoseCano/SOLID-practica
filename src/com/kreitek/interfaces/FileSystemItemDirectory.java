package com.kreitek.interfaces;

import java.util.List;

public interface FileSystemItemDirectory {
    List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);

}
