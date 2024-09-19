package com.alviano.app.finance.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alviano.app.finance.Adapter.ExpenseListAdapter
import com.alviano.app.finance.R
import com.alviano.app.finance.ViewModel.MainViewModel
import com.alviano.app.finance.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecycleview()
        setBlueEffect()
        setVariable()

    }

    private fun setVariable() {
        binding.cardBtn.setOnClickListener {
            startActivity(Intent(this, ReportActivity::class.java))
        }
    }

    private fun setBlueEffect() {
        val radius = 10F
        val decorView = this.window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackgorund = decorView.background
        binding.blurView.setupWith(
            rootView,
            RenderScriptBlur(this)

        )
            .setFrameClearDrawable(windowBackgorund)
            .setBlurRadius(radius)

        binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blurView.setClipToOutline(true)
    }

    private fun initRecycleview() {
        binding.view1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view1.adapter = ExpenseListAdapter(mainViewModel.loadData())
        binding.view1.isNestedScrollingEnabled = false
    }
}