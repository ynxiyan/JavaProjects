package com.wisezone.features.there.test;

import com.wisezone.features.there.FileOperation;
import com.wisezone.features.two.FileReadAndWriter;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 14:48
 * @注释:
 */
public class TestFile {
    FileOperation files = new FileOperation();

    @Test
    public void testCreateFile() {
        files.createFile(new File(FileReadAndWriter.path));
        files.createFile(new File(FileReadAndWriter.outPath));
    }

    @Test
    public void testDeleteFile() {
        files.deleteFile(new File(FileReadAndWriter.path));
    }

    @Test
    public void testReadFile() {
        files.readFile(new File(FileReadAndWriter.outPath));
    }
}
