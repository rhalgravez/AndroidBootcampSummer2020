package com.raywenderlich.bootcamp.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val quotes = listOf<Pair<Int, String>>(
        Pair(R.drawable.homer, "You\'ll have to speak up, I'm wearing a towel."),
        Pair(R.drawable.shinji,"Pilot the eva Shinji or Rei will have to do it again."),
        Pair(R.drawable.daffy,"Duck season! FIRE!"),
        Pair(R.drawable.iron_giant,"Superman!!!")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomQuote()

        quoteButton.setOnClickListener { view ->
            randomQuote()
        }
    }

    private fun randomQuote() {
        val (image, randomQuote) = quotes.random()
        quoteImageView.setImageResource(image)
        quoteTextView.text = randomQuote
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