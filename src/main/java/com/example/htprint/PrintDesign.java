package com.example.htprint;


import java.util.List;
import java.util.function.Consumer;

public class PrintDesign {

    //    Bill No :20
//    Date:27/06/2020      Time : 4:08:23 PM
//    Waiter :SanJu        Table No:T3
//                KOT
//     ----------------------------------------
//         ItemName                  QTY
//     ----------------------------------------
//         Bread                           1
//         New Item                        1
//         TEA                             1
//     ----------------------------------------
//           Total                         3
//     ----------------------------------------
    public PrinterType getPrintertype() {
        return printertype;
    }

    private final PrinterType printertype;

    public PrintDesign(PrinterType printerType) {
        this.printertype = printerType;
    }

    public String printNewline() {
        return "\n";
    }

    //    Date:27/06/2020      Time : 4:08:23 PM
    //date time this form
    public String printLeftWSRight(String leftValue, String rightvalue) {
        return (printertype == PrinterType._48Char) ?
                leftValue + spaceMaker(48 - (leftValue.length() + rightvalue.length())) + rightvalue :
                leftValue + spaceMaker(32 - (leftValue.length() + rightvalue.length())) + rightvalue;
    }

    //               Bill No :20
    public String Ceneter(String center) {
        return (printertype == PrinterType._48Char) ?
                bold + spaceMaker(48 / 2 - (center.length()) / 2) + center :
                spaceMaker(32 / 2 - (center.length()) / 2) + center;
    }

    public String CeneterWBold(String center) {
        return (printertype == PrinterType._48Char) ?
                spaceMaker(28 / 2 - (center.length() / 2)) + center :
                spaceMaker(20 / 2 - (center.length()) / 2) + center;
    }

    //                         Time : 4:08:23 PM
    public String printWSRight(String rightvalue) {
        return (printertype == PrinterType._48Char) ?
                spaceMaker(48 - (rightvalue.length())) + rightvalue :
                spaceMaker(32 - (rightvalue.length())) + rightvalue;
    }

    //    Date:27/06/2020
    public String printWSleft(String leftValue) {
        return (printertype == PrinterType._48Char) ?
                leftValue :
                leftValue;
    }

    public String spaceMaker(int spacelength) {
        String wspace = " ";
        String sumwspace = "";
        for (int i = 0; i < spacelength; i++)
            sumwspace = sumwspace + wspace;
        return sumwspace;
    }

    //head0---4 items
//head1---3 qty
//head2---4 rate
//head3---6 amount
    public String HeadColumn(String[] heads) {
        for (int i = 0; i < heads.length; i++) {

        }
        if (PrinterHead._4Head.name == heads.length) {
            return heads[0] + spaceMaker(17) + heads[1] + spaceMaker(5) + heads[2] + spaceMaker(8) + heads[3];
        } else if (PrinterHead._3Head.name == heads.length) {
        } else if (PrinterHead._2Head.name == heads.length) {
        } else {
        }

        return "";
    }

    public String HeadColumndata(String[] heads) {
        for (int i = 0; i < heads.length; i++) {

        }
        if (PrinterHead._4Head.name == heads.length) {
            return heads[0] + spaceMaker(29 - (heads[0].length() + heads[1].length())) + heads[1] + spaceMaker(8 - heads[2].length()) + heads[2] + spaceMaker(10 - heads[3].length()) + heads[3] + printNewline();
        } else if (PrinterHead._3Head.name == heads.length) {
        } else if (PrinterHead._2Head.name == heads.length) {
        } else {
        }

        return "";
    }

    //---------------------------------------------
    public String underScoreMaker() {
        String underscore = "------------------------------------------------------------------------------------------------";
        return (printertype == PrinterType._48Char) ? underscore.substring(1, 38)
                :
                underscore.substring(1, 32);

    }


    public String space() {
        return "\t";
    }

    String headsum = "";
    String bold = "";
    String bold1 = "\033[0;1m";

    public String generateFromdata(List<Productmodel> items) {
        String sum = "";
        items.forEach(new Consumer<Productmodel>() {
            @Override
            public void accept(Productmodel pr) {
                headsum += HeadColumndata(new String[]{pr.getName().substring(0, Math.min(pr.getName().length(), 20)), pr.getQty(), pr.getRate(), pr.getRate()}) + printNewline();
            }
        });

        return headsum;
    }


}

enum PrinterType {
    _48Char,
    _32_Char
}

enum PrinterHead {
    _4Head(4),
    _3Head(3),
    _2Head(2),
    _1head(1);
    int name;

    public int getName() {
        return name;
    }

    PrinterHead(int name) {
        this.name = name;
    }
}