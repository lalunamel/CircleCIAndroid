package net.codysehl.circleciandroid.utils.fragmentpageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SimpleFragmentPagerAdapter(fragmentManager: FragmentManager, private val delegates: List<FragmentPagerAdapterDelegate>): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment = delegates[position].create()
    override fun getCount(): Int = delegates.size
}