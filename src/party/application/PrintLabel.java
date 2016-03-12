package party.application;

import party.operator.ArgumentSplitter;

import java.io.*;

public class PrintLabel {
    private static String readFile(String file) throws IOException{
        File file1 = new File(file);
        FileInputStream in = new FileInputStream(file1);
        String data = "";
        for(int index = 0 ;index < file1.length() ;index++){
            data += (char)in.read();
        }
        return data;
    }

    public static void main(String[] args) throws IOException{
        ArgumentSplitter arguments = new ArgumentSplitter(args);
        Printer invitationCoverPrinter = new InvitationCoverPrinter();
        String[] option = arguments.getStyle();
        String [] files = arguments.getFiles();
        for (String file : files) {
            String data = readFile(file);
            CreateGuestList guests = new CreateGuestList(data);
            guests.createList();
            FilterList filtredData = new FilterList(arguments.getFilters(),guests.getList());
            invitationCoverPrinter.print(filtredData.getFilteredGuest(),arguments.getFilters(),option[0]);
        }
    }
}
