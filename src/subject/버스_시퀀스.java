package subject;

import java.util.ArrayList;
import java.util.List;

public class 버스_시퀀스 {

    private static Long sequence = 0L;

    public Long nextVal() {
        return sequence + 1L;
    }

}
