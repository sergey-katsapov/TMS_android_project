package com.example.tms_android_project.ui.presentation.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * TODO Refactor
 * - add companion object
 * - apply kotlin
 * - single responsibility
 * - naming parameters
 * - use internal - и изучить что это
 *
 */
internal class SmileView(context: Context, attributes: AttributeSet) : View(context, attributes){

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK

    private var borderWidth = 4.0f

    //TODO do homework?
    private var size = 320


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //TODO зависит от задачи
        size = Math.min(measuredWidth, measuredHeight)

        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size / 2f

        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        paint.apply {
            color = eyesColor
            style = Paint.Style.FILL
        }

        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEyeRect, paint)
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        val mouthPath = Path()
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(mouthPath, paint)
    }
}