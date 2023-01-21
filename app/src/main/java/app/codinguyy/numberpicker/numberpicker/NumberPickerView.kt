package app.codinguyy.numberpicker.numberpicker

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.CheckResult
import androidx.annotation.ColorInt

class NumberPickerView : View {

    /**
     * Attributes of the view
     */
    @get:ColorInt
    @get:CheckResult
    var textColor: Int = Color.WHITE
    var textSize = 50
    var textPaint = Paint()

    constructor(context: Context?) : super(context) {
        refreshPaint()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        refreshPaint()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        refreshPaint()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        refreshPaint()
    }

    fun refreshPaint() {
        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = textColor
        textPaint.textSize = textSize.toFloat()
        textPaint.textAlign = Paint.Align.CENTER

        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            drawText(it, 10)
        }
    }

    private fun drawText(canvas: Canvas, value: Int) {
        canvas.drawText(value.toString(), 100F, 100F, textPaint)
    }
}
