package party.application;

import party.operator.ArgumentSplitter;

import java.io.*;

public class PrintLabel {
    public static void main(String[] args) throws IOException{
        ArgumentSplitter arguments = new ArgumentSplitter(args);
        Printer invitationCoverPrinter = new InvitationCoverPrinter();
        String[] option = arguments.getStyle();
        String [] files = arguments.getFiles();
        for (String file : files) {
            File_Reader file_reader = new File_Reader(file);
            String data = file_reader.getData();
            CreateGuestList guests = new CreateGuestList(data);
            guests.createList();
            FilterList filtredData = new FilterList(arguments.getFilters(),guests.getList());
            invitationCoverPrinter.print(filtredData.getFilteredGuest(),arguments.getFilters(),option[0]);
        }
    }
}
