package com.example.newsreader

import android.view.View
import java.text.FieldPosition

interface EventResponseHandler {
    fun eventResponse(view: View,obj: Any)
}

interface IEventHandler{
    fun onclickHandler(view: View,obj:Any)
}