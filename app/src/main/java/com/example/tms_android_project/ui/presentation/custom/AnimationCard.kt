package com.example.tms_android_project.ui.presentation.custom

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.setPadding
import com.example.tms_android_project.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AnimationCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var circleSize = 3
    private var lastCircleRightX = 0

    private var scope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    private val linePaint = Paint().apply {
        strokeWidth = 2f
        color = ContextCompat.getColor(context, R.color.black)
    }

    private var rollingEndListener: (Int) -> Unit = {}

    init {
        setWillNotDraw(false) //рисует линицю которую мы указали в инициализации перед анимацией
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        circleSize = measuredWidth / 12  //ширину экрана на 12 моент делим

        val childMeasureSize = MeasureSpec.makeMeasureSpec(circleSize, MeasureSpec.EXACTLY)

        (0 until childCount)
            .map { getChildAt(it) }
            .forEach { view ->
                view.layoutParams.apply {
                    width = circleSize
                    height = circleSize
                }
                view.measure(childMeasureSize, childMeasureSize)
            }

        setMeasuredDimension(measuredWidth, circleSize)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        lastCircleRightX = circleSize
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        if (childCount != 0) {
            getChildAt(childCount - 1).apply {
                layout(measuredWidth, 0, measuredWidth + circleSize, circleSize)
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, circleSize * 0.85f, measuredWidth.toFloat(), circleSize * 0.85f, linePaint)
    }

    fun setRollingEndListener(listener: (Int) -> Unit) {
        rollingEndListener = listener
    }

    fun addCircle(number: Int) {
        //добавляем монетку
        val circle = AppCompatTextView(context).apply {
            setBackgroundResource(R.drawable.koin_ball)
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(PADDING)
            text = number.toString()
        }

        addView(circle)

        ObjectAnimator.ofFloat(measuredWidth.toFloat(), lastCircleRightX.toFloat()).apply {
            duration = ANIMATION_DURATION
           // interpolator = LinearInterpolator()

            addUpdateListener {
                val value = it.animatedValue as? Float ?: 0f //изменение позиции
                circle.x = value //движение монетки
                circle.rotation = value  //вращение монетки  * 4
                //Устанавливает градусы, на которые вид поворачивается вокруг точки поворота. Увеличение значений
                //     * приводит к вращению по часовой стрелке.
            }

            addListener(
                AnimatorHelper(
                    onEnd = {
                        circle.rotation = 0f  //выравнивание монетки
                        lastCircleRightX += circleSize + SPACE //высчитавание последней позиции монетки

                        scope.launch {
                            delay(ANIMATION_DELAY)
                            rollingEndListener(circle.text.toString().toInt()) //вызов результата
                        }
                    }
                )
            )
        }.start()
    }

    //очищение монеток
    fun clearCircles() {
        children.forEach { child ->
            child.apply {
                animation?.setAnimationListener(null)
                animation?.cancel()
                clearAnimation()
            }
        }
        removeAllViews()
        lastCircleRightX = circleSize
    }

    private companion object{
        private const val ANIMATION_DURATION = 700L
        private const val ANIMATION_DELAY = 150L
        private const val PADDING = 6
        private const val SPACE = 4
    }
}
