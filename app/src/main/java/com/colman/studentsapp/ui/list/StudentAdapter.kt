package com.colman.studentsapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.colman.studentsapp.R
import com.colman.studentsapp.model.Student
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.imageview.ShapeableImageView

class StudentAdapter(
    private var students: List<Student>,
    private val onStudentClick: (Student) -> Unit,
    private val onCheckedChanged: (Student, Boolean) -> Unit,
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    init {
        setHasStableIds(true)
    }

    fun submitList(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return students[position].id.hashCode().toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ShapeableImageView = itemView.findViewById(R.id.studentRowImage)
        private val name: TextView = itemView.findViewById(R.id.studentRowName)
        private val id: TextView = itemView.findViewById(R.id.studentRowId)
        private val checkbox: MaterialCheckBox = itemView.findViewById(R.id.studentRowCheckbox)

        fun bind(student: Student) {
            image.setImageResource(student.imageResId)
            name.text = student.name
            id.text = "ID: ${student.id}"

            checkbox.setOnCheckedChangeListener(null)
            checkbox.isChecked = student.isChecked
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                if (student.isChecked != isChecked) {
                    onCheckedChanged(student, isChecked)
                }
            }

            itemView.setOnClickListener { onStudentClick(student) }
        }
    }
}

