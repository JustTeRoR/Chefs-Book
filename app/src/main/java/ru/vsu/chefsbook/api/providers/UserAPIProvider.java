package ru.vsu.chefsbook.api.providers;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.vsu.chefsbook.api.CompleteCallback;
import ru.vsu.chefsbook.api.interfaces.UserAPI;
import ru.vsu.chefsbook.api.requests.UserRequest;


public class UserAPIProvider extends ProviderAPI<UserAPI> {
    @Override
    protected UserAPI createApiClass(Retrofit retrofit) {
        return retrofit.create(UserAPI.class);
    }

    public void createUser(String userCode, final CompleteCallback callback) {
        getApi().createUser(new UserRequest(userCode)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (callback != null)
                    callback.onComplete();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (callback != null)
                    callback.onFail();
            }
        });
    }
}
