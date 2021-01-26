package com.kotlinproject.demo.view

import com.xiangxue.kotlinproject.entity.LoginResponse

/**
 * <li>Package: com.kotlinproject.demo.view</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/25/21</li>
 * <li>Description: </li>
 */
interface ILoginView {
    // 把结果显示到  Activity / Fragment
    fun loginSuccess(loginBean: LoginResponse ?)
    fun loginFailure(errorMessage:String?)
}