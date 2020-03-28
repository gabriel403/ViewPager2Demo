package co.g403.android.viewpager2demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import co.g403.android.viewpager2demo.R
import co.g403.android.viewpager2demo.databinding.HomeFragmentBinding
import co.g403.android.viewpager2demo.testimonials.TestimonialAdapter
import co.g403.android.viewpager2demo.testimonials.network.Testimonial

class HomeFragment : Fragment() {
	private lateinit var viewModel: HomeViewModel
	private var testimonialsAdapter: TestimonialAdapter = TestimonialAdapter()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding: HomeFragmentBinding =
			DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
		binding.lifecycleOwner = viewLifecycleOwner
		viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
		binding.viewModel = viewModel

		binding.root.findViewById<ViewPager2>(R.id.testimonials_view_pager).apply {
			adapter = testimonialsAdapter
		}

		return binding.root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.testimonials.observe(
			viewLifecycleOwner,
			Observer<List<Testimonial>> { testimonials ->
				testimonials?.apply {
					testimonialsAdapter.testimonials = testimonials
				}
			})
	}
}
