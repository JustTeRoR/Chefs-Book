package com.haerful.foodapp.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {

    private static final String BASE_URL = " https://92f936ad319c.ngrok.io/chefsbook/api/";
    private  static String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdXN0dGVycm9yIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTU5MjM1OTc4N30.PH42IiEto0ZaMisUgPZtS4L5HjxzHBLGbY9ArHaXSoS0VZ8UvFGSAfwRncQ_yDiGHL9FfofB9dlBwGJfdz0rWA";

    public static Retrofit getFoodClient() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(provideOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                //.addNetworkInterceptor(provideLoggingInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request newRequest  = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + token)
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .build();
    }
}
