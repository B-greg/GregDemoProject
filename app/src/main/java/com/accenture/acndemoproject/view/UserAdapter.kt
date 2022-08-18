package com.accenture.acndemoproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.accenture.acndemoproject.R

class UserAdapter(private var _users: ArrayList<User>, private val callback: UserAdapterInterface):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_adapter, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = _users[position]

        if(holder is UserViewHolder){
           holder.nameTextView.text = user.name
            holder.lastnameTextView.text = user.lastName
            holder.view.setOnClickListener { callback.onUserClick(user) }
        }
    }

    override fun getItemCount(): Int {
        return _users.size
    }

    fun setUsersList(users: List<User>){
        _users = ArrayList(users)
        notifyDataSetChanged()
    }

    fun addUser(user: User){
        _users.add(user)
        notifyItemChanged(_users.size)
    }


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(
        itemView
    ) {

        var nameTextView: TextView
        var lastnameTextView: TextView
        var view: ConstraintLayout

        init {
            nameTextView = itemView.findViewById(R.id.textView_name)
            lastnameTextView = itemView.findViewById(R.id.textView_lastname)
            view = itemView.findViewById(R.id.constraint_user_adapter)
        }
    }
}

interface UserAdapterInterface{
    fun onUserClick(user: User)
}