package com.kreitek.converter;

import com.kreitek.files.File;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.FileConverter;
import com.kreitek.interfaces.FileSystemItem;

public class ConverterMp3ToWav implements FileConverter {
    @Override
    public FileSystemItem convert(File item) {
        if (!"mp3".equalsIgnoreCase(item.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = item.getName().lastIndexOf(".");
        String nameWithoutExtension = item.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = item.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItem result = new File(item.getParent(), newFileName);
        //result.open();

        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result

        //result.close();
        return result;
    }
}
