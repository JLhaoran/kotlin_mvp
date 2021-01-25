package com.kotlinproject.demo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.kotlinproject.demo.R
import com.kotlinproject.demo.net.api.APIClient
import com.kotlinproject.demo.net.api.WanAndroidAPI
import com.kotlinproject.demo.net.resp.RegisterResp
import com.xiangxue.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.user_login_bt
import kotlinx.android.synthetic.main.activity_login.user_password_et
import kotlinx.android.synthetic.main.activity_login.user_phone_et
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var username:String = ""
    var password:String = ""
    var repassword:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        user_login_bt.setOnClickListener(onCLickLister)
    }
    private var onCLickLister = View.OnClickListener { vew ->
        when(vew.id){
            R.id.user_login_bt ->{
                username = user_phone_et.text.toString()
                password = user_password_et.text.toString()
                repassword = user_password_et_re.text.toString()
                if(!password.equals(repassword)==true){
                    Toast.makeText(this@RegisterActivity, "两次密码不一致", Toast.LENGTH_SHORT).show()
                    return@OnClickListener
                }
                APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
                    // 全部都是RxJava知识了
                    .RegisterAction(username,password,repassword)  // 起点  往下流  ”包装Bean“
                    .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
                    .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
                    .subscribe(object:  APIResponse<RegisterResp>(this)
                    {
                        override fun success(data: RegisterResp?) {
                            // 成功  data UI
                            Log.e("lhr", "success: $data")
                            Toast.makeText(this@RegisterActivity, "注册成功", Toast.LENGTH_SHORT).show()
                            val intent = Intent (this@RegisterActivity,LoginActivity::class.java)
                            startActivity(intent)
                            finish()

                        }
                        override fun failure(errorMsg: String?) {
                            // 失败 msg UI
                            Log.e("lhr", "failure: errorMsg:$errorMsg")
                            Toast.makeText(this@RegisterActivity, "注册失败", Toast.LENGTH_SHORT).show()
                        }
                    })
            }

        }
    }
}