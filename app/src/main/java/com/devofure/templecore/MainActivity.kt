package com.devofure.templecore

import android.os.Bundle
import com.devofure.templecore.di._core.DaggerActivityBase
import com.devofure.templecore.ui.main.MainFragment

class MainActivity : DaggerActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
