package com.sergiocasero.notificationmanager

import android.os.Bundle
import com.sergiocasero.notifikationmanager.NotifikationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : NotifikationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onNotificationReceived(any: Any) {
        textView.text = any as String
    }
}
