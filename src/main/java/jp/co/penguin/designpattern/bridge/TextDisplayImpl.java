package jp.co.penguin.designpattern.bridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextDisplayImpl implements DisplayImpl {

    private String filePath;

    public TextDisplayImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void rawOpen() {

    }

    @Override
    public void rawPrint() {
        try {
            //ファイルを読み込む
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ画面出力する
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(++count + "行目：" + line);
            }

            //終了処理
            br.close();
            fr.close();

        } catch (IOException e) {
            //例外発生時処理
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {

    }
}
