package com.hannesdorfmann.difftest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hannesdorfmann.difftest.model.Message
import com.hannesdorfmann.difftest.model.MessagesPresenter
import com.hannesdorfmann.mosby.mvp.MvpActivity

class MainActivity : MvpActivity<MessagesView, MessagesPresenter>(), MessagesView {

  lateinit var adapter: MessagesAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    adapter = MessagesAdapter(this)
    val recyclerView = findViewById(R.id.recyclerView)!! as RecyclerView
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = adapter


  }

  override fun createPresenter(): MessagesPresenter = MessagesPresenter()

  override fun addMessages(messages: List<Message>) {
    adapter.items.addAll(0, messages)
    adapter.notifyItemRangeInserted(0, messages.size)
  }
}
