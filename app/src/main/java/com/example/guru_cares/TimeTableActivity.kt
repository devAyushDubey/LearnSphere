package com.example.guru_cares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guru_cares.modelclass.TimeModel

class TimeTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)


        val arrTimeTable = ArrayList<TimeModel>()

//        mDataList.add(TimeLineModel("Order placed successfully", "2017-02-10 14:00", OrderStatus.COMPLETED))
    }
}