package com.example.enidemo.demolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.enidemo.Person
import com.example.enidemo.databinding.PersonLineBinding

class PersonsDiffCallback : DiffUtil.ItemCallback<Person> (){
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.firstname == newItem.firstname
    }
}

class PersonsAdapter : ListAdapter<Person, PersonsAdapter.ViewHolder>(PersonsDiffCallback()) {

    /**
     * Charger la vue de la cellule et son view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val listItem = PersonLineBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(listItem)
    }

    /**
     * Envoyer/Alimenter/connecter la donnée dans la cellule
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupérer une donnée dans une List ou ArrayList
        val person = getItem(position)

        // Je connecte la donnée à la vue de la cellule
        holder.listItem.person = person

        // Notifier le chargement de la cellule
        holder.listItem.executePendingBindings()
    }

    // Une classe interne pour définir la cellule/ligne afficher dans la liste
    class ViewHolder(val listItem : PersonLineBinding) : RecyclerView.ViewHolder(listItem.root) {

    }
}