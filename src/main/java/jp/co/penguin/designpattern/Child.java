package jp.co.penguin.designpattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class Child implements Cloneable {

    @JsonProperty("number")
    private int number;

    @Override
    protected Object clone() {
        Child child = new Child();
        try {
            child = (Child)super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return child;
    }
}
