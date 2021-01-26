package com.kotlinproject.demo.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.kotlinproject.demo.net.api.APIClient
import com.kotlinproject.demo.net.api.WanAndroidAPI
import com.kotlinproject.demo.net.resp.RegisterResp
import com.kotlinproject.demo.presenter.IRegisterPresenter
import com.xiangxue.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
/**
 * <li>Package: com.kotlinproject.demo.model</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/26/21</li>
 * <li>Description: </li>
 */
class RegisterModelImpl:IRegisterModel {
    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        listener: IRegisterPresenter.RegisterListener
    ) {
        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            // 全部都是RxJava知识了
            .RegisterAction(username,password,repassword)  // 起点  往下流  ”包装Bean“
            .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
            .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
            .subscribe(object:  APIResponse<RegisterResp>(context)
            {
                override fun success(data: RegisterResp?) {
                    // 成功  data UI
                    listener.onSuccess(data)

                }
                override fun failure(errorMsg: String?) {
                    // 失败 msg UI
                    listener.onFailure(errorMsg)
                }
            })
    }

}