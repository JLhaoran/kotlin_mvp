package com.kotlinproject.demo.model

import android.content.Context
import com.kotlinproject.demo.net.api.APIClient
import com.kotlinproject.demo.net.api.WanAndroidAPI
import com.kotlinproject.demo.presenter.ILoginPresenter
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.net.APILoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * <li>Package: com.kotlinproject.demo.model</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/26/21</li>
 * <li>Description: </li>
 */
class ILoginModelImpl:ILoginModel{
    override fun cancelRequest() {
    }
    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: ILoginPresenter.OnLoginListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            // 全部都是RxJava知识了
            .LoginAction(username,password)  // 起点  往下流  ”包装Bean“
            .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
            .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
            .subscribe(object:  APILoginResponse<LoginResponse>(context)
            {
                override fun success(data: LoginResponse?) {
                    // 成功  data UI
                    onLoginListener.loginSuccess(data)
                }
                override fun failure(errorMsg: String?) {
                    // 失败 msg UI
                    onLoginListener.loginFialure(errorMsg)
                }

            })
    }
}