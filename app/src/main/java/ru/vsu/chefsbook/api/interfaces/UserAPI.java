package ru.vsu.chefsbook.api.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.vsu.chefsbook.api.requests.UserRequest;


public interface UserAPI {
    @POST("/users")
    Call<ResponseBody> createUser(@Body UserRequest userRequestDTO);
}


