package co.g403.android.viewpager2demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.g403.android.viewpager2demo.R
import co.g403.android.viewpager2demo.testimonials.TestimonialAdapter
import kotlinx.android.synthetic.main.testimonials_layout.view.*

class HomeFragment : Fragment() {
	private val viewModel: HomeViewModel = HomeViewModel()
	private val testimonialsAdapter: TestimonialAdapter = TestimonialAdapter()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.home_fragment, container, false)
		view.testimonials_view_pager.adapter = testimonialsAdapter
		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		viewModel.testimonials.observe(viewLifecycleOwner, Observer { list ->
			testimonialsAdapter.submitList(list)
		})
	}
}
