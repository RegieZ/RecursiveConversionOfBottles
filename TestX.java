/**
 * 兑换酒瓶问题，N1瓶啤酒瓶子可以兑换1瓶，N2个瓶盖可以兑换1瓶，N个酒瓶，不能赊账可以喝多少瓶？
 *
 * @Author:Regino
 */

import org.junit.Test;

public class TestX {
    private static final int BOTTLE_TO_BEER = 2; // N1个瓶子兑换1瓶啤酒
    private static final int CAP_TO_BEER = 4; // N2个瓶盖兑换1瓶啤酒
    private static final int INIT_BOTTLE = 5; // N个酒瓶

    private static int total = INIT_BOTTLE;
    private static int capLeft = 0;

    public void exchange(int n) {
        if (n < BOTTLE_TO_BEER) {
            return;
        }

        int newBottle = n / BOTTLE_TO_BEER + n / CAP_TO_BEER;
        total += newBottle;
        int bottleLeft = n % BOTTLE_TO_BEER;
        capLeft += n % CAP_TO_BEER;

        exchange(newBottle + bottleLeft + exchangeCap(capLeft));
    }

    public int exchangeCap(int n) {
        if (n < CAP_TO_BEER) {
            return 0;
        }

        capLeft = n % CAP_TO_BEER;
        return n / CAP_TO_BEER;
    }

    @Test
    public void test() {
        exchange(INIT_BOTTLE);
        System.out.println(String.format("%d瓶啤酒瓶子可以兑换1瓶，%d个瓶盖可以兑换1瓶，%d个酒瓶，可以喝%d瓶。",
                BOTTLE_TO_BEER, CAP_TO_BEER, INIT_BOTTLE, total));
        //2瓶啤酒瓶子可以兑换1瓶，4个瓶盖可以兑换1瓶，5个酒瓶，可以喝15瓶。
    }
}
