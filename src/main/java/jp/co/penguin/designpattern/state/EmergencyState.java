package jp.co.penguin.designpattern.state;

public class EmergencyState implements State {

    private static EmergencyState state = new EmergencyState();

    private EmergencyState() {};

    public static EmergencyState getInstance() {
        return state;
    }

    @Override
    public void doClock(Context context, int hour) {

    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("不正使用(非常事態)!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(非常事態)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("非常時の通話(非常事態)");
    }
}
