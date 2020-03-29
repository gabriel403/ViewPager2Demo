package co.g403.android.viewpager2demo.testimonials.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TestimonialRepository {
	private val testimonials = MutableLiveData<List<Testimonial>>()

	fun getTestimonials(): LiveData<List<Testimonial>> {
		testimonials.value = listOf(
			Testimonial(
				testimonialText = "Gabriel is an amazing developer and I'm so appreciative to have him as my Tech Lead",
				authorText = "Pawełek Grzybek — Junior Developer",
				companyText = "Mindera"
			),
			Testimonial(
				testimonialText = "Gabriel is one of the best at what he does, always available for a job",
				authorText = "Maja Trzebiatowska — Przyjaciółka",
				companyText = "Trzebiatowska Crime Family"
			),
			Testimonial(
				testimonialText =
				"Gabriel is such a mediocre game player he makes me look good, I appreciate that he holds back so much for me",
				authorText = "Ben R — bff",
				companyText = "Loser@Games Co."
			)
		)
		return testimonials
	}
}
