package com.kotlinproject.demo.net.api

import com.kotlinproject.demo.net.resp.RegisterResp
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.entity.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * <li>Package: com.kotlinproject.demo.net.api</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/21/21</li>
 * <li>Description: </li>
 *
 * username:Derry-vip
password:123456
repassword:123456
 */
interface WanAndroidAPI {
    @POST("/user/register")
    @FormUrlEncoded
    fun RegisterAction(@Field("username")  username: String,
                    @Field("password")   password: String,
                    @Field("repassword") repassword: String)
    :Observable<LoginResponseWrapper<RegisterResp>> // 返回值

    @POST("/user/login")
    @FormUrlEncoded
    fun LoginAction(@Field("username")  username: String,
                    @Field("password")   password: String
    )
            :Observable<LoginResponseWrapper<LoginResponse>> // 返回值
}