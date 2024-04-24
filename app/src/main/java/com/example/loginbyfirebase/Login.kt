package com.example.loginbyfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginbyfirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var  auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val chngepage = binding.gotoSignup
        val loginbtn = binding.goSignup
        chngepage.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        loginbtn.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val pass = binding.passwordLogin.text.toString()
            auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,Finn::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"NO Login${task.exception?.message}",Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}