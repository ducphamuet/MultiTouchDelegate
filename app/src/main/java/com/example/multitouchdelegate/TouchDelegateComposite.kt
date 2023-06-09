package com.example.multitouchdelegate

import android.graphics.Rect
import android.view.MotionEvent
import android.view.TouchDelegate
import android.view.View

class TouchDelegateComposite(view: View) : TouchDelegate(Rect(), view) {

    private val delegates: MutableList<TouchDelegate> = ArrayList()

    fun addDelegate(delegate: TouchDelegate) {
        delegates.add(delegate)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var res = false
        val x = event.x
        val y = event.y
        for (delegate in delegates) {
            event.setLocation(x, y)
            res = delegate.onTouchEvent(event) || res
        }
        return res
    }
}