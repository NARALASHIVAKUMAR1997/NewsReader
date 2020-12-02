package com.example.newsreader

import android.view.View

class EventHandler : IEventHandler {

    private var eventResponseHandler: EventResponseHandler? = null

    fun registerEventListener(event: EventResponseHandler?) {
        eventResponseHandler = event
    }
    override fun onclickHandler(view: View, obj: Any) {
        eventResponseHandler?.eventResponse(view,obj)

    }


}