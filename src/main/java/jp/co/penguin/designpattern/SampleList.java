package jp.co.penguin.designpattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SampleList {

//    @JsonProperty("number")
    private List<String> bob;

//    public SampleList(@JsonProperty("number") List<String> number) {
//        this.bob = number;
//    }


    public SampleList() {}
}
