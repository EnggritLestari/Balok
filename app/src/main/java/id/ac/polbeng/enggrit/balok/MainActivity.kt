package id.ac.polbeng.enggrit.balok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.enggrit.balok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener {
            hitungVolumeDanLuas()
        }
    }

    private fun hitungVolumeDanLuas() {
        val panjang = binding.editTextPanjang.text.toString().toDoubleOrNull()
        val lebar = binding.editTextLebar.text.toString().toDoubleOrNull()
        val tinggi = binding.editTextTinggi.text.toString().toDoubleOrNull()

        if (panjang != null && lebar != null && tinggi != null) {
            val volume = panjang * lebar * tinggi
            val luas = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi)
            binding.textViewHasil.text = getString(R.string.hasil_volume_luas, volume, luas)
        } else {
            binding.textViewHasil.text = getString(R.string.error_input)
        }
    }
}