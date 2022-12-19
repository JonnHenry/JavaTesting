import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.example.Main.repeat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    @Test
    public void repeatStringOnce(){
        int times = 1;
        String result = repeat("hola",times);
        assertEquals(result,"hola");
    }

    @Test
    public void repeatStringMultipleTimes(){
        int times = 3;
        String result = repeat("hola",times);
        System.out.println(result);
        assertEquals(result,"holaholahola");
    }

    @Test
    public void repeatStringZeroTimes(){
        String result = repeat("hola",0);
        assertEquals(result,"");
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes(){
        String result = repeat("hola",-1);
    }
}
