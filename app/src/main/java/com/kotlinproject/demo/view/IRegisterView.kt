package com.kotlinproject.demo.view

import com.kotlinproject.demo.net.resp.RegisterResp
import com.xiangxue.kotlinproject.entity.LoginResponse

/**
 * <li>Package: com.kotlinproject.demo.view</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/25/21</li>
 * <li>Description: </li>
 */
interface IRegisterView {
  // 把结果显示到  Activity / Fragment
  fun regiterSuccess(registerBean: RegisterResp?)
  fun regiterFailure(errorMessage:String?)
}
