package com.kreitek.interfaces;

import com.kreitek.files.File;

public interface FileConverter {
    FileSystemItem convert(File file);
}
