package com.example.loginbyfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.loginbyfirebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        val signupbtn = binding.goSignup
        signupbtn.setOnClickListener {
            val getnewemail:String = binding.emailsignup.text.toString()
            val getnewusername = binding.usernameSignup.text.toString()
            val getnewpass = binding.passwordSignup.text.toString()
            val getnewpass2 = binding.passowrd2Signup.text.toString()

            auth.createUserWithEmailAndPassword(getnewemail,getnewpass)
                .addOnCompleteListener { task->
                    if(getnewpass != getnewpass2){
                        Toast.makeText(this,"Passwords Dont Match!",Toast.LENGTH_SHORT).show()
                    }else if(task.isSuccessful){
                        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,Login::class.java))

                    }else{
                        Toast.makeText(this,"NO Success${task.exception?.message}",Toast.LENGTH_SHORT).show()
                    }
                }
        }



    }
}