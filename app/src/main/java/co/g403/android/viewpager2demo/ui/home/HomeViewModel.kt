package co.g403.android.viewpager2demo.ui.home

import androidx.lifecycle.ViewModel
import co.g403.android.viewpager2demo.testimonials.datasource.TestimonialRepository

class HomeViewModel : ViewModel() {
	private val testimonialRepository = TestimonialRepository()
	val testimonials = testimonialRepository.getTestimonials()
}
