package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.databinding.ActivityHowToScanBinding
import kotlinx.android.synthetic.main.activity_how_to_scan.*
import org.jetbrains.anko.startActivity

class HowToScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHowToScanBinding
    private lateinit var viewModel: HowToScanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHowToScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HowToScanViewModel::class.java)

        showRecyclerList()

        binding.scanFood.setOnClickListener{
            dispatchTakePictureIntent()
            //startActivity<ScanResultActivity>()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //val imageBitmap = data.extras.get("data") as Bitmap
            //imageView.setImageBitmap(imageBitmap)
            startActivity<ScanResultActivity>()
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    private fun showRecyclerList() {
        rv_howToScan.layoutManager = LinearLayoutManager(this)
        val listSimpleItemAdapter = ListSimpleItemAdapter(viewModel.steps)
        rv_howToScan.adapter = listSimpleItemAdapter

        listSimpleItemAdapter.setOnItemClickCallback(object: ListSimpleItemAdapter.OnItemClickCallback{
            override fun onItemClicked(data: String) {
            }
        })
    }
}