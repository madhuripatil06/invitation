package party.application;

import party.operator.ArgumentSplitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintLabel {
    public static void main(String[] args) throws IOException{
        ArgumentSplitter arguments = new ArgumentSplitter(args);
        String[] option = arguments.options;
        String [] files = arguments.files;
        for (String file : files) {
            GuestList guests = new GuestList(arguments.getFilters());
            FileReader fr = new FileReader( new File(file));
            BufferedReader br = new BufferedReader(fr);
            while(br.readLine() != null){
                    guests.add(br.readLine());
            }
            guests.print(option);
        }
    }
}
