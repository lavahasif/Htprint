package com.example.htprint;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import sun.rmi.runtime.Log;

public class PrintDesignWebHtml extends PrintDesign {
    String[] data_cont;
    String[] data_Comp;

    public PrintDesignWebHtml(PrinterType printerType) {
        super(printerType);

        data_cont = new String[9];
        data_Comp = new String[6];

        data_cont[IMAGE1_0] = "file:///android_res/drawable/teatimec.png";
        data_cont[IMAGE2_1] = "file:///android_res/drawable/tea.png";
        data_cont[COMPANY_2] = "TEA TIME";
        data_cont[COMPANYPLACE_3] = "Pattambi Road";
        data_cont[COMPANYROAD_4] = "31/278,NEWAR KCMOVIES";
        data_cont[COMPANYPLACEPIN_5] = "PERINTHELMANNA,KERALA-679338";
        data_cont[COMPANY_TEL_6] = "Tel-9152111122";
        data_cont[COMPANY_GST_7] = "GSTIN32ADFDFDFDF";
        data_cont[COMPANY_HEAD_8] = "TAX INVOICE";
        String Billno = "BillNO:226"; //10
        String cashbil = "CashBill"; //8
        String date = "Date:06/07/20"; //13
        String time = "12:17:45 PM"; //11
        String waiter = " W:MOHAMMED HASIF"; //16
        String table = "Table : A4";//10
        int referencelength_space = 48 - Math.abs(Billno.length() + cashbil.length());

        int reference = referencelength_space + waiter.length();
        data_Comp[HEAD_BILLNO_0] = Billno + spaceMakerWeb(referencelength_space) + cashbil;
//        if (Billno.length() < date.length()) {
//            data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(35 - (date.length() + (date.length() - Billno.length()))) + time;
//        } else {
        data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(48 - (time.length() + date.length())) + time;
//        }
//        if (Billno.length() < waiter.length()) {
//            data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(35 - (waiter.length() + (waiter.length() - Billno.length()))) + table;
//        } else {
        data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(48 - (table.length() + waiter.length())) + table;
//        }
        System.out.println(data_Comp[HEAD_BILLNO_0].length());
        System.out.println(data_Comp[HEAD_CASHBILL_1].length());
        System.out.println(data_Comp[HEAD_DATE_2].length());
        String s = waiter + table;
        data_Comp[TIME_3] = "";
        data_Comp[WAITER_4] = "Bill";
        data_Comp[TABLE_5] = "Bill";

    }

    int HEAD_BILLNO_0 = 0;
    int HEAD_CASHBILL_1 = 1;
    int HEAD_DATE_2 = 2;
    int TIME_3 = 3;
    int WAITER_4 = 4;
    int TABLE_5 = 5;

    public String printWebBreak() {
        return "<br>";
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

    public String generateFromdataWeKot(List<Productmodel> items) {
        String sum = "";
        items.forEach(new Consumer<Productmodel>() {
            @Override
            public void accept(Productmodel pr) {
                headsum += HeadColumndataWeb(new String[]{pr.getName().substring(0, Math.min(pr.getName().length(), 20)), pr.getQty()}) + printNewline();
            }
        });

        return headsum;
    }


    public String printtd(String data) {
        return "<td>" + data + "</td>";
    }

    public String printHtml(String data) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style type=\"text/css\">\n" +
                "@page{\n" +
                "margin-left: 0px;\n" +
                "margin-right: 0px;\n" +
                "margin-top: 0px;\n" +
                "margin-bottom: 0px;\n" +
                "}\n" +
                "table th{ border-bottom: 1px solid #000;border-top:1px solid #000 }" +


                "table th{ border-bottom: 1px solid #000;border-top:1px solid #000 }" +
                "@font-face {\n" +
                "    font-family: MyFont;\n" +
                "    src: url(\"file:///android_asset/fonts/auto.ttf\")\n" +
                "}\n" +
                "body {\n" +
                "    font-family: MyFont;\n" +
                "    font-size: medium;\n" +
                "    text-align: justify;\n" +
                "}\n" +
                "\n" +
                "p{\n" +
                "font-family: MyFont;\n" +
                "\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                CompanyHead(data_cont) +
//                printLineHtml() +
                CompanyHead_content(data_Comp) +
                "\n" + data +
                underScoreMaker() +
                printWebBreak() +
                printkotnoBottom("304") +
//                printLineHtml() +
                "</body>\n" +
                "</html>";
    }


    public String printtdWRight(String data) {
        return "<td style=\"text-align:right;\">" + data + "</td>";
    }

