package com.example.htprint;

import java.util.List;
import java.util.function.Consumer;

public class PrintDesignWeb extends PrintDesign {
    public PrintDesignWeb(PrinterType printerType) {
        super(printerType);
    }


    String headsum = "";
    String bold = "";
    String bold1 = "\033[0;1m";

    public String generateFromdataWeb(List<Productmodel> items) {
        String sum = "";
        items.forEach(new Consumer<Productmodel>() {
            @Override
            public void accept(Productmodel pr) {
                headsum += HeadColumndataWeb(new String[]{pr.getName().substring(0, Math.min(pr.getName().length(), 20)), pr.getQty(), pr.getRate(), pr.getRate()}) + printNewline();
            }
        });

        return headsum;
    }
    public String HeadColumndataWeb(String[] heads) {
        for (int i = 0; i < heads.length; i++) {

        }
        if (PrinterHead._4Head.name == heads.length) {
            return heads[0] + spaceMakerWeb(29 - (heads[0].length() + heads[1].length())) + heads[1] + spaceMakerWeb(8 - heads[2].length()) + heads[2] + spaceMakerWeb(10 - heads[3].length()) + heads[3] + printNewline();
        } else if (PrinterHead._3Head.name == heads.length) {
        } else if (PrinterHead._2Head.name == heads.length) {
        } else {
        }

        return "";
    }
    public String spaceMakerWeb(int spacelength) {
//        String wspace = "&#160;";
        String wspace = "&nbsp;";
        String sumwspace = "";
        for (int i = 0; i < spacelength; i++)
            sumwspace = sumwspace + wspace;
        return sumwspace;
    }


}