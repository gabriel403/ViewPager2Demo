package co.g403.android.viewpager2demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import co.g403.android.viewpager2demo.R
import co.g403.android.viewpager2demo.testimonials.TestimonialAdapter


class HomeFragment : Fragment() {
	private val viewModel: HomeViewModel = HomeViewModel()
	private val testimonialsAdapter: TestimonialAdapter = TestimonialAdapter()
	private lateinit var viewPager: ViewPager2


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(
			R.layout.home_fragment, container,
			false
		)
		viewPager = view.findViewById(R.id.testimonials_view_pager)
		viewPager.adapter = testimonialsAdapter
		return view

	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.testimonials.observe(viewLifecycleOwner, Observer { list ->
			testimonialsAdapter.submitList(list)
		})
	}
}