    int IMAGE1_0 = 0;
    int IMAGE2_1 = 1;
    int COMPANY_2 = 2;
    int COMPANYPLACE_3 = 3;
    int COMPANYROAD_4 = 4;
    int COMPANYPLACEPIN_5 = 5;   //PERINTHELMANNA,KERALA-679338
    int COMPANY_TEL_6 = 6;  //Tel-9152111122
    int COMPANY_GST_7 = 7; //GSTIN32ADFDFDFDF
    int COMPANY_HEAD_8 = 8;  //TAX INVOICE
    int IMAGE1 = 9;

    public String CompanyHead(String[] data) {
        return "<center><img src=\'" + data[0] + "'\"/><center>\n" +
                "<center><img src=\'" + data[1] + "'\"/><center>\n" +
                "<center><h2 style=\"margin:0px;\">" + data[2] + "</h2></center>\n" +
                "<center ><p style=\"font-size: 15px;margin:0px;\">" + data[COMPANYPLACE_3] + "</p></center>\n" +
                "<center><p style=\"font-size: 15px;margin:0px;\">" + data[COMPANYROAD_4] + "</p></center>\n" +
                "<center><p style=\"font-size: 15px;margin:0px;\">" + data[COMPANYPLACEPIN_5] + "</h5></center>\n" +
                "<center><p style=\"font-size: 15px;margin:0px;\">" + data[COMPANY_TEL_6] + "</p></center>\n" +
                "<center><p style=\"font-size: 12px;margin:0p;\">" + data[COMPANY_GST_7] + "</p></center>\n" +
                "<center><h3 style=\"margin:0px\">" + data[COMPANY_HEAD_8] + "</h3></center>";
    }

    public String CompanyHead_content(String[] data) {
        return "<p style=\"text-align:left;font-size: 15px;\">" + data[HEAD_BILLNO_0] + "</p>\n" +
                "<p style=\"text-align:left;font-size: 15px;\">" + data[HEAD_CASHBILL_1] + "</p>\n" +
//                "<p style=\"text-align:left;font-size: 15px;\">" + data[TIME_3] + "</p>\n" +
                "<p style=\"text-align:left;font-size: 12px;\">" + data[HEAD_DATE_2] + "</p>";
    }

    public String printTh(String data) {
        return "<th>" + data + " </th>";
    }

    public String printThWright(String data) {
        return "<th style=\"text-align:right;\">" + data + " </th>";
    }

    public String printtr(String data) {
        return "<tr>" + data + "</tr>";
    }

    public String printLineHtml() {
        String value = "border-top: 4px dotted blue;";
        return "<h2 style=" + value + ">";
    }

    public String underScoreMakerHtmlcenter() {
        String underscore = "------------------------------------------------------------------------------------------------";
        return "<center>" + underscore.substring(1, 30) + "</center>";


    }

    public String printNetamount(String data) {
        String value = "border-top: 4px dotted blue;";
        String s = "NetAmount:";
        return "<p style=\"text-align:center;font-size: 20px;\">" + s + spaceMakerWeb(35 - (s.length() + data.length())) + data + "</p>";
    }

    public String printLeft(String data) {
        String value = "border-top: 4px dotted blue;";
        String s = "NetAmount:";
        return "<p style=\"text-align:left;font-size: 12px;\">" + data + "</p>";
    }

    public String printkotnoBottom(String data) {
        String value = "border-top: 4px dotted blue;";
        String s = "Kot NO :";
        return "<p style=\"text-align:left;font-size: 10px;\">" + s + data + "</p>";
    }

    public String printtable(String data) {
        return "<table>" + data + "</table>";
    }

    public String HeadColumndataWeb(String[] heads) {
        for (int i = 0; i < heads.length; i++) {

        }
        if (PrinterHead._4Head.name == heads.length) {
            return printtr(printtd(heads[0]) + printtdWRight(heads[1]) + printtdWRight(heads[2]) + printtdWRight(heads[3]));
        } else if (PrinterHead._3Head.name == heads.length) {
        } else if (PrinterHead._2Head.name == heads.length) {
            return printtr(printtd(heads[0]) + printtdWRight(heads[1]));
        } else {
        }

        return "";
    }

    public String HeadColumndataWebHead(String[] heads) {
        for (int i = 0; i < heads.length; i++) {

        }
        if (PrinterHead._4Head.name == heads.length) {
            return printtr(printTh(heads[0]) + printThWright(heads[1]) + printThWright(heads[2]) + printThWright(heads[3]));
        } else if (PrinterHead._3Head.name == heads.length) {
        } else if (PrinterHead._2Head.name == heads.length) {
            return printtr(printTh(heads[0]) + printThWright(heads[1]));
        } else {
        }

        return "";
    }

    public String spaceMakerWeb(int spacelength) {
        String wspace = "&#160;";
        String sumwspace = "";
        for (int i = 0; i < spacelength; i++)
            sumwspace = sumwspace + wspace;
        return sumwspace;
    }

    public String printThankyouVisitAgain(String qoute) {
        return "<p style=\"text-align:center;font-size: 10px;\">" + qoute + "</p>";
    }


}