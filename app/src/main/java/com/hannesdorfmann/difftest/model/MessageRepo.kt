package com.hannesdorfmann.difftest.model

import android.util.Log
import rx.Observable
import java.util.ArrayList
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 *
 *
 * @author Hannes Dorfmann
 */
class MessageRepo {

  private val messages = ArrayList<Message>()

  fun getMessages(): Observable<List<Message>> {
    return Observable.defer {
      Observable.interval(0, 1, TimeUnit.SECONDS)
          .map { number ->
            messages.add(Message("Hello World $number", Date()))
            ArrayList(messages) as List<Message>
          }
    }
  }
}