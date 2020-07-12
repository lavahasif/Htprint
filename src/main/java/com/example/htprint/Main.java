package com.example.htprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static StringBuilder builder;

    public static void main(String[] args) {
        SampleBills();
    }

    public static String SampleKots() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(Constants.HEAD_BILLNO_0, "100");
        map.put(Constants.HEAD_DATE_2, "12/jul/20");
        map.put(Constants.TIME_3, "10:20:25:PM");
        map.put(Constants.WAITER_4, "AKBER");
        map.put(Constants.TABLE_5, "A4");
        map.put(Constants.IMAGE_6, "");
        map.put(Constants.KOTNO_7, "150");
        return sampleKot(map, generateproduct());
    }

    public static String SampleBills() {
        String[] data_cont = new String[9];
        data_cont[Constants._b_IMAGE1_0] = "file:///android_res/drawable/teatimec.png";
        data_cont[Constants._b_IMAGE2_1] = "file:///android_res/drawable/tea.png";
        data_cont[Constants._b_COMPANY_2] = "TEA TIME";
        data_cont[Constants._b_COMPANYPLACE_3] = "Pattambi Road";
        data_cont[Constants._b_COMPANYROAD_4] = "31/278,NEWAR KCMOVIES";
        data_cont[Constants._b_COMPANYPLACEPIN_5] = "PERINTHELMANNA,KERALA-679338";
        data_cont[Constants._b_COMPANY_TEL_6] = "Tel-9152111122";
        data_cont[Constants._b_COMPANY_GST_7] = "GSTIN32ADFDFDFDF";
        data_cont[Constants._b_COMPANY_HEAD_8] = "TAX INVOICE";


        HashMap<Integer, String> map = new HashMap<>();
        map.put(Constants.HEAD_BILLNO_0, "100");
        map.put(Constants.HEAD_DATE_2, "12/jul/20");
        map.put(Constants.TIME_3, "10:20:25:PM");
        map.put(Constants.WAITER_4, "AKBER");
        map.put(Constants.TABLE_5, "A4");
        map.put(Constants.IMAGE_6, "");
        map.put(Constants.KOTNO_7, "150");
        map.put(Constants.NETAMOUNT_8, "150");

        HashMap<Integer, String> mapCompany = new HashMap<>();
        mapCompany.put(Constants._b_IMAGE1_0, data_cont[Constants._b_IMAGE1_0]);
        mapCompany.put(Constants._b_IMAGE2_1, data_cont[Constants._b_IMAGE2_1]);
        mapCompany.put(Constants._b_COMPANY_2, data_cont[Constants._b_COMPANY_2]);
        mapCompany.put(Constants._b_COMPANYPLACE_3, data_cont[Constants._b_COMPANYPLACE_3]);
        mapCompany.put(Constants._b_COMPANYROAD_4, data_cont[Constants._b_COMPANYROAD_4]);
        mapCompany.put(Constants._b_COMPANYPLACEPIN_5, data_cont[Constants._b_COMPANYPLACEPIN_5]);
        mapCompany.put(Constants._b_COMPANY_TEL_6, data_cont[Constants._b_COMPANY_TEL_6]);
        mapCompany.put(Constants._b_COMPANY_GST_7, data_cont[Constants._b_COMPANY_GST_7]);
        mapCompany.put(Constants._b_COMPANY_HEAD_8, data_cont[Constants._b_COMPANY_HEAD_8]);

        return sampleBill(map, mapCompany, generateproduct());
    }

    public static String sampleReceipt() {
        builder = new StringBuilder();
        PrintDesign printDesign = new PrintDesign(PrinterType._48Char);
//        builder.append(printDesign.Ceneter("DEARSON POWER TOOLS LLP"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("31/278,NEWAR KCMOVIES"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("PERINTHELMANNA , KERALA 679338"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("Tel-9152111122"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("GSTIN32SKJFKSJFKSDFJ"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("TAX INVOICE"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.printLeftWSRight("INVOICE:PMNA-IN308", "DATE:10-07-2020"));
//        builder.append(printDesign.printNewline());
        builder.append(printDesign.underScoreMaker());
        builder.append(printDesign.printNewline());
        builder.append(printDesign.HeadColumndata(new String[]{"ITEMS", "QTY", "RATE", "AMOUNT"}));
        builder.append(printDesign.printNewline());
        builder.append(printDesign.underScoreMaker());
        builder.append(printDesign.printNewline());
        builder.append(printDesign.generateFromdata(generateproduct()));
        builder.append(printDesign.underScoreMaker());
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static String sampleReceiptWeb() {
        builder = new StringBuilder();
        PrintDesignWeb printDesign = new PrintDesignWeb(PrinterType._48Char);
//        builder.append(printDesign.Ceneter("DEARSON POWER TOOLS LLP"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("31/278,NEWAR KCMOVIES"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("PERINTHELMANNA , KERALA 679338"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("Tel-9152111122"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("GSTIN32SKJFKSJFKSDFJ"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("TAX INVOICE"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.printLeftWSRight("INVOICE:PMNA-IN308", "DATE:10-07-2020"));
//        builder.append(printDesign.printNewline());
        builder.append(printDesign.underScoreMaker());
        builder.append(printDesign.printNewline());
        builder.append(printDesign.HeadColumndataWeb(new String[]{"ITEMS", "QTY", "RATE", "AMOUNT"}));
        builder.append(printDesign.printNewline());
        builder.append(printDesign.underScoreMaker());
        builder.append(printDesign.printNewline());
        builder.append(printDesign.generateFromdataWeb(generateproduct()));
        builder.append(printDesign.underScoreMaker());
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static String sampleReceiptWebHtml() {
        builder = new StringBuilder();
        PrintDesignWebHtml printDesign = new PrintDesignWebHtml(PrinterType._48Char);
//        builder.append(printDesign.Ceneter("DEARSON POWER TOOLS LLP"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("31/278,NEWAR KCMOVIES"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("PERINTHELMANNA , KERALA 679338"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("Tel-9152111122"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("GSTIN32SKJFKSJFKSDFJ"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.Ceneter("TAX INVOICE"));
//        builder.append(printDesign.printNewline());
//        builder.append(printDesign.printLeftWSRight("INVOICE:PMNA-IN308", "DATE:10-07-2020"));
//        builder.append(printDesign.printNewline());

        builder.append(printDesign.printHtml(printDesign.printtable(printDesign.HeadColumndataWebHead(new String[]{"ITEMS", "QTY", "RATE", "AMOUNT"}) + printDesign.generateFromdataWeb(generateproduct()))));


        System.out.println(builder.toString());
        return builder.toString();
    }

    public static String sampleKot(HashMap<Integer, String> map1, List<Productmodel> list) {
        builder = new StringBuilder();
        PrintDesignWebHtml printDesign = new PrintDesignWebHtml(PrinterType._48Char);


        HashMap<Integer, String> map = new HashMap<>();
        map.put(Constants.HEAD_BILLNO_0, map1.get(Constants.HEAD_BILLNO_0));
        map.put(Constants.HEAD_DATE_2, map1.get(Constants.HEAD_DATE_2));
        map.put(Constants.TIME_3, map1.get(Constants.TIME_3));
        map.put(Constants.WAITER_4, map1.get(Constants.WAITER_4));
        map.put(Constants.TABLE_5, map1.get(Constants.TABLE_5));
        map.put(Constants.IMAGE_6, map1.get(Constants.IMAGE_6));
        map.put(Constants.KOTNO_7, map1.get(Constants.KOTNO_7));
        builder.append(new KotPrint(PrinterType._48Char, list, map).KotPrint());


        System.out.println(builder.toString());
        return builder.toString();
    }

    public static String sampleBill(HashMap<Integer, String> map1, HashMap<Integer, String> mapCompany, List<Productmodel> list) {
        builder = new StringBuilder();
        PrintDesignWebHtml printDesign = new PrintDesignWebHtml(PrinterType._48Char);

//
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(Constants.HEAD_BILLNO_0, map1.get(Constants.HEAD_BILLNO_0));
//        map.put(Constants.HEAD_DATE_2, map1.get(Constants.HEAD_DATE_2));
//        map.put(Constants.TIME_3, map1.get(Constants.TIME_3));
//        map.put(Constants.WAITER_4, map1.get(Constants.WAITER_4));
//        map.put(Constants.TABLE_5, map1.get(Constants.TABLE_5));
//        map.put(Constants.IMAGE_6, map1.get(Constants.IMAGE_6));
//        map.put(Constants.KOTNO_7, map1.get(Constants.KOTNO_7));
        builder.append(new BillPrint(PrinterType._48Char, list, map1, mapCompany).BillPrint());


        System.out.println(builder.toString());
        return builder.toString();
    }

    public static StringBuilder getBuilder() {
        return builder;
    }

    public static List<Productmodel> generateproduct() {
        List<Productmodel> productmodelList = new ArrayList<Productmodel>();
        productmodelList.add(new Productmodel("BROASTFULL", "1.00", "400.0", "400.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "1000.00", "40000.0", "40.0"));
        productmodelList.add(new Productmodel("k", "1.00", "4.0", "4.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "400.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "100.00", "400.0", "40.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "100.00", "400.0", "40.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "400.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "100.00", "400.0", "40.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "40.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "100.00", "400.0", "40.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "4000.0"));
        productmodelList.add(new Productmodel("KUZHIMANDHI", "100.00", "400.0", "40.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "4000.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "4000.0"));
        productmodelList.add(new Productmodel("NewChecking Item Alfham thandu", "10.00", "40.0", "4000.0"));
        return productmodelList;
    }

}