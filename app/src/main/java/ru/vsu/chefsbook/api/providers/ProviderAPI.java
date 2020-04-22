package ru.vsu.chefsbook.api.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.vsu.chefsbook.BuildConfig;
import ru.vsu.chefsbook.App;

public abstract class ProviderAPI<T> {
    private T mealsAPI;

    public ProviderAPI() {
        init();
    }

    protected void init() {
        mealsAPI = createApiClass(buildRetrofit(buildOkHttp()));
    }

    protected T getApi() {
        return mealsAPI;
    }

    protected abstract T createApiClass(Retrofit retrofit);

    private OkHttpClient buildOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.networkInterceptors().add(httpLoggingInterceptor);
        }
        return builder.build();
    }

    private Retrofit buildRetrofit(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        return new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
