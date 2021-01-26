package com.kotlinproject.demo.presenter

import android.content.Context
import com.kotlinproject.demo.net.resp.RegisterResp

/**
 * <li>Package: com.kotlinproject.demo.presenter</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/25/21</li>
 * <li>Description: </li>
 */
interface IRegisterPresenter {

    fun register(context:Context,username:String,password:String,repassword:String)

    interface RegisterListener{
        fun onSuccess(data: RegisterResp?)
        fun onFailure(errorMsg:String?)
    }
}