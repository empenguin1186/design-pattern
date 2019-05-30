package jp.co.penguin.designpattern.bridge;

public class IncreaseDisplay extends CountDisplay {

    private int step;

    // インスタンス生成時にstep数を定義
    public IncreaseDisplay(DisplayImpl impl, int step) {
        super(impl);
        this.step = step;
    }

    // 一回のループ毎にstepの数だけ表示する文字を増やす
    public void graduallyDisplay(int count) {

        int seed = 0;
        for (int i = 0; i < count; i++) {
            super.multiDisplay(seed);
            seed += this.step;
        }
    }

}
