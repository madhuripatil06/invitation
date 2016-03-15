package party.design;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlusDashDesignTest {
    @Test
    public void PlusDashDesignShouldProvideTheNameAddressInTheDesignForMale() throws Exception {
        Design design = new PlusDashDesign();
        String pattern = design.DesignPattern("Mr Kreiger, Ola","Katlynn view, Vermont,\nRomania");
        String expected = "+------------------------+\n"+
                                    "| Mr Kreiger, Ola        |\n"+
                                    "|------------------------|\n"+
                                    "| Katlynn view, Vermont, |\n"+
                                    "| Romania                |\n"+
                                    "+------------------------+\n";
        assertEquals(expected,pattern);
    }

    @Test
    public void PlusDashDesignShouldProvideTheNameAddressInTheDesignForFemale() throws Exception {
        Design design = new PlusDashDesign();
        String pattern = design.DesignPattern("Ms lila, desai","Katlynn view, Vermont,\nRomania");
        String expected =  "+------------------------+\n"+
                                    "| Ms lila, desai         |\n"+
                                    "|------------------------|\n"+
                                    "| Katlynn view, Vermont, |\n"+
                                    "| Romania                |\n"+
                                    "+------------------------+\n";
        assertEquals(expected,pattern);
    }
}