package com.dicoding.ratingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.etEmail
import kotlinx.android.synthetic.main.activity_login.etPassword


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {

            /**
            val home = Intent(activity,HomeActivity::class.java)
            startActivity(home)
            activity?.finish()*/

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email harus diisi"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email tidak valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 8) {
                etEmail.error = "Password harus diisi lebih dari 8 karakter"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            loginUser(email, password)
        }

        btnRegister.setOnClickListener {
            Intent(this@LoginActivity, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        btnForgotPassword.setOnClickListener {
            Intent(this@LoginActivity, ResetPasswordActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Intent(this@LoginActivity, HomeActivity::class.java).also { intent ->
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this@LoginActivity, HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}

