 package mx.edu.ittepic.a3_3_laboratorio.Remote;

import mx.edu.ittepic.a3_3_laboratorio.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IMenuRequest {

    @GET
    Call<List<Item>> getMenuList(@Url String url);
}
