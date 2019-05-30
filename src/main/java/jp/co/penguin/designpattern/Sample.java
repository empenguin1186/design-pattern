package jp.co.penguin.designpattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sample implements Cloneable {

    private String string;
    private int number;
    private Child child = new Child();

    @Override
    protected Object clone() {
        Sample sample = new Sample();
        try {
            sample = (Sample) super.clone();
            sample.child = (Child) this.child.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sample;
    }
}
