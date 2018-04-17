package info.huamouchen.newim.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import info.huamouchen.newim.R

class MyChatroomAdapter(context: Context, list: List<String>) : RecyclerView.Adapter<MyChatroomViewHolder>() {

    var mContext : Context = context
    var mList : List<String> = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChatroomViewHolder {
        return MyChatroomViewHolder(LayoutInflater.from(mContext).inflate(R.layout.cell_chat_room_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyChatroomViewHolder, position: Int) {
        holder.tv_title.setText(mList.get(position))
    }
}


class MyChatroomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tv_title : TextView

    init {
        tv_title = itemView.findViewById(R.id.tv_chatroom_titler)
    }
}