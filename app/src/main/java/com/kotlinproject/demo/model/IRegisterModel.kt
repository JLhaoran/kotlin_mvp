package com.kotlinproject.demo.model

import android.content.Context
import com.kotlinproject.demo.presenter.IRegisterPresenter

/**
 * <li>Package: com.kotlinproject.demo.model</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/26/21</li>
 * <li>Description: </li>
 *
 *   var username:String = ""
var password:String = ""
var repassword:String = ""
 */
interface IRegisterModel {

    fun register(
                 context:Context,
                 username:String,
                 password:String,
                 repassword:String,
                 listener: IRegisterPresenter.RegisterListener
                 )

}