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
import com.kotlinproject.demo.presenter.ILoginPresenter
import com.kotlinproject.demo.presenter.LoginPresenterImpl
import com.kotlinproject.demo.view.ILoginView
import com.xiangxue.kotlinproject.entity.LoginResponse
import com.xiangxue.kotlinproject.net.APILoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity(),ILoginView{
    var username:String = ""
    var password:String = ""
    lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        user_login_bt.setOnClickListener(onCLickLister)
        user_register_tv.setOnClickListener(onCLickLister)
        loginPresenter = LoginPresenterImpl(this)
    }

    private var onCLickLister = View.OnClickListener {vew ->
        when(vew.id){
            R.id.user_login_bt ->{
                username = user_phone_et.text.toString()
                password = user_password_et.text.toString()
                loginPresenter.login(this,username,password)
            }
            R.id.user_register_tv ->{
                val intent = Intent (this,RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun loginSuccess(loginBean: LoginResponse?) {
        Log.d("LoginActivity","login success")
        val intent = Intent (this,HomeActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailure(errorMessage: String?) {
        Log.d("LoginActivity",">>>>login fail----$errorMessage")
        Toast.makeText(this@LoginActivity, "登录失败", Toast.LENGTH_SHORT).show()
    }
}

