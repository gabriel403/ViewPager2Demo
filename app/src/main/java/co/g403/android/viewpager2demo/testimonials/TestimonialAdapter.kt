package co.g403.android.viewpager2demo.testimonials

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.g403.android.viewpager2demo.R
import co.g403.android.viewpager2demo.testimonials.datasource.Testimonial

class TestimonialAdapter :
	ListAdapter<Testimonial, TestimonialViewHolder>(TestimonialItemDiffCallback()) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding =
			DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
		return TestimonialViewHolder(binding)
	}

	override fun onBindViewHolder(holder: TestimonialViewHolder, position: Int) =
		holder.bind(getItem(position))

	override fun getItemViewType(position: Int) = R.layout.testimonial_layout
}

class TestimonialItemDiffCallback : DiffUtil.ItemCallback<Testimonial>() {
	override fun areItemsTheSame(oldItem: Testimonial, newItem: Testimonial): Boolean =
		oldItem == newItem

	override fun areContentsTheSame(oldItem: Testimonial, newItem: Testimonial): Boolean =
		oldItem == newItem
}

class TestimonialViewHolder(private val binding: ViewDataBinding) :
	RecyclerView.ViewHolder(binding.root) {
	fun bind(testimonial: Testimonial) {
		binding.setVariable(BR.item, testimonial)
		binding.executePendingBindings()
	}
}
