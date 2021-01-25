package com.kotlinproject.demo.net.resp

/**
 * <li>Package: com.kotlinproject.demo.net.resp</li>
 * <li>Author: lihaoran</li>
 * <li>Date:  1/21/21</li>
 * <li>Description: </li>
 */
data class RegisterResp(
    val admin:Boolean,
    val chapterTops:List<*>,
    val collectIds:List<*>,
    val email:String?,
    val icon:String?,
    val password:String?,
    val nickname:String?,
    val publicName:String?,
    val token:String?,
    val username:String?
)