package com.prj;

import java.io.File;
import java.io.FilenameFilter;

public class CheckFile implements FilenameFilter {
    private String fileName;

    public CheckFile(String name) {
        this.fileName = name.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        String nameLowercase = name.toLowerCase();
        return nameLowercase.startsWith(this.fileName) && nameLowercase.endsWith(this.fileName);
    }
}