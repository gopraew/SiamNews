package siam.go.mint.num.siamdailynew.manage;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;

import siam.go.mint.num.siamdailynew.R;

/**
 * Created by gopraew on 8/16/2017.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }  // constructor

    public  void myDialog(String strTitle, String strMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //แทรกไอคอนแจ้งเตือน
        builder.setIcon(R.mipmap.ic_alert);

        builder.setCancelable(false);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );  //สิ่งที่อยู่บนปุ่ม

        builder.show();
    }


}  //Main class
