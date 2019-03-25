package mx.edu.ittepic.a3_3_laboratorio.Helper;

import  mx.edu.ittepic.a3_3_laboratorio.Remote.IMenuRequest;
import  mx.edu.ittepic.a3_3_laboratorio.Remote.RetrofitClient;

public class Common {

    public static IMenuRequest getMenuRequest(){
        return RetrofitClient.getClient("https://api.androidhive.info/").create(IMenuRequest.class);
    }
}
