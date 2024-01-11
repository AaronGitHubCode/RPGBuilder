package app.rpgbuilder.tmpkt.activities

import app.rpgbuilder.R

import android.os.Bundle

import android.provider.MediaStore.ACTION_PICK_IMAGES

import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.graphics.Bitmap

import android.widget.ImageView

import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment

class SceneBuilderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.scene_builder_layout, container, false).let { view ->
            view.findViewById<ImageView>(R.id.image_view_selector).let { imageView ->
                imageView.setOnClickListener {
                    it as ImageView

                    lateinit var bitmap: Bitmap

                    val appCompat = view.context as AppCompatActivity

                    appCompat.registerForActivityResult(StartActivityForResult()) {
                        val intent = it?.data

                        bitmap = intent?.extras?.get("image") as Bitmap
                    }.launch(Intent(
                            ACTION_PICK_IMAGES
                        )
                    )

                    bitmap.let { bm ->
                        it.setImageBitmap(bm)
                    }
                }
            }

            view
        }
    }
}