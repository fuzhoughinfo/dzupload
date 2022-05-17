package com.ghinfo.dzupload.utils;

import com.jacob.activeX.ActiveXComponent;

public class ActiveXComponentUtils {

    private static final ActiveXComponent ACTIVEX = new ActiveXComponent("CLSID:1037E3F8-F546-4DC1-A03B-393BE550AE0D");    //SMISImageHelper.ocx

    private static ActiveXComponent activex;

    public static ActiveXComponent getInstance() {
        return ACTIVEX;
    }

    public static ActiveXComponent getInstance2() {
        if(activex == null) {
            activex = new ActiveXComponent("CLSID:1037E3F8-F546-4DC1-A03B-393BE550AE0D");
        }
        return activex;
    }

   /*public static void main(String[] args) {
      for(int i = 0;i < 300;i++) {
         new Runnable() {

            @Override
            public void run() {
               System.out.println(ActiveXComponentUtils.getInstance().getClass().getName());
            }
         };

      }
   }*/

}
