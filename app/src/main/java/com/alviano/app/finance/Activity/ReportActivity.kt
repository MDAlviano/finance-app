package com.alviano.app.finance.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alviano.app.finance.Adapter.ReportListAdapter
import com.alviano.app.finance.R
import com.alviano.app.finance.ViewModel.MainViewModel
import com.alviano.app.finance.databinding.ActivityReportBinding

class ReportActivity : AppCompatActivity() {
    lateinit var binding: ActivityReportBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerView()
        setVariable()
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun initRecyclerView() {
        binding.view2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.view2.adapter=ReportListAdapter(mainViewModel.loadBudget())
        binding.view2.isNestedScrollingEnabled=false
    }
}