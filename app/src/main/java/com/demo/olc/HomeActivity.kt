package com.demo.olc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.demo.olc.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private var toolbar : Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        toolbar = findViewById(R.id.toolbar)
        setFragments(bottomNavigation)
    }

    private fun setFragments(bottomNavigation: BottomNavigationView) {
        val homeFragment = HomeFragment()
        val rankFragment = RankFragment()
        val contestFragment = ContestFragment()
        val notificationFragment = NotificationFragment()
        val profileFragment = ProfileFragment()
        var activeFragment: Fragment
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.main_container, homeFragment, "1").commit()
        fragmentManager.beginTransaction().add(R.id.main_container, rankFragment, "2")
            .hide(rankFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, contestFragment, "3")
            .hide(contestFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, notificationFragment, "4")
            .hide(notificationFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, profileFragment, "5")
            .hide(profileFragment).commit()

        activeFragment = homeFragment
        toolbar?.setTitle(R.string.title_home)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_screen -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                    toolbar?.setTitle(R.string.title_home)
                    true
                }
                R.id.rank_screen -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(rankFragment).commit()
                    activeFragment = rankFragment
                    toolbar?.setTitle(R.string.title_rank)
                    true
                }
                R.id.contest_screen -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(contestFragment).commit()
                    activeFragment = contestFragment
                    toolbar?.setTitle(R.string.title_contest)
                    true
                }
                R.id.notification_screen -> {
                    fragmentManager.beginTransaction().hide(activeFragment)
                        .show(notificationFragment).commit()
                    activeFragment = notificationFragment
                    toolbar?.setTitle(R.string.title_notification)
                    true
                }
                R.id.profile_screen -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                    activeFragment = profileFragment
                    toolbar?.setTitle(R.string.title_Profile)
                    true
                }
                else -> false
            }
        }


    }
}