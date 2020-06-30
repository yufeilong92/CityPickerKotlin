package com.example.myapplication

import android.app.Activity
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {
    private var expression = ""
    private var last_equal = false //上一次的按键是否为等号

    private var isSimple = true //当前是否是简易计算器
    private var screen_width = 0
    private var screen_height = 0
    private var buttons: Array<Button?>?=null
    private var buttons2: Array<Button?>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        change.setOnClickListener {
            //更换键盘

            //更换键盘
            if (isSimple == true) {
                //缩放动画效果
                board.visibility = View.INVISIBLE
                board2.visibility = View.VISIBLE
                val sa = ScaleAnimation(
                    1.2f, 1f, 1.2f, 1f,
                    Animation.RELATIVE_TO_SELF, 1f,
                    Animation.RELATIVE_TO_SELF, 1f
                )
                sa.duration = 300
                board2.startAnimation(sa)
                isSimple = false
            } else {
                val sa = ScaleAnimation(
                    1f, 1.25f, 1f, 1.2f,
                    Animation.RELATIVE_TO_SELF, 1f,
                    Animation.RELATIVE_TO_SELF, 1f
                )
                sa.duration = 300
                board2.startAnimation(sa)
                board2.visibility = View.INVISIBLE
                board.visibility = View.VISIBLE
                isSimple = true
            }
        }


        //初始化计算器键盘
        buttons = arrayOfNulls< Button>(18)
        buttons2 = arrayOfNulls< Button>(30)
        initSimpleBoard(buttons = buttons!!)//初始化简易计算器键盘
        initScienceBoard(buttons2!!) //初始化科学计算器键盘
        savedInstanceState?.let {
            text1.setText(savedInstanceState.getString("text1"))
            text2.setText(savedInstanceState.getString("text2"))
            isSimple = savedInstanceState.getBoolean("isSimple")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text1", text1.text.toString())
        outState.putString("text2", text2.text.toString())
        outState.putBoolean("isSimple", isSimple)
    }

    //初始化简易计算器键盘
    private fun initSimpleBoard(buttons: Array<Button?>) {
        buttons[0] = findViewById(R.id.zero) as Button
        buttons[1] = findViewById(R.id.one) as Button
        buttons[2] = findViewById(R.id.two) as Button
        buttons[3] = findViewById(R.id.three) as Button
        buttons[4] = findViewById(R.id.four) as Button
        buttons[5] = findViewById(R.id.five) as Button
        buttons[6] = findViewById(R.id.six) as Button
        buttons[7] = findViewById(R.id.seven) as Button
        buttons[8] = findViewById(R.id.eight) as Button
        buttons[9] = findViewById(R.id.nine) as Button
        buttons[10] = findViewById(R.id.empty) as Button
        buttons[11] = findViewById(R.id.delete) as Button
        buttons[12] = findViewById(R.id.divide) as Button
        buttons[13] = findViewById(R.id.multiple) as Button
        buttons[14] = findViewById(R.id.minus) as Button
        buttons[15] = findViewById(R.id.plus) as Button
        buttons[16] = findViewById(R.id.equal) as Button
        buttons[17] = findViewById(R.id.dot) as Button
        initCommonBtns(buttons)
    }

    //初始化科学计算器键盘
    private fun initScienceBoard(buttons: Array<Button?>) {
        buttons[0] = findViewById(R.id.zero2) as Button
        buttons[1] = findViewById(R.id.one2) as Button
        buttons[2] = findViewById(R.id.two2) as Button
        buttons[3] = findViewById(R.id.three2) as Button
        buttons[4] = findViewById(R.id.four2) as Button
        buttons[5] = findViewById(R.id.five2) as Button
        buttons[6] = findViewById(R.id.six2) as Button
        buttons[7] = findViewById(R.id.seven2) as Button
        buttons[8] = findViewById(R.id.eight2) as Button
        buttons[9] = findViewById(R.id.nine2) as Button
        buttons[10] = findViewById(R.id.empty2) as Button
        buttons[11] = findViewById(R.id.delete2) as Button
        buttons[12] = findViewById(R.id.divide2) as Button
        buttons[13] = findViewById(R.id.multiple2) as Button
        buttons[14] = findViewById(R.id.minus2) as Button
        buttons[15] = findViewById(R.id.plus2) as Button
        buttons[16] = findViewById(R.id.equal2) as Button
        buttons[17] = findViewById(R.id.dot2) as Button
        initCommonBtns(buttons)


        //初始化剩余的12个按钮
        buttons[18] = findViewById(R.id.sin) as Button
        buttons[19] = findViewById(R.id.cos) as Button
        buttons[20] = findViewById(R.id.tan) as Button
        buttons[21] = findViewById(R.id.ln) as Button
        buttons[22] = findViewById(R.id.log) as Button
        buttons[23] = findViewById(R.id.factorial) as Button
        buttons[24] = findViewById(R.id.power) as Button
        buttons[25] = findViewById(R.id.sqrt) as Button
        buttons[26] = findViewById(R.id.pi) as Button
        buttons[27] = findViewById(R.id.left_parentheses) as Button
        buttons[28] = findViewById(R.id.right_parentheses) as Button
        buttons[29] = findViewById(R.id.e) as Button
        buttons[18]!!.setOnClickListener {
            expression += buttons[18]!!.text.toString() + "("
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[19]!!.setOnClickListener {
            expression += buttons[19]!!.text.toString() + "("
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[20]!!.setOnClickListener {
            expression += buttons[20]!!.text.toString() + "("
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[21]!!.setOnClickListener {
            expression += buttons[21]!!.text.toString() + "("
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[22]!!.setOnClickListener {
            expression += buttons[22]!!.text.toString() + "("
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[23]!!.setOnClickListener {
            expression += buttons[23]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[24]!!.setOnClickListener {
            expression += buttons[24]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[25]!!.setOnClickListener {
            expression += buttons[25]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[26]!!.setOnClickListener {
            expression += buttons[26]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[27]!!.setOnClickListener {
            expression += buttons[27]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[28]!!.setOnClickListener {
            expression += buttons[28]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        buttons[29]!!.setOnClickListener {
            expression += buttons[29]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
    }

    //初始化简易计算器，科学计算器相同的18个按钮
    private fun initCommonBtns(buttons: Array<Button?>) {
        //添加监听事件
        //数字0～9
        for (i in 0..9) {
            buttons[i]!!.setOnClickListener {
                if (last_equal) {
                    expression = "" //这次按的数字，如果上次按了等号，则清空表达式
                    last_equal = false
                }
                expression += buttons[i]!!.text
                text2.setText(expression)
                text2.setSelection(expression.length)
            }
        }
        //empty
        buttons[10]!!.setOnClickListener {
            expression = ""
            text2.setText("0")
            text1.setText(null)
            last_equal = false
        }
        //delete
        buttons[11]!!.setOnClickListener(View.OnClickListener {
            if (expression.length < 1) {
                return@OnClickListener
            }
            expression = expression.substring(0, expression.length - 1)
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        })
        //divide
        buttons[12]!!.setOnClickListener {
            expression += buttons[12]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        //multiple
        buttons[13]!!.setOnClickListener {
            expression += buttons[13]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        //minus
        buttons[14]!!.setOnClickListener {
            expression += buttons[14]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        //plus
        buttons[15]!!.setOnClickListener {
            expression += buttons[15]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
        //equal
        buttons[16]!!.setOnClickListener(View.OnClickListener {
            if (last_equal) return@OnClickListener  //如果上次还是按的等号，那么什么也不做

            //小小的动画效果
            val animSet = AnimationSet(true)
            val ta = TranslateAnimation(0f, 0f, 0f, -100f)
            ta.duration = 80
            val aa = AlphaAnimation(1f, 0f)
            aa.duration = 75
            animSet.addAnimation(ta)
            animSet.addAnimation(aa)
            text2.startAnimation(animSet)
            animSet.setAnimationListener(object :
                Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    //动画结束之后计算
                    text1.setText("$expression=")
                    text1.setSelection(expression.length + 1) //在第一行显示计算表达式
                    try {
                        expression = Calculate.calculate(expression)
                        text2.setText(expression) //在第二行显示计算结果
                    } catch (exception: Exception) {
                        text2.setText("表达式错误!") //在第二行显示计算结果
                        expression = ""
                    }
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })


            // 为下一次按计算器键盘做准备。
            // 如果下次按的是数字，那么清空第二行重新输入第一个数。
            // 如果是非数字，那就当这次的结果是输入的第一个数，直接参与运算。
            last_equal = true
        })
        buttons[17]!!.setOnClickListener {
            expression += buttons[17]!!.text
            text2.setText(expression)
            text2.setSelection(expression.length)
            last_equal = false
        }
    }

    //初始化键盘，显示区域的宽和高（显示区域包括change按钮，text，text2）
    private fun initWidthAndHeight() {
        //设置change按钮和显示区域的高度只和 始终为用户区域高度的三分之一
        val lp: ViewGroup.LayoutParams = ll_display.getLayoutParams()
        lp.height = screen_height / 3

        //简易计算器
        val btn_width = screen_width / 4
        val btn_height = (screen_height - screen_height / 3) / 5 //tablelayout为屏幕的2/3大，一共5行
        for (i in 0..17) {
            buttons!![i]!!.width = btn_width
            buttons!![i]!!.height = btn_height
        }
        buttons!![0]!!.width = btn_width * 2
        buttons!![16]!!.height = btn_height * 2

        //科学计算器
        //让每个科学计算器的按钮的高度为tablelayout的1/6
        for (i in buttons2!!.indices) {
            buttons2!![i]!!.height = screen_height * 2 / 3 / 6
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {

            val dimen1: Dimension? = getAreaOne(this)
            val dimen2: Dimension? = getAreaTwo(this)
            val dimen3: Dimension? = getAreaThree(this)
            Log.v(
                "one=>",
                """Area one : 
	Width: ${dimen1?.mWidth};	Height: ${dimen1?.mHeight}"""
            )
            Log.v(
                "two=>",
                """
Area two: 
	Width: ${dimen2?.mWidth};	Height: ${dimen2?.mHeight}"""
            )
            Log.v(
                "three",
                """
Area three: 
	Width: ${dimen3?.mWidth};	Height: ${dimen3?.mHeight}"""
            )

            Log.v("TAG", "---isSimple=>>" + isSimple)
            screen_width = dimen3!!.mWidth
            screen_height = dimen3!!.mHeight
            initWidthAndHeight()
        }
    }

    private fun getAreaOne(activity: Activity): Dimension? {
        val dimen: Dimension = Dimension()
        val disp = activity.windowManager.defaultDisplay
        val outP = Point()
        disp.getSize(outP)
        dimen.mWidth = outP.x
        dimen.mHeight = outP.y
        return dimen
    }

    //不算状态栏的高度
    private fun getAreaTwo(activity: Activity): Dimension? {
        val dimen = Dimension()
        val outRect = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(outRect)
        println("top:" + outRect.top + " ; left: " + outRect.left)
        dimen.mWidth = outRect.width()
        dimen.mHeight = outRect.height()
        return dimen
    }

    //不算状态栏，标题栏的高度
    private fun getAreaThree(activity: Activity): Dimension? {
        val dimen = Dimension()
        // 用户绘制区域
        val outRect = Rect()
        activity.window.findViewById<View>(Window.ID_ANDROID_CONTENT)
            .getDrawingRect(outRect)
        dimen.mWidth = outRect.width()
        dimen.mHeight = outRect.height()
        // end
        return dimen
    }

    private class Dimension {
        var mWidth = 0
        var mHeight = 0
    }


}
