package com.demo.olc.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.olc.R
import com.demo.olc.fragments.subfragment.ContestFragment
import com.demo.olc.fragments.subfragment.BoardFragment
import com.demo.olc.fragments.subfragment.ChallengFragment
import com.demo.olc.fragments.subfragment.PortfolioFragment

data class SubFragment(val title: String, val fragment: Fragment)
class ProfileSubFragmentAdapter(context:Fragment) : FragmentStateAdapter(context) {
     val fragmentList : MutableList<SubFragment> = ArrayList()

    init {
        fragmentList.add(
            SubFragment(
                context.resources.getString(
                    R.string.profile_sub_contest
                ), ContestFragment()
            )
        )
        fragmentList.add(
            SubFragment(
                context.resources.getString(
                    R.string.profile_sub_challenge
                ), ChallengFragment()
            )
        )
        fragmentList.add(
            SubFragment(
                context.resources.getString(
                    R.string.profile_sub_portfolio
                ), PortfolioFragment()
            )
        )
        fragmentList.add(
            SubFragment(
                context.resources.getString(
                    R.string.profile_sub_board
                ), BoardFragment()
            )
        )

    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position].fragment
    }

}