package jp.co.penguin.designpattern.state;

public class DayState implements State {

    private static DayState state = new DayState();

    private DayState() {}

    public static DayState getInstance() {
        return state;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 < hour) {
            context.changeState(NightState.getInstance());
        } else if (hour >= 12 && 13 > hour) {
            context.changeState(LunchState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("金庫使用(昼間)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼間)");
        context.changeState(EmergencyState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(昼間)");
    }

    @Override
    public String toString() {
        return "[昼間]";
    }
}
