package com.hannesdorfmann.difftest

import android.util.Log
import com.hannesdorfmann.difftest.model.Message
import rx.functions.Func1
import java.util.ArrayList

/**
 *
 *
 * @author Hannes Dorfmann
 */
class MessagesDiffFunc : Func1<List<Message>, List<Message>> {

  private var lastKnownList = emptyList<Message>()

  override fun call(list: List<Message>): List<Message> {

    // Compute the difference from previous list to current list
    val diff: List<Message> =
        if (lastKnownList.isEmpty()) {
          list
        } else {
          val lastMessage = lastKnownList.last()
          list.filter { msg -> msg.date.after(lastMessage.date) }
        }

    lastKnownList = list
    return diff
  }
}