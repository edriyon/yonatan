package bgu.spl.mics.application.Message;

import bgu.spl.mics.Event;

public class CheckAvailability  implements Event {
    private String bookName;

    public CheckAvailability(String bookName)
    {
        this.bookName = bookName;
    }


    public String getBookName()
    {
        return bookName;
    }
}
