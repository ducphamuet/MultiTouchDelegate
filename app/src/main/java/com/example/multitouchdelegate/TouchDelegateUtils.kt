package com.example.multitouchdelegate

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View

object TouchDelegateUtils {
    fun expandTouchArea(parent: View, child: View) {
        parent.post {
            parent.touchDelegate = getTouchDelegate(child)
        }

    }

    fun expandTouchAreaViews(parent: View, vararg children: View) {
        val touchDelegateComposite = TouchDelegateComposite(parent)
        parent.post {
            children.forEach {
                touchDelegateComposite.addDelegate(getTouchDelegate(it))
            }
            parent.touchDelegate = touchDelegateComposite
        }
    }

    private fun getTouchDelegate(view: View): TouchDelegate {
        val delegateArea = Rect()
        view.getHitRect(delegateArea)
        delegateArea.right += 2000
        delegateArea.left -= 2000
        delegateArea.bottom += 2000
        delegateArea.top -= 2000
        return TouchDelegate(delegateArea, view)
    }
}