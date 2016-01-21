package com.hannesdorfmann.difftest.model

import com.hannesdorfmann.difftest.MessagesDiffFunc
import com.hannesdorfmann.difftest.MessagesView
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *
 *
 * @author Hannes Dorfmann
 */
class MessagesPresenter : MvpBasePresenter<MessagesView>() {

  private val messageRepo = MessageRepo()
  private var subscription: Subscription? = null

  override fun attachView(view: MessagesView?) {
    super.attachView(view)

    subscription = messageRepo.getMessages()
        .map(MessagesDiffFunc()) // calculates the difference from previous one
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
          view?.addMessages(it)
        }
  }

  override fun detachView(retainInstance: Boolean) {
    super.detachView(retainInstance)
    if (!retainInstance) subscription?.unsubscribe()
  }

}