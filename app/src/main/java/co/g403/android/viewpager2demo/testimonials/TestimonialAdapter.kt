package co.g403.android.viewpager2demo.testimonials

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.g403.android.viewpager2demo.testimonials.network.Testimonial
import co.g403.android.viewpager2demo.ui.testimonials.TestimonialView

class TestimonialAdapter : RecyclerView.Adapter<TestimonialViewHolder>() {
	var testimonials: List<Testimonial> = emptyList()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialViewHolder {
		return TestimonialViewHolder(
			TestimonialView(
				LayoutInflater.from(parent.context),
				parent
			)
		)
	}

	override fun onBindViewHolder(holder: TestimonialViewHolder, position: Int) {
		holder.bind(testimonials[position])
	}

	override fun getItemCount(): Int {
		return testimonials.size
	}
}

class TestimonialViewHolder internal constructor(private val testimonialView: TestimonialView) :
	RecyclerView.ViewHolder(testimonialView.view) {
	internal fun bind(testimonial: Testimonial) {
		testimonialView.bind(testimonial)
	}
}
