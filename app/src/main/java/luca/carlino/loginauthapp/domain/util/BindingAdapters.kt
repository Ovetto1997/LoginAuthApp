package luca.carlino.loginauthapp.domain.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun errorText(layout: TextInputLayout, error: String?) {
    layout.error = error
    layout.isErrorEnabled = !error.isNullOrBlank()
}


@BindingAdapter("drawableByName")
fun drawableByName(imageView: ImageView, resName: String?) {
    if(resName.isNullOrBlank()) return
    val resId = imageView.resources.getIdentifier(
        resName, "drawable", imageView.context.packageName
    )
    if (resId != 0) {
        return imageView.setImageResource(resId)
    }
}


