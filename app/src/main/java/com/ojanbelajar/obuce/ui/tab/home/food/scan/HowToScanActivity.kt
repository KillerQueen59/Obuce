package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.databinding.ActivityHowToScanBinding
import com.ojanbelajar.obuce.ml.MobilenetV110224Quant
import kotlinx.android.synthetic.main.activity_how_to_scan.*
import org.jetbrains.anko.startActivity
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class HowToScanActivity : AppCompatActivity() {

    companion object{
        const val TAG = "tag"
        private const val REQUEST_IMAGE_CAPTURE = 1
        private const val CAMERA_REQUEST_CODE = 100
    }
    private lateinit var binding: ActivityHowToScanBinding
    private lateinit var viewModel: HowToScanViewModel
    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHowToScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filename = "label.txt"
        val labels = application.assets.open(filename).bufferedReader().use {
            it.readText()
        }
        var townlist = labels.split("\n")

        binding.back.setOnClickListener {
            finish()
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HowToScanViewModel::class.java)

        showRecyclerList()

        binding.scanFood.setOnClickListener{
            dispatchTakePictureIntent()
            //startActivity<ScanResultActivity>()
        }
        binding.predictFood.setOnClickListener{
            var resizedbitmap : Bitmap = Bitmap.createScaledBitmap(bitmap,224,224,true)
            var bitmapToByte = TensorImage.fromBitmap(resizedbitmap)
            var  byteBuffer = bitmapToByte.buffer

            val model = MobilenetV110224Quant.newInstance(this)

// Creates inputs for reference.
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.UINT8)
            inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer

            var max_value = getMax(outputFeature0.floatArray)
//            binding.textView.text = outputFeature0.floatArray[outputFeature0.typeSize].toString()
            binding.textView10.text = townlist[max_value]
// Releases model resources if no longer used.
            model.close()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.foodScanIllustration.setImageURI(data?.data)
        val uri: Uri? = data?.data
        try{
            bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,uri)
        }catch (e:Exception){
            Log.e(TAG, "The exception caught while executing the process. (error1)")
            e.printStackTrace();
        }
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            //val imageBitmap = data.extras.get("data") as Bitmap
//            //imageView.setImageBitmap(imageBitmap)
//            startActivity<ScanResultActivity>()
//        }
    }

    private fun dispatchTakePictureIntent() {
        val take_pict = Intent(Intent.ACTION_GET_CONTENT)
        take_pict.type ="image/*"

        startActivityForResult(take_pict, CAMERA_REQUEST_CODE)
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
//            takePictureIntent.resolveActivity(packageManager)?.also {
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//            }
//        }
    }
    private fun getMax(arr:FloatArray):Int{
        var index = 0
        var min = 0.0f

        for (i in 0..1000){
            if (arr[i]>min){
                index = i
                min = arr[i]
            }
        }
        return index
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