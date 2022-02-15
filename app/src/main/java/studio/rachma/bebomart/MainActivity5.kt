package studio.rachma.bebomart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import studio.rachma.bebomart.databinding.ActivityMain2Binding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    private lateinit var adapter : ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intArrayOf(
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
        )
        for (i in image.indices){
            list.add(ImageData(image[i]))
        }
        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size) {
            if (position == i) {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.purple_700))
            } else {
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            }
        }
    }

    private fun setIndicator() {
        for (i in 0 until list.size) {
            dots.add(TextView(this))
            dots[i].text = " ● "
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }
}