package kg.asel.filmapi.frameworks;

import java.util.List;

import kg.asel.filmapi.data.MokerModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MokerApi {

    @GET("posts")
    Call<List<MokerModel>> getPosts();

    @DELETE("posts/{id}")
    Call<MokerModel> deleteById(
            @Path("id") Integer id
    );

    @POST("posts")
    Call<MokerModel> createMokerModel(
            @Body MokerModel mokerModel
    );

    @PUT("posts/{id}")
    Call<MokerModel> upgrade(@Path("id") String id, @Body MokerModel mokerModel);
}
