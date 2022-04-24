package com.kreitek.converter;

import com.kreitek.files.File;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.FileConverter;
import com.kreitek.interfaces.FileSystemItem;

public class ConverterWavToMp3 implements FileConverter {
    @Override
    public FileSystemItem convert(File item) {
        if (!"wav".equalsIgnoreCase(item.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = item.getName().lastIndexOf(".");
        String nameWithoutExtension = item.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = item.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItem result = new File(item.getParent(), newFileName);
        //result.open();

        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result

        //result.close();
        return result;
    }
}
