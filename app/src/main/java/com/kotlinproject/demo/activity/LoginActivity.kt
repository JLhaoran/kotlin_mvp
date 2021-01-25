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
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.net.APILoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity() {
    var username:String = ""
    var password:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        user_login_bt.setOnClickListener(onCLickLister)
        user_register_tv.setOnClickListener(onCLickLister)
    }

    private var onCLickLister = View.OnClickListener {vew ->
        when(vew.id){
            R.id.user_login_bt ->{
                username = user_phone_et.text.toString()
                password = user_password_et.text.toString()
                Log.d("lhr",">>>>---username=$username password = $password")
                APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
                    // 全部都是RxJava知识了
                    .LoginAction(username,password)  // 起点  往下流  ”包装Bean“
                    .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
                    .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
                    .subscribe(object:  APILoginResponse<LoginResponse>(this)
                    {
                        override fun success(data: LoginResponse ?) {
                            // 成功  data UI
                            Log.e("lhr", "success: $data")
//                            Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
                            val intent = Intent (this@LoginActivity,HomeActivity::class.java)
                            startActivity(intent)
                        }
                        override fun failure(errorMsg: String?) {
                            // 失败 msg UI
                            Log.e("lhr", "failure: errorMsg:$errorMsg")
                            Toast.makeText(this@LoginActivity, "登录失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
                        }

                    })
            }
            R.id.user_register_tv ->{
                Log.e("lhr", "--注册---")
                val intent = Intent (this,RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

