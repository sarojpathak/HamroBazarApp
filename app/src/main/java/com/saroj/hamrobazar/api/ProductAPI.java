package com.saroj.hamrobazar.api;

import com.saroj.hamrobazar.model.Product;
import com.saroj.hamrobazar.model.User;
import com.saroj.hamrobazar.serverresponse.ImageResponse;
import com.saroj.hamrobazar.serverresponse.SignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ProductAPI {

    @GET("products/")
    Call <List<Product>> getRecentProduct();


//    @GET("products/")
//    Call <Product> getProductDetails();
}
