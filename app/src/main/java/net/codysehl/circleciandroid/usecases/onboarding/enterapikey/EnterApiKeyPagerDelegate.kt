package net.codysehl.circleciandroid.usecases.onboarding.enterapikey

import androidx.fragment.app.Fragment
import net.codysehl.circleciandroid.utils.fragmentpageradapter.FragmentPagerAdapterDelegate

class EnterApiKeyPagerDelegate: FragmentPagerAdapterDelegate {
    override fun create(): Fragment = EnterApiKeyFragment()
}