package siam.go.mint.num.siamdailynew.manage;

/**
 * Created by gopraew on 8/22/2017.
 */

public class MyConstant {

    //สำหรับ URL
    private  String urlfacdep = "http://gopraew.com/Android/getAllData.php";
    private String urlAddmember = "http://gopraew.com/Android/addMember.php";
    private String urlGetAllMember = "http://gopraew.com/Android/getAllMember.php";


    //Other
    private  String[] columnMemberStrings = new String[]{
            "m_name",
            "m_surname",
            "m_gender",
            "m_email",
            "m_username",
            "m_password",
            "f_id"};

    public String getUrlGetAllMember() {
        return urlGetAllMember;
    }

    public String[] getColumnMemberStrings() {
        return columnMemberStrings;
    }

    public String getUrlAddmember() {
        return urlAddmember;
    }





    //กำหนดค่าให้กับวัตถุ โดยใช้ get set


    public String getUrlfacdep() {
        return urlfacdep;
    }
}// Mian class
