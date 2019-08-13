package net.codysehl.circleciandroid.utils.fragmentpageradapter

import androidx.fragment.app.Fragment

interface FragmentPagerAdapterDelegate {
    fun create(): Fragment
}