package com.demo.olc.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.demo.olc.R
import com.demo.olc.adapter.ProfileSubFragmentAdapter
import com.demo.olc.viewmodels.ProfileViewModel
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    private var drawerMenu: ImageView? = null
    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager2? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        drawerMenu = view.findViewById(R.id.ib_drawer_menu)
        drawerLayout = view.findViewById(R.id.drawer_layout)
        navigationView = view.findViewById(R.id.menu_navigation)
        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.viewPager2)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        drawerMenu?.setOnClickListener {
            drawerLayout?.openDrawer(Gravity.RIGHT)
        }
        setDrawerMenuClickEvent()

        val subFragmentAdapter =
            ProfileSubFragmentAdapter(this)
        viewPager?.adapter = subFragmentAdapter
        if (tabLayout != null && viewPager != null) {
            TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
                tab.text = subFragmentAdapter.fragmentList[position].title
            }.attach()
        }


    }

    private fun setDrawerMenuClickEvent() {

        navigationView?.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.earn_coins -> {
                    Toast.makeText(context, R.string.profile_earn_coins, Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.invite_friends -> {
                    Toast.makeText(context, R.string.profile_invite_friends, Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.privacy -> {
                    Toast.makeText(context, R.string.profile_privacy, Toast.LENGTH_SHORT).show()
                }
                R.id.notification -> {
                    Toast.makeText(context, R.string.profile_notification, Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.message -> {
                    Toast.makeText(context, R.string.profile_message, Toast.LENGTH_SHORT).show()
                }
                R.id.account_settings -> {
                    Toast.makeText(
                        context,
                        R.string.profile_account_setting,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.help_us -> {
                    Toast.makeText(context, R.string.profile_help_us, Toast.LENGTH_SHORT).show()
                }
                R.id.term_condition -> {
                    Toast.makeText(context, R.string.profile_term_condition, Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.logout -> {
                    Toast.makeText(context, R.string.profile_logout, Toast.LENGTH_SHORT).show()
                }

            }

            drawerLayout?.closeDrawer(Gravity.RIGHT, false)

            true
        }

    }

    override fun onDestroyView() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.END) == true) {
            drawerLayout?.closeDrawer(Gravity.RIGHT, false)
        }
        super.onDestroyView()


    }

}