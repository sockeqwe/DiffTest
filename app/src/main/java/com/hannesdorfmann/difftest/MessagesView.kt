package com.hannesdorfmann.difftest

import com.hannesdorfmann.difftest.model.Message
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 *
 *
 * @author Hannes Dorfmann
 */
interface MessagesView : MvpView {
  
  fun addMessages(messages : List<Message>)
}