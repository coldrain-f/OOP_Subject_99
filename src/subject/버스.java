package subject;

import java.util.Scanner;

public class 버스 {

    private Long 버스_번호;
    private int 최대_승객수;
    private int 현재_승객수;
    private int 요금;
    private int 주유량;
    private int 현재_속도;
    private 버스_상태_타입 상태;

    private final static 버스_시퀀스 시퀀스 = new 버스_시퀀스();

    public 버스(int 최대_승객수, int 요금, int 주유량) {
        this.버스_번호 = 시퀀스.nextVal();
        this.상태 = 버스_상태_타입.운행;
        this.최대_승객수 = 최대_승객수;
        this.주유량 = 주유량;
        this.요금 = 요금;
        this.현재_속도 = 0;
    }

    public void 운행() {
        주유량 -= 10;
        if (주유량 < 10) {
            System.out.println("주유가 필요하다.");
            상태 = 버스_상태_타입.차고지; // 운행 불가능
        }
        if (주유량 <= 0 && 상태 == 버스_상태_타입.차고지) {
            System.out.println("운행을 종료합니다.");
            return;
        }
    }

    public void 버스_상태_변경() {
        if (상태.equals(버스_상태_타입.운행)) {
            상태 = 버스_상태_타입.차고지;
        } else if (상태.equals(버스_상태_타입.차고지)) {
            상태 = 버스_상태_타입.운행;
        }
    }

    public void 승객_탑승() {
        if (현재_승객수 > 최대_승객수 || 상태 != 버스_상태_타입.운행) {
            System.out.println("탑승이 불가능합니다.");
            return;
        }
        ++현재_승객수;
    }

    public void 속도_변경() {
        if (주유량 < 10) {
            System.out.println("주유량을 확인해 주세요.");
            상태 = 버스_상태_타입.차고지; // 운행 종료
            return;
        }
        final Scanner sc = new Scanner(System.in);
        final int speed = sc.nextInt();
        현재_속도 += speed;
    }
}
