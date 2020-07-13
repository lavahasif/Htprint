//package com.example.htprint;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class BillPrint extends KotPrint {
//    private String headsum1 = "";
//
//    public BillPrint(PrinterType printerType, List<Productmodel> productmodelList, HashMap<Integer, String> map, HashMap<Integer, String> mapCompany) {
//        super(printerType, productmodelList, map);
//        mData = new String[8];
//        mCompany = new String[9];
//        this.productmodelList = productmodelList;
//        mData[Constants.HEAD_BILLNO_0] = map.get(HEAD_BILLNO_0);
//        mData[Constants.HEAD_DATE_2] = map.get(Constants.HEAD_DATE_2);
//        mData[TIME_3] = map.get(Constants.TIME_3);
//        mData[Constants.WAITER_4] = map.get(Constants.WAITER_4);
//        mData[Constants.TABLE_5] = map.get(Constants.TABLE_5);
//        mData[Constants.IMAGE_6] = map.get(Constants.IMAGE_6);
//        mData[Constants.KOTNO_7] = map.get(Constants.KOTNO_7);
//
//
//        //company
//        mCompany[Constants._b_IMAGE1_0] = mapCompany.get(Constants._b_IMAGE1_0);
//        mCompany[Constants._b_IMAGE2_1] = mapCompany.get(Constants._b_IMAGE2_1);
//        mCompany[Constants._b_COMPANY_2] = mapCompany.get(Constants._b_COMPANY_2);
//        mCompany[Constants._b_COMPANYPLACE_3] = mapCompany.get(Constants._b_COMPANYPLACE_3);
//        mCompany[Constants._b_COMPANYROAD_4] = mapCompany.get(Constants._b_COMPANYROAD_4);
//        mCompany[Constants._b_COMPANYPLACEPIN_5] = mapCompany.get(Constants._b_COMPANYPLACEPIN_5);
//        mCompany[Constants._b_COMPANY_TEL_6] = mapCompany.get(Constants._b_COMPANY_TEL_6);
//        mCompany[Constants._b_COMPANY_GST_7] = mapCompany.get(Constants._b_COMPANY_GST_7);
//        mCompany[Constants._b_COMPANY_HEAD_8] = mapCompany.get(Constants._b_COMPANY_HEAD_8);
//
//
//    }
//
//    String[] mData;
//    String[] mCompany;
//    List<Productmodel> productmodelList;
//
//    public String BillPrint() {
//        return printHtmlBill(printTable());
//    }
//
//    public String printTable() {
//        return printHtmlCenter(printtable(HeadColumndataWebHead(new String[]{"ITEMS", "QTY", "RATE", "AMOUNT"}) + generateFromdataWeb(productmodelList)));
//    }
//
//    public static String BillImage(String image) {
//        if (image.isEmpty())
//            return "";
//        else
//            return "<center><img  width=\"100\" height=\"100\" src='file:///android_res/drawable/parcel.png'/><center>";
//    }
//
//    public String MakeHeadAlign(String[] data) {
//        return printHtmlCenter(printtable2(generateFromdataWeb1(data)));
//    }
//
//
//    public String generateFromdataWeb1(final String[] data) {
//        String sum = "";
//
//        return HeadColumndataWebHeaddesc(new String[]{data[0], data[1]}) + printNewline() + HeadColumndataWebHeaddesc(new String[]{data[2], data[3]}) + printNewline() +
//                printNewline() + HeadColumndataWebHeaddesc(new String[]{data[4], data[5]}) + printNewline();
//
//
//    }
//
//    public String Headdescription(String[] data) {
//        String Billno = "BillNO:" + data[Constants.HEAD_BILLNO_0]; //10
//        String cashbil = "CashBill"; //8
//        String date = "Date:" + data[Constants.HEAD_DATE_2]; //13
//        String time = "" + data[Constants.TIME_3]; //11
//        String waiter = "W:" + data[Constants.WAITER_4]; //16
//        String table = "Table :" + data[Constants.TABLE_5];//10
//        int referencelength_space = 48 - Math.abs(Billno.length() + cashbil.length());
//
//        data_Comp[HEAD_BILLNO_0] = Billno + spaceMakerWeb(referencelength_space) + cashbil;
////        if (Billno.length() < date.length()) {
////            data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(35 - (date.length() + (date.length() - Billno.length()))) + time;
////        } else {
//        data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(Math.abs(48 - (time.length() + date.length()))) + time;
////        }
////        if (Billno.length() < waiter.length()) {
////            data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(35 - (waiter.length() + (waiter.length() - Billno.length()))) + table;
////        } else {
//        data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(48 - (table.length() + waiter.length())) + table;
//        return CompanyHead_content(new String[]{data_Comp[HEAD_BILLNO_0], data_Comp[HEAD_CASHBILL_1], data_Comp[HEAD_DATE_2]});
//    }
//
//    @Override
//    public String printkotnoBottom(String data) {
//        return super.printkotnoBottom(data);
//    }
//
//    public String printHtmlCenter(String data) {
//        return "<center>" + data + "</center>";
//    }
//
//    public String printHtmlBill(String data) {
//        return "<!DOCTYPE html>\n" +
//                "<html>\n" +
//                "<head>\n" +
//                "<style type=\"text/css\">\n" +
//                "@page{\n" +
//                "margin-left: 0px;\n" +
//                "margin-right: 0px;\n" +
//                "margin-top: 0px;\n" +
//                "margin-bottom: 0px;\n" +
//                "}\n" +
//                "table th{ border-bottom: 1px solid #000;border-top:1px solid #000 }" +
//
//
//                "table th{ border-bottom: 1px solid #000;border-top:1px solid #000 }" +
//                "@font-face {\n" +
//                "    font-family: MyFont;\n" +
//                "    src: url(\"file:///android_asset/fonts/auto.ttf\")\n" +
//                "}\n" +
//                "body {\n" +
//                "    font-family: MyFont;\n" +
//                "    font-size: medium;\n" +
//                "    text-align: justify;\n" +
//                "}\n" +
//                "\n" +
//                "p{\n" +
//                "font-family: MyFont;\n" +
//                "\n" +
//                "}\n" +
//                "</style>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                CompanyHead(mCompany) +
//                printLineHtml() +
////                Headdescription(mData)+
//                MakeHeadAlign(mData) +
//                "\n" + data +
//                underScoreMaker() +
////                printWebBreak() +
//                printNetamount("1000") +
//                printkotnoBottom("304") +
////                printLineHtml() +
//                "</body>\n" +
//                "</html>";
//    }
//}

