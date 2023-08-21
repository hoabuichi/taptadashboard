package com.example.taptadashboard.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taptadashboard.MainActivity
import com.example.taptadashboard.R
import com.example.taptadashboard.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var onBoardingItemsAdapter: OnBoardingAdapter
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnBoardingItems()

        binding.skipBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setOnBoardingItems() {
        onBoardingItemsAdapter = OnBoardingAdapter(listOf(
            OnBoardingItem(onBoardingImage = R.drawable.on_boarding_1, title="Thanh toán nhanh chóng và thuận tiện", description = "Thực hiện các giao dịch thanh toán nhanh chóng và thuận tiện chỉ bằng một cú chạm"),
            OnBoardingItem(onBoardingImage = R.drawable.on_boarding_2, title="Rút tiền ngoại tệ dễ dàng hơn bao giờ hết", description = "Không còn rắc rối khi rút tiền về ngân hàng."),
            OnBoardingItem(onBoardingImage = R.drawable.on_boarding_3, title="Quản lý tài khoản thông minh", description = "Xem số dư, theo dõi lịch sử giao dịch và kiểm soát các tài khoản liên kết chỉ bằng vài lần chạm")
        ))
        binding.onBoardingPager.adapter =  onBoardingItemsAdapter
    }
}