package com.example.booknest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var progressBar1: ProgressBar
    private lateinit var progressBar2: ProgressBar
    private lateinit var progressBar3: ProgressBar
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var welcomeText: TextView
    private lateinit var quote: TextView

    private var clickCount = 0
    private val loadingDuration: Long = 2000

    private val welcomeTexts = arrayOf(
        "Discover Unlimited Stories",
        "Read Anytime Anywhere",
        "Your Library, Your Way",
        "Begin Your Reading Adventure"
    )

    private val quotes = arrayOf(
        "“ Explore a vast collection of E-Books across all genres ”",
        "“ Enjoy seamless reading on any device, anytime ”",
        "“ Save favorites, bookmark pages, and personalize your reading experience ”",
        "“ Get started today and dive into a world of knowledge! ”"
    )

    private val images = arrayOf(
        R.drawable.ebook2,
        R.drawable.ebook21,
        R.drawable.ebook22,
        R.drawable.ebook23
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        progressBar1 = findViewById(R.id.progressBar)
        progressBar2 = findViewById(R.id.progressBar2)
        progressBar3 = findViewById(R.id.progressBar3)
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.onboard1)
        welcomeText = findViewById(R.id.welcomeText)
        quote = findViewById(R.id.quote)


        updateUI(0, null)

        button.setOnClickListener {
            clickCount++
            handleProgressBarFilling()
        }
    }

    private fun handleProgressBarFilling() {
        when (clickCount) {
            1 -> updateUI(1, progressBar1)
            2 -> {
                updateUI(2, progressBar2) {
                    // After the second progress bar is filled, start filling the second bar.
                    // Set both progress bars to complete.
                    progressBar1.progress = 100
                    progressBar2.progress = 100
                }
            }
            3 -> {
                updateUI(3, progressBar3) {

                    progressBar1.progress = 100
                    progressBar2.progress = 100

                    runOnUiThread {
                        button.text = "Get Started"
                    }
                }
            }
            4 -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun updateUI(index: Int, progressBar: ProgressBar?, onComplete: (() -> Unit)? = null) {
        if (index < welcomeTexts.size) {
            welcomeText.text = welcomeTexts[index]
            quote.text = quotes[index]
            imageView.setImageResource(images[index])
        }
        progressBar?.let { fillProgressBar(it, onComplete) }
    }

    private fun fillProgressBar(progressBar: ProgressBar, onComplete: (() -> Unit)? = null) {
        progressBar.max = 100
        val interval: Long = loadingDuration / 200

        Thread {
            for (progress in 1..100) {
                runOnUiThread {
                    progressBar.progress = progress
                }
                Thread.sleep(interval)
            }
            onComplete?.invoke()
        }.start()
    }
}
