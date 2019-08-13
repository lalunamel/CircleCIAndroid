package net.codysehl.circleciandroid.usecases.onboarding.createapikey

import androidx.fragment.app.Fragment
import net.codysehl.circleciandroid.utils.fragmentpageradapter.FragmentPagerAdapterDelegate

class CreateApiKeyPagerDelegate: FragmentPagerAdapterDelegate {
    override fun create(): Fragment = CreateApiKeyFragment()
}