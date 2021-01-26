package com.kotlinproject.demo.model

import android.content.Context
import com.kotlinproject.demo.presenter.ILoginPresenter

/**
 * <li>Package: com.kotlinproject.demo.model</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/26/21</li>
 * <li>Description: </li>
 */
interface ILoginModel {
    // 取消请求 动作
    fun cancelRequest()

    fun login(
        context: Context,
        username: String,
        password: String,
        // 接口回调，把data 结果，给P层
        onLoginListener: ILoginPresenter.OnLoginListener
    )

}