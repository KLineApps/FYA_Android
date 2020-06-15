package io.klineapps.fya.activity

import android.os.Bundle
import io.klineapps.fya.activity.base.BaseActivity

import io.klineapps.fya.R

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)
    }
}