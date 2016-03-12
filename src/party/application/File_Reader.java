package party.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class File_Reader {
    private String fileName;

    public File_Reader(String fileName) {

        this.fileName = fileName;
    }

    public String getData() throws IOException{
        File file1 = new File(fileName);
        FileInputStream in = new FileInputStream(file1);
        String data = "";
        for(int index = 0 ;index < file1.length() ;index++){
            data += (char)in.read();
        }
        return data;
    }
}
