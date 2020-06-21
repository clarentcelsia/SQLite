package com.example.sqlite_saving_data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_saving_data.R
import com.example.sqlite_saving_data.Student
import java.util.zip.Inflater

class ListAdapter(
    private val listStudents: List<Student>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    //I'M GONNA INFLATE VIEW IN ListViewHolder Class
    //OR YOU CAN INFLATE THIS LATER IN onCreateViewHolder DEPENDS ON WHAT YOU WOULD RATHER BE

    class ListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list, parent, false)) {

        // Preventing NullPointerException for the view
        // I will add null safety check "?" to the object (textview, etc..) -> nullable
        private var tvName: TextView? = null
        private var tvGender: TextView? = null
        private var tvPhone: TextView? = null

        init {
            //this is for initialization
            tvName = itemView.findViewById(R.id.name)
            tvGender = itemView.findViewById(R.id.gender)
            tvPhone = itemView.findViewById(R.id.phone)
        }

        //Binding data students
        fun binding(student: Student){
            //SAFETY CHECK FOR NULLABLE
            tvName?.text = student.name
            tvGender?.text = student.gender
            tvPhone?.text = student.phone
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ListViewHolder(inflater, parent)
    }

    override fun getItemCount() : Int = listStudents.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val stud = listStudents[position]

        //karena sebelumnya sudah buat method binding di class viewholder jadi tinggal panggil
        holder.binding(stud)
    }
}

//IN JAVA
/**
 * class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
 *
 * private List<Students> listStudents;
 *
 * ListAdapter (List<Students> listStudents) {
 *   this.listStudents = listStudents;
 * } --> CONSTRUCTOR
 *
 * class ListViewHolder extends RecyclerView.ViewHolder{
 *
 *      private TextView tvName;
 *      public ListViewHolder(View itemView){
 *
 *            tvName = itemView.find....;
 *      }
 *
 *  }
 *
 *  onCreateViewHolder(...,...,..){
 *      LayoutInflater inflater = LayoutInflater.from(context);
 *  }
 *
 *  onBindViewHolder(int positon, ListViewHolder holder){
 *     Students stud = listStudents.get(position);
 *     holder.tvName.setText(stud.getName);
 *     holder.tvGender.setText(stud.getGender);
 *  }
 * */
