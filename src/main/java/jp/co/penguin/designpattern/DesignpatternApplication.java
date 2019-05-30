package jp.co.penguin.designpattern;

import jp.co.penguin.designpattern.command.CommandRunner;
import jp.co.penguin.designpattern.interpreter.InterpreterRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DesignpatternApplication {

	public static void main(String[] args) {
	    String[] tmp = new String[] {"12123"};
		  new SpringApplicationBuilder(InterpreterRunner.class).web(WebApplicationType.NONE).run(tmp);
	}

}
