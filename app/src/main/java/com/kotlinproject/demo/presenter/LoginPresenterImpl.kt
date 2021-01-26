package com.kotlinproject.demo.presenter

import android.content.Context
import com.kotlinproject.demo.model.ILoginModel
import com.kotlinproject.demo.model.ILoginModelImpl
import com.kotlinproject.demo.view.ILoginView
import com.xiangxue.kotlinproject.entity.LoginResponse

/**
 * <li>Package: com.kotlinproject.demo.presenter</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/26/21</li>
 * <li>Description: </li>
 */
class LoginPresenterImpl(var loginView:ILoginView?):ILoginPresenter,ILoginPresenter.OnLoginListener{
    lateinit var loginModel:ILoginModel

    // 需要 V 去更新 Activity/Fragment
    override fun login(context: Context, username: String, password: String) {
        loginModel = ILoginModelImpl()
        loginModel.login(context,username,password,this)
    }

    override fun loginSuccess(loginBean: LoginResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFialure(erroeMsg: String?) {
        loginView?.loginFailure(erroeMsg)
    }
}