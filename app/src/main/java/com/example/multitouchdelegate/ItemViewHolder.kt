package com.example.multitouchdelegate

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemViewHolder: ViewHolder {

    constructor(itemView: View): super(itemView) {
        val button1: Button = itemView.findViewById(R.id.button1)
        val button2: Button = itemView.findViewById(R.id.button2)
        TouchDelegateUtils.expandTouchAreaViews(itemView, button1, button2)
    }

}