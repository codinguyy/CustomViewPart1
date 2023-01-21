package app.codinguyy.numberpicker.numberpicker

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout

class NumberPicker : FrameLayout {

    /**
     * Membervariables
     */

    val numberPickerContainer by lazy {
        context?.let {
            LinearLayout(it)
        }
    }
    val numberPickerView by lazy {
        context?.let {
            NumberPickerView(it)
        }
    }

    /**
     * Constructors
     */
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        init()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        // Add all the children
        addChildViews()
    }

    private fun addChildViews() {
        numberPickerContainer?.addView(numberPickerView) // Adding the view to the linearlayout
        addView(numberPickerContainer) // Adding the linearlayout to the framelayout
    }
}
