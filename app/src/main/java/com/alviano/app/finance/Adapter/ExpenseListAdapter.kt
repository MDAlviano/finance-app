package com.alviano.app.finance.Adapter

import android.content.Context
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alviano.app.finance.Domain.ExpenseDomain
import com.alviano.app.finance.databinding.ViewholderItemsBinding
import com.bumptech.glide.Glide

class ExpenseListAdapter(private val items: MutableList<ExpenseDomain>): RecyclerView.Adapter<ExpenseListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderItemsBinding): RecyclerView.ViewHolder(binding.root)

    private lateinit var context: Context
    var formatter: DecimalFormat? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpenseListAdapter.ViewHolder {
        context = parent.context
        formatter = DecimalFormat("###,###,###.##")
        val binding=ViewholderItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseListAdapter.ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.titleTxt.text = item.title
        holder.binding.timeTxt.text = item.time
        holder.binding.priceTxt.text = "$" + formatter?.format(item.price)
        val drawableResourceId =
            holder.itemView.resources.getIdentifier(item.pic, "drawable", context.packageName)

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.binding.pic)

    }

    override fun getItemCount(): Int = items.size


}