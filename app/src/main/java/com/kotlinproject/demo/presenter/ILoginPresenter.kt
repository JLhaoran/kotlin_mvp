package com.kotlinproject.demo.presenter

import android.content.Context
import com.xiangxue.kotlinproject.entity.LoginResponse

/**
 * <li>Package: com.kotlinproject.demo.presenter</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/25/21</li>
 * <li>Description: </li>
 */
interface ILoginPresenter {
    fun login(context:Context,username:String,password:String)
    // 监听回调
    interface OnLoginListener {
        fun loginSuccess(loginBean:LoginResponse?)
        fun loginFialure(erroeMsg: String  ?)
    }
}


