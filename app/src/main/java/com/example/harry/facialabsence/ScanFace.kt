package com.example.harry.facialabsence

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.face.FirebaseVisionFaceContour
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_scan_face.*


class ScanFace : AppCompatActivity(), View.OnClickListener {

    // Real-time contour detection of multiple faces
    var realTimeOpts = FirebaseVisionFaceDetectorOptions.Builder()
            .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
            .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_face)


        Picasso.get().load("https://specials-images.forbesimg.com/imageserve/583470854bbe6f1f20e791d5/416x416.jpg?background=000000&cropX1=214&cropX2=499&cropY1=71&cropY2=356").into(result_bitmap);

        btn_scan.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        val id = v?.id

        when (id) {
            R.id.btn_scan -> {
                val drawable = result_bitmap.getDrawable() as BitmapDrawable
                val bitmap = drawable.bitmap
                val image = FirebaseVisionImage.fromBitmap(bitmap)

                val detector = FirebaseVision.getInstance()
                        .getVisionFaceDetector(realTimeOpts)
                val result = detector.detectInImage(image)
                        .addOnSuccessListener { faces ->
                            // Task completed successfully
                            // ...
                            faces.forEach {
                                val contour = it.getContour(FirebaseVisionFaceContour.FACE)
                                contour.points.forEach {
                                    println("Point at ${it.x}, ${it.y}")
                                }

                                // More code here
                                val mutableBitmap =
                                        bitmap.copy(
                                                Bitmap.Config.ARGB_8888, true
                                        )
                                val canvas = Canvas(mutableBitmap)

                                val myPaint = Paint(Paint.ANTI_ALIAS_FLAG)
                                myPaint.color = Color.parseColor("#99ff0000")

                                val path = Path()
                                path.moveTo(contour.points[0].x, contour.points[0].y)
                                contour.points.forEach {
                                    path.lineTo(it.x, it.y)
                                }
                                path.close()

                                canvas.drawPath(path, myPaint)
                                result_bitmap.setImageBitmap(mutableBitmap)
                            }

                        }
                        .addOnCompleteListener {
                            var markedBitmap =
                                    bitmap.copy(Bitmap.Config.ARGB_8888, true)
                            val canvas = Canvas(markedBitmap)
                            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                            paint.color = Color.parseColor("#99003399")


                            it.result!!.forEach {
                                canvas.drawRect(it.boundingBox, paint)
                                val resultBitmap:Bitmap = Bitmap.createBitmap(bitmap,it.boundingBox.left,it.boundingBox.top,it.boundingBox.width(),it.boundingBox.height())
                                result_crop_bitmap.setImageBitmap(resultBitmap)
                            }

                            runOnUiThread {
                                result_bitmap.setImageBitmap(markedBitmap)

                            }
                        }

                        .addOnFailureListener(
                                object : OnFailureListener {
                                    override fun onFailure(e: Exception) {
                                        // Task failed with an exception
                                        // ...
                                    }
                                })
            }
        }

    }


}
