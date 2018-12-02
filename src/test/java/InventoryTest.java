package bgu.spl.mics.application.passiveObjects;

import org.junit.Test;

import static bgu.spl.mics.application.passiveObjects.OrderResult.NOT_IN_STOCK;
import static bgu.spl.mics.application.passiveObjects.OrderResult.SUCCESSFULLY_TAKEN;
import static org.junit.Assert.*;

public class InventoryTest {
    Inventory x = Inventory.getInstance();
    BookInventoryInfo HarryPotter=new BookInventoryInfo("Harry Potter",1,130);
    @Test
    public void getInstance() {
        //  assertSame(x.getInstance());
    }

    @Test
    public void load() {
        BookInventoryInfo[] temp={HarryPotter};
        x.load(temp);
        assertEquals(SUCCESSFULLY_TAKEN,x.take("Harry Potter" ));
        assertEquals(130,x.checkAvailabiltyAndGetPrice("Harry Potter"));
    }

    @Test
    public void take() {
        BookInventoryInfo[] temp={HarryPotter};
        x.load(temp);
        assertEquals(SUCCESSFULLY_TAKEN,x.take("Harry Potter" ));
        assertEquals(NOT_IN_STOCK,x.take("Harry Potter" ));
        assertEquals(NOT_IN_STOCK,x.take("blalabal"));
    }

    @Test
    public void checkAvailabiltyAndGetPrice() {

        BookInventoryInfo[] temp={HarryPotter};
        x.load(temp);
        assertEquals(130,x.checkAvailabiltyAndGetPrice("Harry Potter"));
        assertEquals(-1,x.checkAvailabiltyAndGetPrice("Bla bla"));
    }
    @Test
    public void printInventoryToFile() {
    }
}