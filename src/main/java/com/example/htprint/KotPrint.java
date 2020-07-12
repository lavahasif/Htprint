package com.example.htprint;


import java.util.HashMap;
import java.util.List;

public class KotPrint extends PrintDesignWebHtml {
    public KotPrint(PrinterType printerType, List<Productmodel> productmodelList, HashMap<Integer, String> map) {
        super(printerType);
        mData = new String[8];
        this.productmodelList = productmodelList;
        mData[Constants.HEAD_BILLNO_0] = map.get(HEAD_BILLNO_0);
        mData[Constants.HEAD_DATE_2] = map.get(Constants.HEAD_DATE_2);
        mData[TIME_3] = map.get(Constants.TIME_3);
        mData[Constants.WAITER_4] = map.get(Constants.WAITER_4);
        mData[Constants.TABLE_5] = map.get(Constants.TABLE_5);
        mData[Constants.IMAGE_6] = map.get(Constants.IMAGE_6);
        mData[Constants.KOTNO_7] = map.get(Constants.KOTNO_7);

    }

    String[] mData;
    List<Productmodel> productmodelList;

    public String KotPrint() {
        return printHtmlKot(printTable());
    }

    public String printTable() {
        return printHtmlCenter(printtable(HeadColumndataWebHead(new String[]{"Item", "Qty"}) + generateFromdataWeKot(productmodelList)));
    }

    public String KotImage(String image) {
        if (image.isEmpty())
            return "";
        else
            return "<center><img  width=\"100\" height=\"100\" src='file:///android_res/drawable/parcel.png'/><center>";
    }


    public String Headdescription(String[] data) {
        String Billno = "BillNO:" + data[Constants.HEAD_BILLNO_0]; //10
        String cashbil = "CashBill"; //8
        String date = "Date:" + data[Constants.HEAD_DATE_2]; //13
        String time = "" + data[Constants.TIME_3]; //11
        String waiter = "W:" + data[Constants.WAITER_4]; //16
        String table = "Table :" + data[Constants.TABLE_5];//10
        return KotImage(data[Constants.IMAGE_6]) + printLeft(Billno + spaceMakerWeb(48 - (cashbil.length() + Billno.length())) + cashbil) + printLeft(date + spaceMakerWeb(48 - (date.length() + time.length())) + time) + printLeft(waiter) + printLeft(table);
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
                "table th{ border-bottom: 1px solid #000;border-top:1px solid #000;width:100% }" +
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
                Headdescription(mData) +
//                printLineHtml() +
//                CompanyHead_content(data_Comp) +
                "\n" + data +
                printWebBreak() +
                underScoreMakerHtmlcenter() +
//                printNetamount("100000.00") +
                printWebBreak() +
                printkotnoBottom(mData[Constants.KOTNO_7]) +
//                printLineHtml() +
                "</body>\n" +
                "</html>";
    }
}
