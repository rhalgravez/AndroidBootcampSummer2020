package com.raywenderlich.bootcamp.businesscard

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val QUOTE_INDEX_KEY = "QUOTE_INDEX_KEY"
    }

    private val quotes = listOf(
        Pair(R.drawable.homer, "You\'ll have to speak up, I'm wearing a towel."),
        Pair(R.drawable.shinji,"Pilot the eva Shinji or Rei will have to do it again."),
        Pair(R.drawable.daffy,"Duck season! FIRE!"),
        Pair(R.drawable.iron_giant,"Superman!!!")
    )

    private var currentImageAndQuoteIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val savedQuoteIndex = savedInstanceState.getInt(QUOTE_INDEX_KEY)
            selectQuote(savedQuoteIndex)
        } else {
            selectQuote()
        }

        quoteButton.setOnClickListener { view ->
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)
            selectQuote()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(QUOTE_INDEX_KEY, currentImageAndQuoteIndex)
    }

    private fun selectQuote(index: Int? = null) {
        currentImageAndQuoteIndex = index ?: quotes.indices.random()
        val (image, quote) = quotes[currentImageAndQuoteIndex]
        quoteImageView.setImageResource(image)
        quoteTextView.text = quote
    }

    //region Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionAbout) {
            showAlertDialog()
        }
        return true
    }

    private fun showAlertDialog() {
        val dialogTitle = getString(R.string.alertDialogTitle, BuildConfig.VERSION_NAME)
        val dialogMessage = getString(R.string.alertDialogMessage)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }
    //endregion

}