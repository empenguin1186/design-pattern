package jp.co.penguin.designpattern.interpreter;

import java.util.StringTokenizer;

public class Context {

    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String token) {
        this.tokenizer = new StringTokenizer(token);
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
            return currentToken;
        }
        return null;
    }

    public String currentToken(){
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but "
            + currentToken + " is found.");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }
}
