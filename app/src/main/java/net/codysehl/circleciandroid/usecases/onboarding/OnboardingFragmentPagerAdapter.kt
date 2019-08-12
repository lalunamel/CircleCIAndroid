package net.codysehl.circleciandroid.usecases.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import net.codysehl.circleciandroid.usecases.onboarding.createapikey.CreateApiKeyFragment

class OnboardingFragmentPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return CreateApiKeyFragment()
    }

    override fun getCount(): Int {
        return 2
    }
}