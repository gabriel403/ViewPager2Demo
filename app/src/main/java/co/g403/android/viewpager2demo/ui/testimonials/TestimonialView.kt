package co.g403.android.viewpager2demo.ui.testimonials

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.g403.android.viewpager2demo.R
import co.g403.android.viewpager2demo.testimonials.network.Testimonial

class TestimonialView(layoutInflater: LayoutInflater, container: ViewGroup?) {

	val view: View = layoutInflater.inflate(R.layout.testimonial_layout, container, false)
	private val testimonialText: TextView = view.findViewById(R.id.testimonial_text)
	private val testimonialAuthor: TextView = view.findViewById(R.id.testimonial_author)
	private val testimonialCompany: TextView = view.findViewById(R.id.testimonial_company)

	fun bind(testimonial: Testimonial) {
		testimonialAuthor.text = testimonial.authorText
		testimonialText.text = testimonial.testimonialText
		testimonialCompany.text = testimonial.companyText
	}
}
