package com.example.htprint;



public  class Productmodel {
   
   private String name;
   
   private String qty;
   
   private String rate;
   
   private String amt;

   
   public final String getName() {
      return this.name;
   }

   public final void setName( String var1) {
      this.name = var1;
   }

   
   public final String getQty() {
      return this.qty;
   }

   public final void setQty( String var1) {
      this.qty = var1;
   }

   
   public final String getRate() {
      return this.rate;
   }

   public final void setRate( String var1) {
      this.rate = var1;
   }

   
   public final String getAmt() {
      return this.amt;
   }

   public final void setAmt( String var1) {
      this.amt = var1;
   }

   public Productmodel( String itemname,  String qty,  String rate,  String amt) {
      this.name = itemname;
      this.qty = qty;
      this.rate = rate;
      this.amt = amt;
   }

   public Productmodel() {
   }
}