package com.example.htprint;




import java.util.HashMap;
import java.util.List;

public class BillPrint extends KotPrint {
    public BillPrint(PrinterType printerType, List<Productmodel> productmodelList, HashMap<Integer, String> map, HashMap<Integer, String> mapCompany) {
        super(printerType, productmodelList, map);
        mData = new String[8];
        mCompany = new String[9];
        this.productmodelList = productmodelList;
        mData[Constants.HEAD_BILLNO_0] = map.get(HEAD_BILLNO_0);
        mData[Constants.HEAD_CASHBILL_1] = map.get(Constants.HEAD_CASHBILL_1);
        mData[Constants.HEAD_DATE_2] = map.get(Constants.HEAD_DATE_2);
        mData[TIME_3] = map.get(Constants.TIME_3);
        mData[Constants.WAITER_4] = map.get(Constants.WAITER_4);
        mData[Constants.TABLE_5] = map.get(Constants.TABLE_5);
        mData[Constants.IMAGE_6] = map.get(Constants.IMAGE_6);
        mData[Constants.KOTNO_7] = map.get(Constants.KOTNO_7);
        mData[Constants.NETAMOUNT_8] = map.get(Constants.NETAMOUNT_8);


        //company
        mCompany[Constants._b_IMAGE1_0] = mapCompany.get(Constants._b_IMAGE1_0);
        mCompany[Constants._b_IMAGE2_1] = mapCompany.get(Constants._b_IMAGE2_1);
        mCompany[Constants._b_COMPANY_2] = mapCompany.get(Constants._b_COMPANY_2);
        mCompany[Constants._b_COMPANYPLACE_3] = mapCompany.get(Constants._b_COMPANYPLACE_3);
        mCompany[Constants._b_COMPANYROAD_4] = mapCompany.get(Constants._b_COMPANYROAD_4);
        mCompany[Constants._b_COMPANYPLACEPIN_5] = mapCompany.get(Constants._b_COMPANYPLACEPIN_5);
        mCompany[Constants._b_COMPANY_TEL_6] = mapCompany.get(Constants._b_COMPANY_TEL_6);
        mCompany[Constants._b_COMPANY_GST_7] = mapCompany.get(Constants._b_COMPANY_GST_7);
        mCompany[Constants._b_COMPANY_HEAD_8] = mapCompany.get(Constants._b_COMPANY_HEAD_8);


    }

    String[] mData;
    String[] mCompany;
    List<Productmodel> productmodelList;

    public String BillPrint() {
        return printHtmlBill(printTable());
    }

