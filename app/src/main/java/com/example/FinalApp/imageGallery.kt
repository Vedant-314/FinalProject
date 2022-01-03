package com.example.FinalApp

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class imageGallery : AppCompatActivity() {

    lateinit var filepath: Uri

    val picRef= FirebaseStorage.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_gallery)

        val image1=findViewById<Button>(R.id.selectImagebtn)


        image1.setOnClickListener{
            startfileChooser()
        }

        val upload=findViewById<Button>(R.id.UploadimageBtn)

        upload.setOnClickListener{
            uploadFile()
        }

        val view=findViewById<Button>(R.id.viewimage)

        view.setOnClickListener{
            listFiles()
        }
    }



    private fun uploadFile(){
        if(filepath!=null){
            var pd= ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.show()
            val formatter=SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
            val now= Date()
            val fileName=formatter.format(now)

            var  imageref = FirebaseStorage.getInstance().reference.child("image/${fileName}")
            imageref.putFile(filepath)
                    .addOnSuccessListener {p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext, "Image Uploaded", Toast.LENGTH_SHORT).show()

                    }
                    .addOnFailureListener {p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext,p0.message, Toast.LENGTH_SHORT).show()
                    }
                    .addOnProgressListener {p0 ->
                        var progress=(100 * p0.bytesTransferred)/p0.totalByteCount
                        pd.setMessage("Uploaded ${progress.toInt()}%")
                    }
        }
    }

    private fun listFiles() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val images = picRef.child("image/").listAll()
            val imageUrls = mutableListOf<String>()
            for(image in images.result?.items!!) {
                val url = image.downloadUrl
                imageUrls.add(url.toString())
            }
            withContext(Dispatchers.Main) {
                val imageAdapter = ImageAdapter(imageUrls)
                val rvi=findViewById<ImageView>(R.id.ivImage)
                val recyclerview:RecyclerView=findViewById(R.id.rvImages)
                rvi.apply {
                    recyclerview.adapter=imageAdapter
                    recyclerview.layoutManager=LinearLayoutManager(this@imageGallery)

                }
            }
        } catch(e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@imageGallery, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }



    private fun startfileChooser(){
        var i= Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i,"Choose Picture"),111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==111 && resultCode==Activity.RESULT_OK && data != null){
            filepath=data.data!!
            var bitmap=MediaStore.Images.Media.getBitmap(contentResolver,filepath)

            val image2=findViewById<ImageView>(R.id.firebaseimage)

            image2.setImageBitmap(bitmap)
        }
    }
}