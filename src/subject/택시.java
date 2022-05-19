package subject;

import java.util.Scanner;

public class 택시 {
    private Long 택시_번호;
    private int 주유량;
    private int 현재속도;
    private String 목적지;
    private int 기본거리;
    private int 목적지까지_거리;
    private int 기본요금;
    private int 거리당_요금;
    private 택시_상태 상태;

    private static 택시_시퀀스 시퀀스 = new 택시_시퀀스();

    public 택시() {};
    public 택시(int 주유량, int 현재속도, String 목적지, int 목적지까지_거리) {
        this.택시_번호 = 시퀀스.nextVal();
        this.주유량 = 주유량;
        this.현재속도 = 현재속도;
        this.목적지 = 목적지;
        this.기본거리 = 10;
        this.목적지까지_거리 = 목적지까지_거리;
        this.기본요금 = 3200;
        this.거리당_요금 = 150;
        this.상태 = 택시_상태.일반;
    }

    public void 운행시작() {
        if (주유량 < 10) {
            System.out.println("운행 불가능");
            상태 = 택시_상태.일반;
            return;
        }
        상태 = 택시_상태.운행;
        System.out.println("운행 시작");
    }

    public void 승객_탑승() {
        if (상태 != 택시_상태.일반) {
            System.out.println("승객 탑승 불가능");
            return;
        }
        System.out.println("승객 탑승");
        상태 = 택시_상태.운행;
    }

    public void 속도_변경() {
        final Scanner sc = new Scanner(System.in);
        System.out.println("현재속도 = " + 현재속도);
        int speed = sc.nextInt();
        this.현재속도 += speed;
        System.out.println("현재속도 = " + 현재속도);
    }

    public void 거리당_요금_추가() {
        if (목적지까지_거리 > 기본거리) {
            기본요금 += 거리당_요금;
            return;
        }
    }

    public void 요금_결제() {
        System.out.println(기본요금);
    }
}