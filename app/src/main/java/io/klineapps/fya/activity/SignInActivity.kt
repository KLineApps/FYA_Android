package io.klineapps.fya.activity

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import io.klineapps.fya.R
import io.klineapps.fya.activity.base.BaseActivity

class SignInActivity : BaseActivity(){

    private var signInButton: Button? = null
    private var usernameInput: EditText? = null
    private var passwordInput: EditText? = null

    private var newAccountLink: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInButton = findViewById(R.id.button_login)

        usernameInput = findViewById(R.id.username)
        passwordInput = findViewById(R.id.password)
        newAccountLink = findViewById(R.id.new_account_link)

        listenerSignInButton()
        listenerSignUpButton()
    }

    private fun listenerSignInButton() {
        var textUsername = usernameInput?.getText()
        var textPassword = passwordInput?.getText()

        signInButton?.setOnClickListener{
            if(TextUtils.isEmpty(textUsername)) {
                Toast.makeText(this, "Por favor, preencha o campo nome de usuário", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(textUsername).matches()) {
                Toast.makeText(this, "O nome de usuário deve ser um email válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(textPassword)) {
                Toast.makeText(this, "Por favor, preencha o campo de senha", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    private fun listenerSignUpButton() {
        newAccountLink?.setOnClickListener{
            goToActivity(SignUpActivity::class.java)
        }
    }
}
