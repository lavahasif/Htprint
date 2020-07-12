package com.example.htprint;


public class KotPrint extends PrintDesignWebHtml {
    public KotPrint(PrinterType printerType) {
        super(printerType);
    }

    public String KotPrint() {
        return printHtmlKot(printTable());
    }

    public String printTable() {
        return printHtmlCenter(printtable(HeadColumndataWebHead(new String[]{"Item", "Qty"}) + generateFromdataWeKot(Main.generateproduct())));
    }

    public String KotImage() {
        return "<center><img  width=\"100\" height=\"100\" src='file:///android_res/drawable/parcel.png'/><center>";
    }

    int HEAD_BILLNO_0 = 0;
    int HEAD_CASHBILL_1 = 1;
    int HEAD_DATE_2 = 2;
    int TIME_3 = 3;
    int WAITER_4 = 4;
    int TABLE_5 = 5;

    public String Headdescription(String[] data) {
        String Billno = "BillNO:226"; //10
        String cashbil = "CashBill"; //8
        String date = "Date:06/07/20"; //13
        String time = "12:17:45 PM"; //11
        String waiter = " W:MOHAMMED HASIF"; //16
        String table = "Table : A4";//10
        return KotImage() + printLeft(Billno) + printLeft(cashbil + spaceMakerWeb(48 - (cashbil.length() + date.length())) + date) + printLeft(time) + printLeft(waiter) + printLeft(table);
    }

    @Override
    public String printkotnoBottom(String data) {
        return super.printkotnoBottom(data);
    }

    public String printHtmlCenter(String data) {
        return "<center>" + data + "</center>";
    }

    public String printHtmlKot(String data) {
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
                "td,tr{\n" +
                "    font-size: small;\n" +
                "}" +

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
                Headdescription(new String[]{}) +
//                printLineHtml() +
//                CompanyHead_content(data_Comp) +
                "\n" + data +
                printWebBreak() +
                underScoreMakerHtmlcenter() +
//                printNetamount("100000.00") +
                printWebBreak() +
                printkotnoBottom("304") +
//                printLineHtml() +
                "</body>\n" +
                "</html>";
    }
}
