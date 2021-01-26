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
import com.kotlinproject.demo.presenter.IRegisterPresenter
import com.kotlinproject.demo.presenter.RegisterPresenterImpl
import com.kotlinproject.demo.view.IRegisterView
import com.xiangxue.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.user_login_bt
import kotlinx.android.synthetic.main.activity_login.user_password_et
import kotlinx.android.synthetic.main.activity_login.user_phone_et
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(),IRegisterView {
    var username:String = ""
    var password:String = ""
    var repassword:String = ""
    lateinit var registerPresenter:IRegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        user_login_bt.setOnClickListener(onCLickLister)
        registerPresenter = RegisterPresenterImpl(this)
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
                registerPresenter.register(this,username,password,repassword)
            }

        }
    }

    override fun regiterSuccess(registerBean: RegisterResp?) {
        val intent = Intent (this@RegisterActivity,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun regiterFailure(errorMessage: String?) {
        Log.e("RegisterActivity", "failure: errorMsg:$errorMessage")
        Toast.makeText(this@RegisterActivity, "注册失败", Toast.LENGTH_SHORT).show()
    }
}