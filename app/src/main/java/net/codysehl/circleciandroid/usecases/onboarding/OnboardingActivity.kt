package net.codysehl.circleciandroid.usecases.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import net.codysehl.circleciandroid.R
import net.codysehl.circleciandroid.databinding.ActivityOnboardingBinding
import net.codysehl.circleciandroid.usecases.onboarding.createapikey.CreateApiKeyPagerDelegate
import net.codysehl.circleciandroid.usecases.onboarding.enterapikey.EnterApiKeyFragment
import net.codysehl.circleciandroid.usecases.onboarding.enterapikey.EnterApiKeyPagerDelegate
import net.codysehl.circleciandroid.utils.fragmentpageradapter.SimpleFragmentPagerAdapter

class OnboardingActivity : AppCompatActivity() {

    val viewModel = OnboardingViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityOnboardingBinding>(
            this,
            R.layout.activity_onboarding
        )

        val viewPager = binding.root.findViewById<ViewPager>(R.id.activity_onboarding_view_pager)
        viewPager.adapter = SimpleFragmentPagerAdapter(
            supportFragmentManager,
            listOf(
                CreateApiKeyPagerDelegate(),
                EnterApiKeyPagerDelegate()
            )
        )
        val tabLayout = binding.root.findViewById<TabLayout>(R.id.activity_onboarding_tab_layout)
        tabLayout.setupWithViewPager(viewPager)

        binding.viewModel = viewModel
        lifecycle.addObserver(viewModel)
    }
}
