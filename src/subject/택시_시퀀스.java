package subject;

public class 택시_시퀀스 {

    private static Long sequence = 0L;

    public Long nextVal() {
        return sequence + 1L;
    }

}
