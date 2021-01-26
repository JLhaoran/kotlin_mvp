package com.kotlinproject.demo.presenter

import android.content.Context
import com.kotlinproject.demo.model.IRegisterModel
import com.kotlinproject.demo.model.RegisterModelImpl
import com.kotlinproject.demo.net.resp.RegisterResp
import com.kotlinproject.demo.view.IRegisterView

/**
 * <li>Package: com.kotlinproject.demo.presenter</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/25/21</li>
 * <li>Description: </li>
 */
class RegisterPresenterImpl(val registerView:IRegisterView) :IRegisterPresenter,IRegisterPresenter.RegisterListener{
   lateinit var registerModel:IRegisterModel

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String
    ) {
        registerModel = RegisterModelImpl()
        registerModel.register( context,username,password,repassword,this)
    }

    override fun onSuccess(data: RegisterResp?) {
        registerView.regiterSuccess(data)
    }

    override fun onFailure(errorMsg: String?) {
        registerView.regiterFailure(errorMsg)

    }


}