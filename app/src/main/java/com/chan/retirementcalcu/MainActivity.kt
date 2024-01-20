package com.chan.retirementcalcu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var textview: TextView
    lateinit var interestRate: EditText
    lateinit var age: EditText
    lateinit var retirementAge: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.button)
        textview = findViewById(R.id.textView)
        interestRate = findViewById(R.id.interestRate)
        age = findViewById(R.id.currentAge)
        retirementAge = findViewById(R.id.retirementAge)
        AppCenter.start(
            application, "1ea0e851-abf0-4b0e-af37-16a714a91419",
            Analytics::class.java, Crashes::class.java
        )



        button.setOnClickListener {
            //throw Exception("something went wrong");
           // textview.text = "tere"
            //Crashes.generateTestCrash()

            val intRate = interestRate.text.toString().toFloat()
            val ageRate = age.text.toString().toInt()
            val retireAge = retirementAge.text.toString().toInt()
            if(intRate <= 0){
                Analytics.trackEvent("wrong_interest_rate")
            }
            if(retireAge <= ageRate){
                Analytics.trackEvent("wrong age")
            }

            textview.text = "result for calculating "
        }

    }
}