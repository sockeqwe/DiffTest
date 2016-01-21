package com.hannesdorfmann.difftest

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hannesdorfmann.difftest.model.Message
import java.util.ArrayList

/**
 *
 *
 * @author Hannes Dorfmann
 */
class MessageViewHolder(view: View) : ViewHolder(view) {

  val textView: TextView

  init {
    textView = view.findViewById(R.id.text)!! as TextView
  }

}

class MessagesAdapter(context: Context) : RecyclerView.Adapter<MessageViewHolder>() {

  val items = ArrayList<Message>()
  val layoutInflater = LayoutInflater.from(context)

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
    holder.textView.text = items[position].msg
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MessageViewHolder {
    return MessageViewHolder(layoutInflater.inflate(R.layout.item_message, parent, false))
  }
}