    public String printTable() {
        return printHtmlCenter(printtable(HeadColumndataWebHead(new String[]{"ITEMS", "QTY", "RATE", "AMOUNT"}) + generateFromdataWeb(productmodelList)));
    }

    public static String BillImage(String image) {
        if (image.isEmpty())
            return "";
        else
            return "<center><img  width=\"100\" height=\"100\" src='" + image + "' /></center>";
    }


    public String Headdescription(String[] data) {
        String Billno = "BillNO:" + data[Constants.HEAD_BILLNO_0]; //10
        String cashbil = "CashBill"; //8
        String date = "Date:" + data[Constants.HEAD_DATE_2]; //13
        String time = "" + data[Constants.TIME_3]; //11
        String waiter = "W:" + data[Constants.WAITER_4]; //16
        String table = "Table :" + data[Constants.TABLE_5];//10
        int referencelength_space = 48 - Math.abs(Billno.length() + cashbil.length());

        data_Comp[HEAD_BILLNO_0] = Billno + spaceMakerWeb(referencelength_space) + cashbil;
//        if (Billno.length() < date.length()) {
//            data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(35 - (date.length() + (date.length() - Billno.length()))) + time;
//        } else {
        data_Comp[HEAD_CASHBILL_1] = date + spaceMakerWeb(Math.abs(48 - (time.length() + date.length()))) + time;
//        }
//        if (Billno.length() < waiter.length()) {
//            data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(35 - (waiter.length() + (waiter.length() - Billno.length()))) + table;
//        } else {
        data_Comp[HEAD_DATE_2] = waiter + spaceMakerWeb(48 - (table.length() + waiter.length())) + table;
        return CompanyHead_content(new String[]{data_Comp[HEAD_BILLNO_0], data_Comp[HEAD_CASHBILL_1], data_Comp[HEAD_DATE_2]});
    }

    @Override
    public String printkotnoBottom(String data) {
        return super.printkotnoBottom(data);
    }

    public String printHtmlCenter(String data) {
        return "<center>" + data + "</center>";
    }

    public String printHtmlBill(String data) {
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
                ".column {\n" +
                "  float: left;\n" +
                "  width: 50%;\n" +
                "}\n" +
                "\n" +
                "/* Clear floats after the columns */\n" +
                ".row:after {\n" +
                "  content: \"\";\n" +
                "height:auto"
                +                "  display: table;\n" +
                "  clear: both;\n" +
                "}" +
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
                CompanyHead(mCompany) +
//                printLineHtml() +
//                Headdescription(mData) +
                generateHead(mData) +
                "\n" + data +
                underScoreMaker() +
//                printWebBreak() +
                printNetamount(mData[Constants.NETAMOUNT_8]) +
                printkotnoBottom("304") +
//                printLineHtml() +
                "</body>\n" +
                "</html>";
    }

    public String generateHead(String[] data) {
        String Billno = "BillNO:" + data[Constants.HEAD_BILLNO_0]; //10
        String cashbil = "CashBill"; //8
        String date = "Date:" + data[Constants.HEAD_DATE_2]; //13
        String time = "" + data[Constants.TIME_3]; //11
        String waiter = "W:" + data[Constants.WAITER_4]; //16
        String table = "Table :" + data[Constants.TABLE_5];//10


        return makeHeadGrid(Billno , data[1]) + makeHeadGrid(date , time ) + makeHeadGrid(waiter , table );
    }

    public String makeHeadGrid(String data, String data2) {
        return "<div class=\"row\" style=\"margin:1px;padding:1px;\">\n" +
                "  <div class=\"column\"><h5 style=\"text-align:left;margin:0px;padding:0px;\">" + data + "<h5></div>\n" +
                "  <div class=\"column\" ><h5 style=\"text-align:left;margin:0px;padding:0px;\">" + data2 + "<h5></div>\n" +
                "</div>";


    }
//    public String makeHeadGrid(String data, String data2) {
//        return "<div style='  content: \"\";\n" +
//                "  display: table;\n" +
//                "  clear: both;'>\n" +
//                "  <div style=' float: left;\n" +
//                "  width: 50%;\n" +
//                "  padding: 10px;'>\n" +
//                "    <h5>" + data + "</h5>\n" +
//
//                "  </div>\n" +
//                "  <div style=' float: left;\n" +
//                "  width: 50%;\n" +
//                "  padding: 10px;'>\n" +
//                "    <h5>" + data2 + "</h5>\n" +
//
//                "  </div>\n" +
//                "</div>\n";
//
//
//    }


}
